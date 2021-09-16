package com.sales.market.controller;

import com.sales.market.dto.EmployeeDto;
import com.sales.market.model.Employee;
import com.sales.market.service.EmployeeService;
import com.sales.market.service.GenericService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/employees")
public class EmployeeController extends GenericController<Employee, EmployeeDto> {
    private EmployeeService service;

    public EmployeeController(EmployeeService service) {
        this.service = service;
    }

    @Override
    protected GenericService getService() {
        return service;
    }
}
