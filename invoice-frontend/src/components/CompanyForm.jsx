import React from 'react'
import "../css/form.css";

function CompanyForm({ invoice, setInvoice }) {

    const handleChange = (e) => {

        const { name, value } = e.target;

        setInvoice({
            ...invoice,
            company: {
                ...invoice.company,
                [name]: value
            }
        });

    };

    return (

        <div className="form-section">

            <h2>Company Details</h2>

            <div className="form-grid">

                <input
                    type="text"
                    name="companyName"
                    placeholder="Company Name"
                    value={invoice.company.companyName}
                    onChange={handleChange}
                />

                <input
                    type="text"
                    name="gstNumber"
                    placeholder="GST Number"
                    value={invoice.company.gstNumber}
                    onChange={handleChange}
                />

                <input
                    type="email"
                    name="email"
                    placeholder="Email"
                    value={invoice.company.email}
                    onChange={handleChange}
                />

                <input
                    type="text"
                    name="phone"
                    placeholder="Phone"
                    value={invoice.company.phone}
                    onChange={handleChange}
                />

                <input
                    type="text"
                    name="bankName"
                    placeholder="Bank Name"
                    value={invoice.company.bankName}
                    onChange={handleChange}
                />

                <input
                    type="text"
                    name="accountNumber"
                    placeholder="Account Number"
                    value={invoice.company.accountNumber}
                    onChange={handleChange}
                />

                <input
                    type="text"
                    name="ifscCode"
                    placeholder="IFSC Code"
                    value={invoice.company.ifscCode}
                    onChange={handleChange}
                />

                <input
                    type="text"
                    name="branch"
                    placeholder="Branch"
                    value={invoice.company.branch}
                    onChange={handleChange}
                />

            </div>

            <textarea
                name="address"
                placeholder="Company Address"
                value={invoice.company.address}
                onChange={handleChange}
            />

        </div>

    );
}

export default CompanyForm;
