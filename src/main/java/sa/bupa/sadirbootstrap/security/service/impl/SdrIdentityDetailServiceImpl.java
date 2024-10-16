package sa.bupa.sadirbootstrap.security.service.impl;

import lombok.RequiredArgsConstructor;

import org.mapstruct.factory.Mappers;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import sa.bupa.sadirbootstrap.iam.data.repository.CustomerModelRepository;
import sa.bupa.sadirbootstrap.iam.mappings.IamMapper;
import sa.bupa.sadirbootstrap.security.service.SdrUserDetailService;
@Service
@RequiredArgsConstructor
public class SdrIdentityDetailServiceImpl implements SdrUserDetailService {

    private final CustomerModelRepository customerModelRepository;
    IamMapper iamMapper = Mappers.getMapper(IamMapper.class);
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return customerModelRepository.findByPrincipal(username)
                .map(customerModel -> iamMapper.customerModelToCustomer(customerModel))
                .orElse(null);
    }
}
