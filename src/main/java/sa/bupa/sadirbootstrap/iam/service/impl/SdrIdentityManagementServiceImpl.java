package sa.bupa.sadirbootstrap.iam.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import sa.bupa.sadirbootstrap.iam.api.dto.CreateCustomerRequest;
import sa.bupa.sadirbootstrap.iam.api.dto.CreateCustomerResponse;
import sa.bupa.sadirbootstrap.iam.data.CustomerModel;
import sa.bupa.sadirbootstrap.iam.data.repository.CustomerModelRepository;
import sa.bupa.sadirbootstrap.iam.service.SdrIdentityManagementService;

@Service
@RequiredArgsConstructor
public class SdrIdentityManagementServiceImpl implements SdrIdentityManagementService {

    private final CustomerModelRepository repository;

    @Override
    public CreateCustomerResponse createCustomer(CreateCustomerRequest customerDto) {
            CustomerModel customerModel = new CustomerModel();
            customerModel.setPrincipal(customerDto.nationalUnifiedNumber());
            customerModel.setContactEmail(customerDto.email());
            customerModel.setCrNumber(customerDto.cr());
            customerModel.setContactMobile(customerDto.phone());
            customerModel.setNationalUnifiedNumber(customerDto.nationalUnifiedNumber());
            var result= repository.save(customerModel);
        return new CreateCustomerResponse(result.getId(),result.getPrincipal());
    }
}
