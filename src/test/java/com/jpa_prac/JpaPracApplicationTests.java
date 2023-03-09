package com.jpa_prac;

import com.jpa_prac.customer.entity.CustomerEntity;
import com.jpa_prac.customer.service.CustomersService;
import com.jpa_prac.employee.entity.EmployeeEntity;
import com.jpa_prac.employee.service.EmployeeService;
import com.jpa_prac.office.entity.OfficeEntity;
import com.jpa_prac.order.entity.OrderDetailEntity;
import com.jpa_prac.order.entity.OrderEntity;
import com.jpa_prac.order.entity.PaymentEntity;
import com.jpa_prac.product.entity.ProductEntity;
import com.jpa_prac.product.entity.ProductLineEntity;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;
import java.util.List;


@SpringBootTest
class JpaPracApplicationTests {

    @Autowired
    private CustomersService customersService;

    @Autowired
    private EmployeeService employeeService;

    @Test
    @DisplayName("객체그래프 탐색")
    @Transactional
    void test() {

        EmployeeEntity foundEmployee = employeeService.findById(1370L);
        System.out.println("▶▶▶▶▶ foundEmployee = " + foundEmployee);

        if (foundEmployee.getSupervisor() != null) {
            EmployeeEntity reporter = employeeService.findById(foundEmployee.getSupervisor().getId());
            System.out.println("▶▶▶▶▶ reporter = " + reporter);
        }

        OfficeEntity office = foundEmployee.getOffice();
        System.out.println("▶▶▶▶▶ office = " + office);

        CustomerEntity foundCustomer = customersService.findById(103L);
        System.out.println("▶▶▶▶▶ foundCustomer = " + foundCustomer);

        List<PaymentEntity> payments = foundCustomer.getPayments();
        for (PaymentEntity payment : payments) {
            System.out.println("▶▶▶▶▶ payment = " + payment);
        }

        if (foundCustomer != null) {
            List<OrderEntity> orders = foundCustomer.getOrders();
            for (OrderEntity order : orders) {
                System.out.println("▶▶▶▶▶ order = " + order);
                List<OrderDetailEntity> orderDetails = order.getOrderDetails();
                for (OrderDetailEntity orderDetail : orderDetails) {
                    System.out.println("▶▶▶▶▶ orderDetail = " + orderDetail);
                    ProductEntity product = orderDetail.getProduct();
                    System.out.println("▶▶▶▶▶ product = " + product);
                    ProductLineEntity productLine = product.getProductLine();
                    System.out.println("▶▶▶▶▶ productLine = " + productLine);
                }
            }
        }

    }

}
