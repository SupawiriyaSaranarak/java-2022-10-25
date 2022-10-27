
package main.service;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Cashier {
    @RequestMapping("/get-final")
    Balance showTotal (String price) {
        try {
            double p = Double.valueOf(price);
            if (p >=100) p*=0.95;
            String two = String.format("%.2f", p);
            p = Double.valueOf(two);
            return new Balance("success",p);
            
        } catch (Exception e) {
            return new Balance("Invalid Price",0.0);
        }
        
        
    }
    
}
record Balance(String status, double result) {}