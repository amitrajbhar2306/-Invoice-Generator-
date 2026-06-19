import React from 'react'
import "../css/table.css";

function InvoiceItems({ invoice, setInvoice }) {

    const addItem = () => {

        setInvoice({

            ...invoice,

            items: [

                ...invoice.items,

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

    };

    const removeItem = (index) => {

        const updatedItems = invoice.items.filter((_, i) => i !== index);

        setInvoice({

            ...invoice,

            items: updatedItems

        });

    };

    const handleChange = (index, e) => {

        const { name, value } = e.target;

        const updatedItems = [...invoice.items];

        updatedItems[index][name] = value;

        // Calculate Total
        const quantity = Number(updatedItems[index].quantity);
        const rate = Number(updatedItems[index].rate);
        updatedItems[index].total = quantity * rate;

        setInvoice({

            ...invoice,

            items: updatedItems

        });

    };

    return (

        <div className="form-section">

            <h2>Invoice Items</h2>

            <table className="invoice-table">

                <thead>

                    <tr>

                        <th>Item</th>
                        <th>HSN</th>
                        <th>Qty</th>
                        <th>Rate</th>
                        <th>GST %</th>
                        <th>Total</th>
                        <th></th>

                    </tr>

                </thead>

                <tbody>

                    {

                        invoice.items.map((item, index) => (

                            <tr key={index}>

                                <td>

                                    <input
                                        name="itemName"
                                        value={item.itemName}
                                        onChange={(e) => handleChange(index, e)}
                                    />

                                </td>

                                <td>

                                    <input
                                        name="hsnCode"
                                        value={item.hsnCode}
                                        onChange={(e) => handleChange(index, e)}
                                    />

                                </td>

                                <td>

                                    <input
                                        type="number"
                                        name="quantity"
                                        value={item.quantity}
                                        onChange={(e) => handleChange(index, e)}
                                    />

                                </td>

                                <td>

                                    <input
                                        type="number"
                                        name="rate"
                                        value={item.rate}
                                        onChange={(e) => handleChange(index, e)}
                                    />

                                </td>

                                <td>

                                    <input
                                        type="number"
                                        name="taxPercentage"
                                        value={item.taxPercentage}
                                        onChange={(e) => handleChange(index, e)}
                                    />

                                </td>

                                <td>

                                    ₹ {item.total}

                                </td>

                                <td>

                                    <button
                                        className="delete-btn"
                                        onClick={() => removeItem(index)}
                                    >
                                        Remove
                                    </button>

                                </td>

                            </tr>

                        ))

                    }

                </tbody>

            </table>

            <button
                className="add-btn"
                onClick={addItem}
            >
                + Add Item
            </button>

        </div>

    );

}

export default InvoiceItems;
