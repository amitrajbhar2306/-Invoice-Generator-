import React from 'react'
import { useEffect, useState } from "react";
import { useParams } from "react-router-dom";
import Navbar from "../components/Navbar";
import { getInvoiceById } from "../services/invoiceService";
import "../css/invoiceView.css";

function InvoiceView() {

    const { id } = useParams();

    const [invoice, setInvoice] = useState(null);

    useEffect(() => {

        loadInvoice();

    }, []);

    const loadInvoice = async () => {

        try {

            const response = await getInvoiceById(id);

            setInvoice(response);

        } catch (error) {

            console.error(error);

        }

    };

    if (!invoice) {

        return (
            <>
                <Navbar />
                <div className="loading">
                    Loading Invoice...
                </div>
            </>
        );

    }

    return (

        <>
            <Navbar />

            <div className="invoice-view">

                <div className="invoice-header">

                    <h1>Invoice</h1>

                    <button
                        className="print-btn"
                        onClick={() => window.print()}
                    >
                        Print
                    </button>

                </div>

                <div className="section">

                    <h2>Invoice Details</h2>

                    <p><strong>Invoice No:</strong> {invoice.invoiceNumber}</p>

                    <p><strong>Date:</strong> {invoice.invoiceDate}</p>

                </div>

                <div className="section">

                    <h2>Company Details</h2>

                    <p><strong>Name:</strong> {invoice.company.companyName}</p>

                    <p><strong>GST:</strong> {invoice.company.gstNumber}</p>

                    <p><strong>Email:</strong> {invoice.company.email}</p>

                    <p><strong>Phone:</strong> {invoice.company.phone}</p>

                    <p><strong>Address:</strong> {invoice.company.address}</p>

                </div>

                <div className="section">

                    <h2>Client Details</h2>

                    <p><strong>Name:</strong> {invoice.clientName}</p>

                    <p><strong>GST:</strong> {invoice.clientGST}</p>

                    <p><strong>Email:</strong> {invoice.clientEmail}</p>

                    <p><strong>Phone:</strong> {invoice.clientPhone}</p>

                    <p><strong>Address:</strong> {invoice.clientAddress}</p>

                </div>

                <div className="section">

                    <h2>Shipping Details</h2>

                    <p><strong>Port:</strong> {invoice.shippingPort}</p>

                    <p><strong>Delivery Terms:</strong> {invoice.deliveryTerms}</p>

                </div>

                <div className="section">

                    <h2>Invoice Items</h2>

                    <table>

                        <thead>

                            <tr>

                                <th>Item</th>
                                <th>HSN</th>
                                <th>Qty</th>
                                <th>Rate</th>
                                <th>GST %</th>

                            </tr>

                        </thead>

                        <tbody>

                            {

                                invoice.items.map((item) => (

                                    <tr key={item.id}>

                                        <td>{item.itemName}</td>

                                        <td>{item.hsnCode}</td>

                                        <td>{item.quantity}</td>

                                        <td>₹ {item.rate}</td>

                                        <td>{item.taxPercentage}%</td>

                                    </tr>

                                ))

                            }

                        </tbody>

                    </table>

                </div>

                <div className="summary">

                    <h2>Summary</h2>

                    <p><strong>Subtotal:</strong> ₹ {invoice.subTotal}</p>

                    <p><strong>CGST:</strong> ₹ {invoice.cgst}</p>

                    <p><strong>SGST:</strong> ₹ {invoice.sgst}</p>

                    <p><strong>Grand Total:</strong> ₹ {invoice.grandTotal}</p>

                    <p>

                        <strong>Amount In Words:</strong>

                        <br />

                        {invoice.amountInWords}

                    </p>

                </div>

            </div>

        </>

    );

}

export default InvoiceView;
