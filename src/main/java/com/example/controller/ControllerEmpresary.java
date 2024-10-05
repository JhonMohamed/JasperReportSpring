package com.example.controller;

import com.example.entity.Empresary;
import com.example.services.ServiceEmpresary;
import com.example.services.ServiceReport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ControllerEmpresary {

    @Autowired
    ServiceEmpresary serviceEmpresary;

    @Autowired
    ServiceReport serviceReport;

    @GetMapping("/getEmpresary")
    public List<Empresary> getEmpresary(){
        return serviceEmpresary.getEmpresary();
    }
    @GetMapping("report/{reportFormat}")
    public String getReport(@PathVariable String reportFormat) throws Exception {
       return serviceReport.exportReport(reportFormat);

    }
}
