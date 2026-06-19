import React from 'react'
import "../css/form.css";

function ShippingForm({ invoice, setInvoice }) {

    const handleChange = (e) => {

        const { name, value } = e.target;

        setInvoice({
            ...invoice,
            shipping: {
                ...invoice.shipping,
                [name]: value
            }
        });

    };

    return (

        <div className="form-section">

            <h2>Shipping Details</h2>

            <div className="form-grid">

                <input
                    type="text"
                    name="shippingPort"
                    placeholder="Shipping Port"
                    value={invoice.shipping.shippingPort}
                    onChange={handleChange}
                />

                <input
                    type="text"
                    name="deliveryTerms"
                    placeholder="Delivery Terms"
                    value={invoice.shipping.deliveryTerms}
                    onChange={handleChange}
                />

            </div>

        </div>

    );

}

export default ShippingForm;
