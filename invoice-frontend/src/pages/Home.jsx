import React from 'react'
import { useState } from "react";
import Navbar from "../components/Navbar";
import CompanyForm from "../components/CompanyForm";
import ClientForm from "../components/ClientForm";
import ShippingForm from "../components/ShippingForm";
import InvoiceItems from "../components/InvoiceItems";
import InvoiceSummary from "../components/InvoiceSummary";
import { createInvoice } from "../services/invoiceService";
import "../css/home.css";

function Home() {

const handleSave = async () => {

    try {

        const response = await createInvoice(invoice);

        console.log(response);

        alert("Invoice Created Successfully");

    } catch (error) {

        console.error(error);

        alert("Something went wrong");

    }

};

    const [invoice, setInvoice] = useState({

        company: {
            companyName: "",
            gstNumber: "",
            email: "",
            phone: "",
            address: "",
            bankName: "",
            accountNumber: "",
            ifscCode: "",
            branch: ""
        },

        client: {
            clientName: "",
            clientGST: "",
            clientEmail: "",
            clientPhone: "",
            clientAddress: ""
        },

        shipping: {
            shippingPort: "",
            deliveryTerms: ""
        },

        invoiceDate: new Date().toISOString().split("T")[0],

        items: [
    {
        itemName: "",
        hsnCode: "",
        quantity: 1,
        rate: 0,
        taxPercentage: 18,
        total: 0
    }
]

    });

    const calculateTotals = () => {

    const subTotal = invoice.items.reduce((sum, item) => {
        return sum + Number(item.total);
    }, 0);

    const totalGST = invoice.items.reduce((sum, item) => {
        return sum + (Number(item.total) * Number(item.taxPercentage)) / 100;
    }, 0);

    const cgst = totalGST / 2;
    const sgst = totalGST / 2;

    const grandTotal = subTotal + cgst + sgst;

    return {
        subTotal,
        cgst,
        sgst,
        grandTotal
    };

};

const totals = calculateTotals();

    return (

        <>
            <Navbar />

            <div className="home">

                <div className="invoice-card">

                    <h1>Create Invoice</h1>

           <div className="date-section">

             <label>Invoice Date</label>

               <input
                type="date"
                value={invoice.invoiceDate}
                onChange={(e) =>
                setInvoice({
                ...invoice,
                invoiceDate: e.target.value
            })
        }
    />

           </div>              

                    <CompanyForm
                        invoice={invoice}
                        setInvoice={setInvoice}
                    />

                    <ClientForm
                        invoice={invoice}
                        setInvoice={setInvoice}
                    />

                    <ShippingForm
                        invoice={invoice}
                        setInvoice={setInvoice}
                    />


                    <InvoiceItems
                        invoice={invoice}
                        setInvoice={setInvoice}
                    />

                    <InvoiceSummary totals={totals}/>

                    <button
                      className="save-btn"
                      onClick={handleSave}
                     >
                     Save Invoice
                       </button>                  

                </div>

            </div>

        </>

    );

}

export default Home;
