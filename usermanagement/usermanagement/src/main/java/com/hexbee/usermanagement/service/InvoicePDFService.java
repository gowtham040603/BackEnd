package com.hexbee.usermanagement.service;

import com.hexbee.usermanagement.InvoicePdf.InvoicePDFGenerator;
import com.hexbee.usermanagement.Repository.InvoiceItemRepository;
import com.hexbee.usermanagement.Repository.InvoiceRepository;
import com.hexbee.usermanagement.entity.InvoiceEntity;
import com.hexbee.usermanagement.entity.InvoiceItemEntity;
import com.itextpdf.text.DocumentException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
public class InvoicePDFService {

    @Autowired
    private InvoiceRepository invoiceRepository;

    @Autowired
    private InvoiceItemRepository invoiceItemRepository;

    public String generateInvoicePDF(Integer invoiceId) throws DocumentException {
        Optional<InvoiceEntity> invoiceOpt = invoiceRepository.findById(invoiceId);
        if (invoiceOpt.isEmpty()) {
            return "Invoice not found!";
        }

        InvoiceEntity invoice = invoiceOpt.get();
        List<InvoiceItemEntity> items = invoiceItemRepository.findByInvoiceId(invoiceId);

        String filePath = "C:/invoices/invoice_" + invoiceId + ".pdf"; // Ensure Windows path

        try {
            InvoicePDFGenerator.generateInvoice(invoice, items, filePath);
            return "Invoice PDF generated successfully: " + filePath;
        } catch (IOException e) {
            e.printStackTrace();
            return "Error generating invoice PDF!";
        }
    }
}
