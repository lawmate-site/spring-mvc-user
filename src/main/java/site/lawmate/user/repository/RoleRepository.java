package site.lawmate.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import site.lawmate.user.domain.model.RoleModel;

@Repository
public interface RoleRepository extends JpaRepository<RoleModel, Long> {
}
