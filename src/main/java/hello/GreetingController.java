package hello;

import java.util.concurrent.atomic.AtomicLong;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.fasterxml.jackson.databind.node.ArrayNode;

import javax.servlet.http.HttpServletRequest;


@RestController
public class GreetingController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    // @RequestMapping("/greeting")
    // public Greeting greeting(@RequestParam(value="name", defaultValue="World") String name) {
    //     return new Greeting(counter.incrementAndGet(),
    //                         String.format(template, name));
    // }

    @RequestMapping(value = "/greeting", method = RequestMethod.POST, headers={"Content-type=application/json"})
    public @ResponseBody Greeting greeting(HttpServletRequest request, @RequestBody JsonNode jsonNode) 
    {
    	JsonNode nameNode = jsonNode.get("name");
    	String name = (nameNode == null)? "World": nameNode.asText();

        return new Greeting(counter.incrementAndGet(),
                            String.format(template, name));
    }

}
