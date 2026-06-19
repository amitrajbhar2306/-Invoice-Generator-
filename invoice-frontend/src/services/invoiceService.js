 import api from "../api/axiosConfig";

export const createInvoice = async (invoice) => {
    const response = await api.post("/invoices", invoice);
    return response.data;
};

export const getAllInvoices = async () => {
    const response = await api.get("/invoices");
    return response.data;
};

export const getInvoiceById = async (id) => {
    const response = await api.get(`/invoices/${id}`);
    return response.data;
};

export const deleteInvoice = async (id) => {
    const response = await api.delete(`/invoices/${id}`);
    return response.data;
};