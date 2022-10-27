
package main;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Service {
//    "http://127.0.0.1:5000/get-total?price=450"
    @RequestMapping("/get-total")
    double getTotal(double price) {
        return price * 1.08;
    }
    
//    "http://127.0.0.1:5000/get-area?width=8.5&height=4.0"
    @GetMapping("/get-area")
    Result getArea(String width, String height) {
        try {
            double w = Double.valueOf(width);
            double h = Double.valueOf(height);
            Result r = new Result();
            r.message = "success";
            r.company = "My Company";
            r.result = w*h;
            return r;
        } catch (Exception e) {
            Result r = new Result();
            r.message = "Invalid Number";
            return r;
        }
        
    }
}
class Result {
    public String message= "";
    public double result;
    String company = ""; //user cannot see bcs it is not public
}
