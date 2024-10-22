package sa.bupa.sadirbootstrap.iam.api;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sa.bupa.sadirbootstrap.iam.api.dto.AuthenticationRequest;
import sa.bupa.sadirbootstrap.iam.api.dto.CreateCustomerRequest;
import sa.bupa.sadirbootstrap.iam.api.dto.CreateCustomerResponse;
import sa.bupa.sadirbootstrap.iam.service.SdrIdentityManagementService;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final SdrIdentityManagementService svc;

    @PostMapping("/customer")
    public CreateCustomerResponse createCustomer(@RequestBody CreateCustomerRequest request) {
        return  svc.createCustomer(request);
    }

    @PostMapping("/customer/authenticate")
    public String authenticateCustomer(@RequestBody AuthenticationRequest request) {
        return svc.authenticateAndCreateToken(request);
    }

}
