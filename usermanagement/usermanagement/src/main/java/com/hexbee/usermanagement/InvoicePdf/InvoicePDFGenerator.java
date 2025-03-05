package com.hexbee.usermanagement.InvoicePdf;

import com.hexbee.usermanagement.entity.CustomersEntity;
import com.hexbee.usermanagement.entity.InvoiceEntity;
import com.hexbee.usermanagement.entity.InvoiceItemEntity;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.*;
import com.itextpdf.text.pdf.draw.LineSeparator;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InvoicePDFGenerator {
    public static void generateInvoice(InvoiceEntity invoice, List<InvoiceItemEntity> items, String filePath) throws IOException, DocumentException {
        File file = new File(filePath);
        file.getParentFile().mkdirs();

        Document document = new Document(PageSize.A4);
        PdfWriter.getInstance(document, new FileOutputStream(filePath));
        document.open();

        // Company Details and Logo
        PdfPTable headerTable = new PdfPTable(2);
        headerTable.setWidthPercentage(100);
        headerTable.setWidths(new float[]{3, 1});

        PdfPCell companyCell = new PdfPCell();
        companyCell.addElement(new Paragraph("Hexbee", new Font(Font.FontFamily.HELVETICA, 18, Font.BOLD)));
        companyCell.addElement(new Paragraph("123 Business Street, City, Country, ZIP"));
        companyCell.addElement(new Paragraph("Phone: +1234567890 | Email: contact@hexbee.com"));
        companyCell.addElement(new Paragraph("GSTIN: 33XXXXX8990L1ZN | State: Tamil Nadu"));
        companyCell.setBorder(Rectangle.NO_BORDER);
        headerTable.addCell(companyCell);

        Image logo = Image.getInstance("src/main/resources/hexbeeLogo.PNG");
        logo.scaleToFit(100, 100);
        PdfPCell logoCell = new PdfPCell(logo);
        logoCell.setBorder(Rectangle.NO_BORDER);
        logoCell.setHorizontalAlignment(Element.ALIGN_RIGHT);
        headerTable.addCell(logoCell);

        document.add(headerTable);
        document.add(new Paragraph("\n"));
        LineSeparator lineSeparator = new LineSeparator();
        lineSeparator.setLineWidth(1);
        lineSeparator.setPercentage(100);
        document.add(new Chunk(lineSeparator));

     // Invoice Title
        Font titleFont = new Font(Font.FontFamily.HELVETICA, 16, Font.BOLD, new BaseColor(128, 0, 128));
        Paragraph title = new Paragraph("Tax Invoice", titleFont);
        title.setAlignment(Element.ALIGN_CENTER);
        document.add(title);
        document.add(new Paragraph("\n"));

        // Invoice Details & Customer Info Table
        PdfPTable infoTable = new PdfPTable(2);
        infoTable.setWidthPercentage(100);
        infoTable.setWidths(new float[]{1.5f, 1f}); // Set column widths

        // Customer Details (Left Side)
        PdfPCell customerCell = new PdfPCell();
        customerCell.addElement(new Paragraph("Bill To", new Font(Font.FontFamily.HELVETICA, 12, Font.BOLD)));

        CustomersEntity customer = invoice.getCustomerId();
        if (customer != null) {
            customerCell.addElement(new Paragraph(customer.getName(), new Font(Font.FontFamily.HELVETICA, 12, Font.BOLD)));
            customerCell.addElement(new Paragraph(customer.getAddress()));
            customerCell.addElement(new Paragraph("Phone: " + customer.getPhone()));
            customerCell.addElement(new Paragraph("GSTIN: 33XXXXXXX7992L1Z9"));
        }
        customerCell.setBorder(Rectangle.NO_BORDER);
        infoTable.addCell(customerCell);

        // Invoice Details (Right Side)
        PdfPCell invoiceCell = new PdfPCell();
        Paragraph invoiceDetails = new Paragraph();
        invoiceDetails.add(new Paragraph("Invoice Details", new Font(Font.FontFamily.HELVETICA, 12, Font.BOLD)));
        invoiceDetails.add(new Paragraph("Invoice No: " + invoice.getInvoiceNumber()));
        invoiceDetails.add(new Paragraph("Date: " + invoice.getCreatedAt().format(DateTimeFormatter.ofPattern("dd-MM-yyyy"))));
        invoiceDetails.add(new Paragraph("Place of Supply: Tamil Nadu"));
        invoiceDetails.setAlignment(Element.ALIGN_RIGHT); // Align text inside paragraph

        invoiceCell.addElement(invoiceDetails);
        invoiceCell.setHorizontalAlignment(Element.ALIGN_RIGHT); // Align cell content to right
        invoiceCell.setBorder(Rectangle.NO_BORDER);
        infoTable.addCell(invoiceCell);

        document.add(infoTable);
        document.add(new Paragraph("\n"));
        
        // Table Header
        PdfPTable table = new PdfPTable(9);
        table.setWidthPercentage(100);
        table.setWidths(new float[]{1, 3, 2, 2, 2, 2, 2, 2, 2});

        Font headerFont = new Font(Font.FontFamily.HELVETICA, 10, Font.BOLD, BaseColor.WHITE);
        BaseColor headerColor = new BaseColor(153, 102, 255);

        addTableHeader(table, "#", headerFont, headerColor);
        addTableHeader(table, "Item Name", headerFont, headerColor);
        addTableHeader(table, "HSN/SAC", headerFont, headerColor);
        addTableHeader(table, "Quantity", headerFont, headerColor);
        addTableHeader(table, "Unit", headerFont, headerColor);
        addTableHeader(table, "Price/Unit", headerFont, headerColor);
        addTableHeader(table, "Discount", headerFont, headerColor);
        addTableHeader(table, "GST Amount", headerFont, headerColor);
        addTableHeader(table, "Amount", headerFont, headerColor);
        
        double subTotal = 0.0;
        double totalDiscount = 0.0;
        double totalSGST = 0.0;
        double totalCGST = 0.0;
        double finalTotal = 0.0;

        // Using Maps to store SGST & CGST dynamically
        Map<Double, Double> sgstTotals = new HashMap<>();
        Map<Double, Double> cgstTotals = new HashMap<>();

        int index = 1;
        for (InvoiceItemEntity item : items) {
            double pricePerUnit = item.getProduct().getPricePerUnit();
            double quantity = item.getQuantity();
            double discount = item.getDiscount();
            double sgstRate = item.getSgst();
            double cgstRate = item.getCgst();
            double sgstAmount = item.getSgstAmount();
            double cgstAmount = item.getCgstAmount();
            double totalAmount = item.getTotalPrice();

            // Calculating values dynamically
            subTotal += (pricePerUnit * quantity);
            totalDiscount += (discount * quantity);
            totalSGST += sgstAmount;
            totalCGST += cgstAmount;

            // Storing SGST & CGST amounts based on their percentages
            sgstTotals.put(sgstRate, sgstTotals.getOrDefault(sgstRate, 0.0) + sgstAmount);
            cgstTotals.put(cgstRate, cgstTotals.getOrDefault(cgstRate, 0.0) + cgstAmount);

            // Add row dynamically
            table.addCell(String.valueOf(index++));
            table.addCell(item.getProduct().getName());
            table.addCell(String.valueOf(item.getProduct().getHsnsac()));
            table.addCell(String.valueOf(quantity));
            table.addCell("Pcs");
            table.addCell("₹ " + String.format("%.2f", pricePerUnit));
            table.addCell("₹ " + String.format("%.2f", discount));
            table.addCell("₹ " + String.format("%.2f", sgstAmount + cgstAmount));
            table.addCell("₹ " + String.format("%.2f", totalAmount));
        }

        // ✅ **Final Total Calculation (Dynamically)**
        finalTotal = subTotal + totalSGST + totalCGST - totalDiscount;


        document.add(table);
        document.add(new Paragraph("\n"));
        
     // Convert invoice total dynamically to words
        String invoiceAmountInWords = NumberToWordsConverter.convert((long) finalTotal);

        // Add "Invoice Amount In Words" to the PDF
        Paragraph invoiceWords = new Paragraph();
        invoiceWords.add(new Chunk("Invoice Amount In Words\n", new Font(Font.FontFamily.HELVETICA, 12, Font.BOLD)));
        invoiceWords.add(new Chunk(invoiceAmountInWords, new Font(Font.FontFamily.HELVETICA, 12)));
        invoiceWords.setAlignment(Element.ALIGN_LEFT);
        document.add(invoiceWords);

        document.add(new Paragraph("\n")); // Space

        // Terms and Conditions (Left Side)
        Paragraph terms = new Paragraph();
        terms.add(new Chunk("Terms And Conditions\n", new Font(Font.FontFamily.HELVETICA, 12, Font.BOLD)));
        terms.add(new Chunk("Thank you for doing business with us.", new Font(Font.FontFamily.HELVETICA, 12)));
        terms.setAlignment(Element.ALIGN_LEFT);
        document.add(terms);
        document.add(new Paragraph("\n")); // Space

        // Summary Section (Right Side)
        Paragraph summary = new Paragraph();
        summary.setAlignment(Element.ALIGN_RIGHT);

        summary.add(new Chunk("Sub Total: ₹" + String.format("%.2f", subTotal) + "\n"));
        summary.add(new Chunk("Discount: ₹" + String.format("%.2f", totalDiscount) + "\n"));

        for (Map.Entry<Double, Double> entry : sgstTotals.entrySet()) {
            summary.add(new Chunk("SGST @" + entry.getKey() + "%: ₹" + String.format("%.2f", entry.getValue()) + "\n"));
        }

        for (Map.Entry<Double, Double> entry : cgstTotals.entrySet()) {
            summary.add(new Chunk("CGST @" + entry.getKey() + "%: ₹" + String.format("%.2f", entry.getValue()) + "\n"));
        }

        // Add total with highlight effect
        Chunk totalChunk = new Chunk("Total: ₹" + String.format("%.2f", finalTotal),
                new Font(Font.FontFamily.HELVETICA, 12, Font.BOLD, new BaseColor(255, 255, 255)));
        totalChunk.setBackground(new BaseColor(128, 128, 255)); // Light purple background

        summary.add(totalChunk);
        summary.add(new Chunk("\nReceived: ₹ 0.00\n"));
        summary.add(new Chunk("Balance: ₹" + String.format("%.2f", finalTotal) + "\n"));
        summary.add(new Chunk("You Saved: ₹" + String.format("%.2f", totalDiscount), new Font(Font.FontFamily.HELVETICA, 12, Font.BOLD)));

        document.add(summary);



        document.close();
        System.out.println("Invoice PDF generated successfully.");
    }

    public class NumberToWordsConverter {
        private static final String[] units = {
            "", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten",
            "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"
        };
        private static final String[] tens = {
            "", "", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"
        };

        public static String convert(long number) {
            if (number == 0) {
                return "Zero Rupees only";
            }
            return convertHelper(number).trim() + " Rupees only";
        }

        private static String convertHelper(long number) {
            if (number < 20) {
                return units[(int) number];
            }
            if (number < 100) {
                return tens[(int) (number / 10)] + " " + units[(int) (number % 10)];
            }
            if (number < 1000) {
                return units[(int) (number / 100)] + " Hundred " + convertHelper(number % 100);
            }
            if (number < 100000) {
                return convertHelper(number / 1000) + " Thousand " + convertHelper(number % 1000);
            }
            if (number < 10000000) {
                return convertHelper(number / 100000) + " Lakh " + convertHelper(number % 100000);
            }
            return convertHelper(number / 10000000) + " Crore " + convertHelper(number % 10000000);
        }
    }
    
    private static void addSummaryRow(Paragraph paragraph, String label, String value, Font font, boolean highlight) {
        Chunk labelChunk = new Chunk(label, font);
        Chunk valueChunk = new Chunk(value, font);

        if (highlight) {
            valueChunk.setBackground(new BaseColor(180, 167, 220)); // Light purple background for "Total"
        }

        paragraph.add(labelChunk);
        paragraph.add(Chunk.TABBING);
        paragraph.add(Chunk.TABBING);
        paragraph.add(valueChunk);
        paragraph.add(Chunk.NEWLINE);
    }

   
	private static void addTableHeader(PdfPTable table, String headerTitle, Font font, BaseColor backgroundColor) {
        PdfPCell header = new PdfPCell(new Phrase(headerTitle, font));
        header.setHorizontalAlignment(Element.ALIGN_CENTER);
        header.setBackgroundColor(backgroundColor);
        table.addCell(header);
    }
}
