package com.kamron.drx.util;

import com.itextpdf.html2pdf.ConverterProperties;
import com.itextpdf.html2pdf.HtmlConverter;
import com.itextpdf.io.IOException;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

/**
 * The type Chart to pdf utility.
 */
@Component
public class ChartToPdfUtility {

    /**
     * Convert to pdf.
     *
     * @throws IOException the io exception
     * @throws IOException the io exception
     */
    public void convertToPdf() throws IOException, java.io.IOException {
        File htmlSource = new File("src/main/resources/templates/dashboard.html");
        File pdfDest = new File("src/main/resources/reports/chart-report.pdf");
        ConverterProperties converterProperties = new ConverterProperties();
        HtmlConverter.convertToPdf(new FileInputStream(htmlSource),
                new FileOutputStream(pdfDest), converterProperties);
    }
}
