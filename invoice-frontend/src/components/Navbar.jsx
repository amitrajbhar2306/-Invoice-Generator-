import React from 'react'

import { Link } from "react-router-dom";
import "../css/navbar.css";

function Navbar() {
    return (
        <nav className="navbar">

            <div className="logo">
                Invoice Generator
            </div>

            <div className="nav-links">

                <Link to="/">Home</Link>

                <Link to="/invoices">
                    View Invoices
                </Link>

            </div>

        </nav>
    );
}

export default Navbar;
