package com.example.invoice_generator.serviceImpl;

import com.example.invoice_generator.config.InvoiceNumberGenerator;
import com.example.invoice_generator.dto.CompanyDTO;
import com.example.invoice_generator.dto.CreateInvoiceRequest;
import com.example.invoice_generator.dto.InvoiceDTO;
import com.example.invoice_generator.dto.InvoiceItemDTO;
import com.example.invoice_generator.entity.Company;
import com.example.invoice_generator.entity.Invoice;
import com.example.invoice_generator.entity.InvoiceItem;
import com.example.invoice_generator.exception.ResourceNotFoundException;
import com.example.invoice_generator.repository.CompanyRepository;
import com.example.invoice_generator.repository.InvoiceRepository;
import com.example.invoice_generator.service.CalculationService;
import com.example.invoice_generator.service.InvoiceService;
import com.example.invoice_generator.util.AmountInWordsUtil;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class InvoiceServiceImpl implements InvoiceService {

    private final InvoiceRepository invoiceRepository;
    private final CompanyRepository companyRepository;
    private final InvoiceNumberGenerator invoiceNumberGenerator;
    private final CalculationService calculationService;



    @Override
    public InvoiceDTO createInvoice(CreateInvoiceRequest request) {

        // Save Company
        Company company = new Company();

        company.setCompanyName(request.getCompany().getCompanyName());
        company.setGstNumber(request.getCompany().getGstNumber());
        company.setAddress(request.getCompany().getAddress());
        company.setEmail(request.getCompany().getEmail());
        company.setPhone(request.getCompany().getPhone());
        company.setBankName(request.getCompany().getBankName());
        company.setAccountNumber(request.getCompany().getAccountNumber());
        company.setIfscCode(request.getCompany().getIfscCode());
        company.setBranch(request.getCompany().getBranch());

        company = companyRepository.save(company);

        // Create Invoice
        Invoice invoice = new Invoice();

        invoice.setInvoiceNumber(invoiceNumberGenerator.generateInvoiceNumber());

        invoice.setInvoiceDate(request.getInvoiceDate());

        // Client Details
        invoice.setClientName(request.getClient().getClientName());
        invoice.setClientGST(request.getClient().getClientGST());
        invoice.setClientAddress(request.getClient().getClientAddress());
        invoice.setClientEmail(request.getClient().getClientEmail());
        invoice.setClientPhone(request.getClient().getClientPhone());

        // Shipping Details
        invoice.setShippingPort(request.getShipping().getShippingPort());
        invoice.setDeliveryTerms(request.getShipping().getDeliveryTerms());

        invoice.setCompany(company);

        // Invoice Items
        List<InvoiceItem> items = new ArrayList<>();

        for (InvoiceItemDTO itemDTO : request.getItems()) {

            InvoiceItem item = new InvoiceItem();

            item.setItemName(itemDTO.getItemName());
            item.setHsnCode(itemDTO.getHsnCode());
            item.setQuantity(itemDTO.getQuantity());
            item.setRate(itemDTO.getRate());
            item.setTaxPercentage(itemDTO.getTaxPercentage());

            item.setInvoice(invoice);

            items.add(item);
        }

        invoice.setItems(items);

        // Calculate Totals
        calculationService.calculateInvoice(invoice);

        invoice.setAmountInWords(
                AmountInWordsUtil.convert(invoice.getGrandTotal())
        );

        Invoice savedInvoice = invoiceRepository.save(invoice);

        return mapToDTO(savedInvoice);
    }

    @Override
    public InvoiceDTO getInvoice(Long id) {

        Invoice invoice = invoiceRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Invoice not found"));

        return mapToDTO(invoice);
    }

    @Override
    public List<InvoiceDTO> getAllInvoices() {

        return invoiceRepository.findAll()
                .stream()
                .map(this::mapToDTO)
                .toList();
    }

    @Override
    public void deleteInvoice(Long id) {

        Invoice invoice = invoiceRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Invoice not found"));

        invoiceRepository.delete(invoice);
    }

    private InvoiceDTO mapToDTO(Invoice invoice) {

        InvoiceDTO dto = new InvoiceDTO();

        dto.setId(invoice.getId());
        dto.setInvoiceNumber(invoice.getInvoiceNumber());
        dto.setInvoiceDate(invoice.getInvoiceDate());

        dto.setClientName(invoice.getClientName());
        dto.setClientGST(invoice.getClientGST());
        dto.setClientAddress(invoice.getClientAddress());
        dto.setClientEmail(invoice.getClientEmail());
        dto.setClientPhone(invoice.getClientPhone());

        dto.setShippingPort(invoice.getShippingPort());
        dto.setDeliveryTerms(invoice.getDeliveryTerms());

//        dto.setCompanyId(invoice.getCompany().getId());
        CompanyDTO companyDTO = new CompanyDTO();

        companyDTO.setCompanyName(invoice.getCompany().getCompanyName());
        companyDTO.setGstNumber(invoice.getCompany().getGstNumber());
        companyDTO.setAddress(invoice.getCompany().getAddress());
        companyDTO.setEmail(invoice.getCompany().getEmail());
        companyDTO.setPhone(invoice.getCompany().getPhone());
        companyDTO.setBankName(invoice.getCompany().getBankName());
        companyDTO.setAccountNumber(invoice.getCompany().getAccountNumber());
        companyDTO.setIfscCode(invoice.getCompany().getIfscCode());
        companyDTO.setBranch(invoice.getCompany().getBranch());

        dto.setCompany(companyDTO);

        dto.setSubTotal(invoice.getSubTotal());
        dto.setCgst(invoice.getCgst());
        dto.setSgst(invoice.getSgst());
        dto.setGrandTotal(invoice.getGrandTotal());

        dto.setAmountInWords(invoice.getAmountInWords());

        List<InvoiceItemDTO> itemDTOs = invoice.getItems()
                .stream()
                .map(item -> {

                    InvoiceItemDTO itemDTO = new InvoiceItemDTO();

                    itemDTO.setId(item.getId());
                    itemDTO.setItemName(item.getItemName());
                    itemDTO.setHsnCode(item.getHsnCode());
                    itemDTO.setQuantity(item.getQuantity());
                    itemDTO.setRate(item.getRate());
                    itemDTO.setTaxPercentage(item.getTaxPercentage());

                    return itemDTO;

                }).toList();

        dto.setItems(itemDTOs);

        return dto;
    }
}