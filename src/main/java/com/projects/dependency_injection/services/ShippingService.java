package com.projects.dependency_injection.services;

import com.projects.dependency_injection.entities.Order;
import org.springframework.stereotype.Service;

@Service
public class ShippingService {
    public Double shipment(Order order) {
        Double basic = order.getBasic();
        if (basic < 100) {
            return 20.00;
        } else if (basic <= 200) {
            return 12.00;
        } else {
            return 0.00;
        }
    }
}
