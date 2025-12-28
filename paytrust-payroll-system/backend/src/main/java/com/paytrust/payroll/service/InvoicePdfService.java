package com.paytrust.payroll.service;

import com.lowagie.text.*;
import com.lowagie.text.pdf.PdfWriter;
import org.springframework.stereotype.Service;
import java.io.*;

@Service
public class InvoicePdfService {

    public ByteArrayInputStream generateInvoice(String company, double amount) throws Exception {
        Document doc = new Document();
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        PdfWriter.getInstance(doc, out);

        doc.open();
        doc.add(new Paragraph("PAYROLL INVOICE"));
        doc.add(new Paragraph("Company: " + company));
        doc.add(new Paragraph("Amount Due: KES " + amount));
        doc.add(new Paragraph("Status: Pending"));
        doc.close();

        return new ByteArrayInputStream(out.toByteArray());
    }
}
