package sa.bupa.sadirbootstrap.iam.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sa.bupa.sadirbootstrap.iam.data.SdrRoleModel;

public interface SdrRoleModelRepository extends JpaRepository<SdrRoleModel, Long> {
    SdrRoleModel findByTitle(String title);
}
