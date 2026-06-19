import React from 'react'
import "../css/summary.css";

function InvoiceSummary({ totals }) {

    return (

        <div className="summary-container">

            <h2>Invoice Summary</h2>

            <div className="summary-row">
                <span>Subtotal</span>
                <span>₹ {totals.subTotal.toFixed(2)}</span>
            </div>

            <div className="summary-row">
                <span>CGST</span>
                <span>₹ {totals.cgst.toFixed(2)}</span>
            </div>

            <div className="summary-row">
                <span>SGST</span>
                <span>₹ {totals.sgst.toFixed(2)}</span>
            </div>

            <div className="summary-row total">
                <span>Grand Total</span>
                <span>₹ {totals.grandTotal.toFixed(2)}</span>
            </div>

            <div className="summary-row">
               <span>Amount In Words</span>
            </div>

<div className="amount-container">

    <strong>Amount In Words</strong>

    <p className="amount-text">
        {/* {totals.grandTotal.toFixed(2)} Rupees Only */}
        ₹ {totals.grandTotal.toLocaleString("en-IN", {
    minimumFractionDigits: 2,
    maximumFractionDigits: 2
})}
    </p>

</div>

        </div>

    );

}

export default InvoiceSummary;