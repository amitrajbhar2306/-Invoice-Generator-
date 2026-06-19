package com.example.invoice_generator.serviceImpl;

import com.example.invoice_generator.entity.Invoice;
import com.example.invoice_generator.entity.InvoiceItem;
import com.example.invoice_generator.service.CalculationService;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;

@Service
public class CalculationServiceImpl implements CalculationService {

    @Override
    public void calculateInvoice(Invoice invoice) {

        BigDecimal subTotal = BigDecimal.ZERO;
        BigDecimal totalGST = BigDecimal.ZERO;

        for (InvoiceItem item : invoice.getItems()) {

            BigDecimal quantity = BigDecimal.valueOf(item.getQuantity());

            BigDecimal total = quantity.multiply(item.getRate());

            item.setTotal(total);

            BigDecimal gst = total
                    .multiply(item.getTaxPercentage())
                    .divide(BigDecimal.valueOf(100), 2, RoundingMode.HALF_UP);

            subTotal = subTotal.add(total);

            totalGST = totalGST.add(gst);
        }

        BigDecimal cgst = totalGST.divide(
                BigDecimal.valueOf(2),
                2,
                RoundingMode.HALF_UP);

        BigDecimal sgst = totalGST.divide(
                BigDecimal.valueOf(2),
                2,
                RoundingMode.HALF_UP);

        invoice.setSubTotal(subTotal);

        invoice.setCgst(cgst);

        invoice.setSgst(sgst);

        invoice.setGrandTotal(
                subTotal.add(cgst).add(sgst)
        );
    }
}