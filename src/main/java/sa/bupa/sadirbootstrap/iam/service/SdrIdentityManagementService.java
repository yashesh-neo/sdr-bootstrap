package sa.bupa.sadirbootstrap.iam.service;

import sa.bupa.sadirbootstrap.iam.api.dto.CreateCustomerRequest;
import sa.bupa.sadirbootstrap.iam.api.dto.CreateCustomerResponse;
import sa.bupa.sadirbootstrap.iam.domain.identities.impl.Customer;

public interface SdrIdentityManagementService {
    CreateCustomerResponse createCustomer(CreateCustomerRequest customer);
}
