package com.hexbee.usermanagement.controller;

import com.hexbee.usermanagement.service.InvoicePDFService;
import com.itextpdf.text.DocumentException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@RestController
@RequestMapping("/api/invoices")
public class InvoicePDFController {

    @Autowired
    private InvoicePDFService invoicePDFService;

    @GetMapping("/generate/{invoiceId}")
    public ResponseEntity<String> generateInvoice(@PathVariable("invoiceId") Integer invoiceId) throws DocumentException {
        String result = invoicePDFService.generateInvoicePDF(invoiceId);
        return ResponseEntity.ok(result);
    }

    @GetMapping("/download/{invoiceId}")
    public ResponseEntity<Resource> downloadInvoice(@PathVariable("invoiceId") Integer invoiceId) throws Exception {
        String filePath = "C:/invoices/invoice_" + invoiceId + ".pdf";
        Path path = Paths.get(filePath);
        
        if (!Files.exists(path)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }

        Resource resource = new UrlResource(path.toUri());
        return ResponseEntity.ok()
                .contentType(MediaType.APPLICATION_PDF)
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + path.getFileName())
                .body(resource);
    }

    @GetMapping("/view/{invoiceId}")
    public ResponseEntity<Resource> viewInvoice(@PathVariable("invoiceId") Integer invoiceId) throws IOException {
        String filePath = "C:/invoices/invoice_" + invoiceId + ".pdf";
        File pdfFile = new File(filePath);

        if (!pdfFile.exists()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }

        Path path = pdfFile.toPath();
        ByteArrayResource resource = new ByteArrayResource(Files.readAllBytes(path));

        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "inline; filename=" + pdfFile.getName())
                .contentType(MediaType.APPLICATION_PDF)
                .body(resource);
    }
}
