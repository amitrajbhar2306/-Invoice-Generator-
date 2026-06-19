 import React from 'react'
 import { BrowserRouter, Routes, Route } from "react-router-dom";
import Home from "./pages/Home";
import InvoiceList from "./pages/InvoiceList";
import InvoiceView from "./pages/InvoiceView";

function App() {

    return (

        <BrowserRouter>

            <Routes>

                <Route path="/" element={<Home />} />

                <Route path="/invoices" element={<InvoiceList />} />

                <Route path="/invoice/:id" element={<InvoiceView />} />

            </Routes>

        </BrowserRouter>

    );
}

export default App;
 