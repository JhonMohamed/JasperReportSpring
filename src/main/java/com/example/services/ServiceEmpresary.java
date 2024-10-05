package com.example.services;

import com.example.entity.Empresary;
import com.example.repository.RepositoryEmpresary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceEmpresary {
    @Autowired
    private RepositoryEmpresary repositoryEmpresary;

    public List<Empresary> getEmpresary() {
        return repositoryEmpresary.findAll();
    }
}
