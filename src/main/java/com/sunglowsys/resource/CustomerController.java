package com.sunglowsys.resource;

import com.sunglowsys.domain.Customer;
import com.sunglowsys.service.CustomerService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping
public class CustomerController {
    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }
    @GetMapping("/customers")
    public ModelAndView getAllCustomers() {
        Page<Customer> result = customerService.getAll(PageRequest.of(0,10));
        return new ModelAndView("customer","customers", result);
    }
    @GetMapping("/customers-create")
    public ModelAndView loadCustomer(Customer customer) {
        return new ModelAndView("customer-new","customer",new Customer());
    }
    @PostMapping("/customers-create")
    public ModelAndView createCustomer(@ModelAttribute Customer customer) {
        Customer result = customerService.save(customer);
        return new ModelAndView("redirect:/customers","customer", result);
    }

}
