package sa.bupa.sadirbootstrap.leads.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/leads")
public class LeadsController {

     @GetMapping("/test")
     public String testLeads(){
         return "testLeads";
     }
}
