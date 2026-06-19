import React from 'react'

 import "../css/form.css";

function ClientForm({ invoice, setInvoice }) {

    const handleChange = (e) => {

        const { name, value } = e.target;

        setInvoice({
            ...invoice,
            client: {
                ...invoice.client,
                [name]: value
            }
        });

    };

    return (

        <div className="form-section">

            <h2>Client Details</h2>

            <div className="form-grid">

                <input
                    type="text"
                    name="clientName"
                    placeholder="Client Name"
                    value={invoice.client.clientName}
                    onChange={handleChange}
                />

                <input
                    type="text"
                    name="clientGST"
                    placeholder="GST Number"
                    value={invoice.client.clientGST}
                    onChange={handleChange}
                />

                <input
                    type="email"
                    name="clientEmail"
                    placeholder="Client Email"
                    value={invoice.client.clientEmail}
                    onChange={handleChange}
                />

                <input
                    type="text"
                    name="clientPhone"
                    placeholder="Phone Number"
                    value={invoice.client.clientPhone}
                    onChange={handleChange}
                />

            </div>

            <textarea
                name="clientAddress"
                placeholder="Client Address"
                value={invoice.client.clientAddress}
                onChange={handleChange}
            />

        </div>

    );

}

export default ClientForm;
