import React from 'react'
import { useEffect, useState } from "react";
import { Link } from "react-router-dom";
import { getAllInvoices, deleteInvoice } from "../services/invoiceService";
import Navbar from "../components/Navbar";
import "../css/invoiceList.css";

function InvoiceList() {

    const [invoices, setInvoices] = useState([]);

    useEffect(() => {
        loadInvoices();
    }, []);

    const loadInvoices = async () => {

        try {

            const data = await getAllInvoices();

            setInvoices(data);

        } catch (error) {

            console.error(error);

        }

    };

    const handleDelete = async (id) => {

        if (!window.confirm("Delete this invoice?")) return;

        try {

            await deleteInvoice(id);

            loadInvoices();

        } catch (error) {

            console.error(error);

        }

    };

    return (

        <>
            <Navbar />

            <div className="invoice-list">

                <h1>Invoices</h1>

                <table>

                    <thead>

                        <tr>

                            <th>Invoice No</th>
                            <th>Date</th>
                            <th>Client</th>
                            <th>Total</th>
                            <th>Actions</th>

                        </tr>

                    </thead>

                    <tbody>

                        {

                            invoices.map((invoice) => (

                                <tr key={invoice.id}>

                                    <td>{invoice.invoiceNumber}</td>

                                    <td>{invoice.invoiceDate}</td>

                                    <td>{invoice.clientName}</td>

                                    <td>₹ {invoice.grandTotal}</td>

                                    <td>

                                        <Link
                                            to={`/invoice/${invoice.id}`}
                                            className="view-btn"
                                        >
                                            View
                                        </Link>

                                        <button
                                            className="delete-btn"
                                            onClick={() => handleDelete(invoice.id)}
                                        >
                                            Delete
                                        </button>

                                    </td>

                                </tr>

                            ))

                        }

                    </tbody>

                </table>

            </div>

        </>

    );

}

export default InvoiceList;