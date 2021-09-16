package com.sales.market.service;

import com.sales.market.model.Employee;
import com.sales.market.repository.EmployeeRepository;
import com.sales.market.repository.GenericRepository;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl extends GenericServiceImpl<Employee> implements EmployeeService {
    private final EmployeeRepository repository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.repository = employeeRepository;
    }

    @Override
    protected GenericRepository<Employee> getRepository() {
        return repository;
    }
}
