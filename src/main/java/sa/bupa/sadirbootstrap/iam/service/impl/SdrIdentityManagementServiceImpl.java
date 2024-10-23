package sa.bupa.sadirbootstrap.iam.service.impl;

import lombok.RequiredArgsConstructor;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Service;
import sa.bupa.sadirbootstrap.iam.api.dto.AuthenticationRequest;
import sa.bupa.sadirbootstrap.iam.api.dto.CreateCustomerRequest;
import sa.bupa.sadirbootstrap.iam.api.dto.CreateCustomerResponse;
import sa.bupa.sadirbootstrap.iam.data.CustomerModel;
import sa.bupa.sadirbootstrap.iam.data.SdrRoleModel;
import sa.bupa.sadirbootstrap.iam.data.repository.CustomerModelRepository;
import sa.bupa.sadirbootstrap.iam.data.repository.SdrRoleModelRepository;
import sa.bupa.sadirbootstrap.iam.domain.enums.DefaultRole;
import sa.bupa.sadirbootstrap.iam.mappings.IamMapper;
import sa.bupa.sadirbootstrap.iam.service.SdrIdentityManagementService;
import sa.bupa.sadirbootstrap.security.service.TokenMangerService;

import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class SdrIdentityManagementServiceImpl implements SdrIdentityManagementService {

    private final CustomerModelRepository repository;
    private final TokenMangerService tokenManger;
    private final SdrRoleModelRepository roleModelRepository;
    IamMapper iamMapper = Mappers.getMapper(IamMapper.class);

    @Override
    public CreateCustomerResponse createCustomer(CreateCustomerRequest customerDto) {
            var role= roleModelRepository.findByTitle(DefaultRole.CUSTOMER.toString());
            if(role==null) {
                role = new SdrRoleModel();
                role.setTitle(DefaultRole.CUSTOMER.toString());
                role= roleModelRepository.saveAndFlush(role);
            }
            CustomerModel customerModel = new CustomerModel();
            customerModel.setPrincipal(customerDto.nationalUnifiedNumber());
            customerModel.setContactEmail(customerDto.email());
            customerModel.setCrNumber(customerDto.cr());
            customerModel.setContactMobile(customerDto.phone());
            customerModel.setAssignedRole(role);
            customerModel.setNationalUnifiedNumber(customerDto.nationalUnifiedNumber());
            var result= repository.save(customerModel);
        return new CreateCustomerResponse(result.getId(),result.getPrincipal());
    }

    @Override
    public String authenticateAndCreateToken(AuthenticationRequest request) {
            var customer= repository.findByPrincipal(request.principal()).get();
        return tokenManger.createToken(customer.getPrincipal(),customer.getAssignedRole()
                .getAuthorities().stream()
                .map(sdrAuthoritiesModel -> iamMapper.authorityModelToAuthority(sdrAuthoritiesModel))
                .collect(Collectors.toSet()));
    }
}
