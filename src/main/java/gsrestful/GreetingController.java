package gsrestful;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {


    @RequestMapping("greeting")
    public String sayHello(){
        return ("Hello, SpringBoot on openshift");
    }
}