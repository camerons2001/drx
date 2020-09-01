package com.kamron.drx.controller;

import com.kamron.drx.util.ChartToPdfUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.GetMapping;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * The type Home controller.
 *
 * @author Kamron Sultanov
 * @date August 7, 2020
 */
@Controller
public class HomeController {

    private final ChartToPdfUtility chartToPdfUtility;

    /**
     * Instantiates a new Home controller.
     *
     * @param chartToPdfUtility the chart to pdf utility
     */
    @Autowired
    public HomeController(ChartToPdfUtility chartToPdfUtility) {
        this.chartToPdfUtility = chartToPdfUtility;
    }

    /**
     * Dashboard string.
     *
     * @return the string
     */
    @GetMapping(path = "/")
    public String dashboard() {
        return "dashboard";
    }

    /**
     * Gets chart report.
     *
     * @return the chart report
     * @throws IOException the io exception
     */
    @GetMapping(path = "/export/Chart")
    public ResponseEntity<InputStreamResource> getChartReport() throws IOException {
        chartToPdfUtility.convertToPdf();
        File file = ResourceUtils.getFile("src/main/resources/reports/chart-report.pdf");
        InputStreamResource resource = new InputStreamResource(new FileInputStream(file));
        return ResponseEntity.ok()
                .contentType(MediaType.APPLICATION_PDF)
                .header(HttpHeaders.CONTENT_DISPOSITION + "inline; filename\"" + file.getName() + "\"")
                .body(resource);
    }
}
