package com.sales.market;

import com.sales.market.model.Buy;
import com.sales.market.model.Category;
import com.sales.market.model.Employee;
import com.sales.market.repository.BuyRepository;
import com.sales.market.repository.CategoryRepository;
import com.sales.market.repository.EmployeeRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class DevelopmentBootstrap implements ApplicationListener<ContextRefreshedEvent> {
    private BuyRepository buyRepository;
    private CategoryRepository categoryRepository;
    private EmployeeRepository employeeRepository;

    // injeccion evita hacer instancia   = new Clase();
    // bean pueden tener muchos campos y otros beans asociados
    public DevelopmentBootstrap(BuyRepository buyRepository, CategoryRepository categoryRepository, EmployeeRepository employeeRepository) {
        this.buyRepository = buyRepository;
        this.categoryRepository = categoryRepository;
        this.employeeRepository = employeeRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        System.out.println("evento de spring");
        persistBuy(BigDecimal.TEN);
        persistBuy(BigDecimal.ONE);
        persistCategories("Categori-1", "Cod-1");
        persistCategories("Categori-2", "Cod-2");
        persistEmployee("Juan", "Mecanico");
        persistEmployee("Sandra", "Renan");
    }

    private void persistCategories(String nameCategory, String nameCode) {
        Category category = new Category();
        category.setName(nameCategory);
        category.setCode(nameCode);
        categoryRepository.save(category);
    }

    private void persistEmployee(String firstName, String lastName) {
        Employee employee = new Employee();
        employee.setFirstName(firstName);
        employee.setLastName(lastName);
        employeeRepository.save(employee);
    }

    private void persistBuy(BigDecimal value) {
        Buy buy = new Buy();
        buy.setValue(value);
        buyRepository.save(buy);
    }
}
