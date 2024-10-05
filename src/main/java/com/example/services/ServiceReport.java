package com.example.services;


import com.example.entity.Empresary;
import com.example.repository.RepositoryEmpresary;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;


import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ServiceReport {

    @Autowired
    RepositoryEmpresary repositoryEmpresary;

    public String exportReport(String reportFormat) throws Exception{
      String path="C:\\Users\\Usuario\\Desktop\\JasperReport";
      List<Empresary> empresaryList=repositoryEmpresary.findAll();

      File file= ResourceUtils.getFile("classpath:empresary.jrxml");
      JasperReport jr = JasperCompileManager.compileReport(file.getAbsolutePath());

        JRBeanCollectionDataSource ds=new JRBeanCollectionDataSource(empresaryList);
        Map<String,Object> hm=new HashMap<>();
        hm.put("Created By","Learn Code With Sankalp" );

        JasperPrint jp=JasperFillManager.fillReport(jr,hm,ds);
        if(reportFormat.equalsIgnoreCase("html")){
            JasperExportManager.exportReportToHtmlFile(jp,path+"\\empresary.html");
        }
        if(reportFormat.equalsIgnoreCase("pdf")){
            JasperExportManager.exportReportToPdfFile(jp,path+"\\empresary.pdf");
        }

        return "File Created At Path: "+path;
    }
}
