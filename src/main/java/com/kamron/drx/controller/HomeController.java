package com.kamron.drx.controller;

import com.lowagie.text.DocumentException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.xhtmlrenderer.pdf.ITextRenderer;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/**
 * @author Kamron Sultanov
 * @date August 7, 2020
 */

@Controller
public class HomeController {

    @GetMapping(path = "/")
    public String dashboard() {
        return "dashboard";
    }

    @GetMapping("/export/chart/")
    public void exportDocumentList() throws IOException, DocumentException {
        String outputFolder = System.getProperty("user.home") + File.separator + "chart.pdf";
        OutputStream outputStream = new FileOutputStream(outputFolder);

        ITextRenderer renderer = new ITextRenderer();
        renderer.setDocumentFromString("html");
        renderer.layout();
        renderer.createPDF(outputStream);

        outputStream.close();
    }
}
