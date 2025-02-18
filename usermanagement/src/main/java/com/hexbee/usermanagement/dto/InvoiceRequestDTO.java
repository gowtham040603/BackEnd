package com.hexbee.usermanagement.dto;

import java.util.List;

public class InvoiceRequestDTO {
    private Integer invoiceId;
    private List<InvoiceItemDTO> items;

    public Integer getInvoiceId() {
        return invoiceId;
    }

    public void setInvoiceId(Integer invoiceId) {
        this.invoiceId = invoiceId;
    }

    public List<InvoiceItemDTO> getItems() {
        return items;
    }

    public void setItems(List<InvoiceItemDTO> items) {
        this.items = items;
    }
}
