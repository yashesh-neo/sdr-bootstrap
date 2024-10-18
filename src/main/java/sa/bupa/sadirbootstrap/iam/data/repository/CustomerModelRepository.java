package sa.bupa.sadirbootstrap.iam.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sa.bupa.sadirbootstrap.iam.data.CustomerModel;

import java.util.Optional;

public interface CustomerModelRepository extends JpaRepository<CustomerModel,Long> {
    Optional<CustomerModel> findByEmail(String email);
    Optional<CustomerModel> findByNationalUnifiedNumber(String nationalUnifiedNumber);
    Optional<CustomerModel> findByPrincipal(String principal);
}
