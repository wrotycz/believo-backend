package pl.weglarz.believo.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import pl.weglarz.believo.model.entities.Role;

import java.util.Set;

@RepositoryRestResource(collectionResourceRel = "roles", path = "roles")
@PreAuthorize("hasAuthority('CAN_ACCESS_ROLES')")
public interface RoleRepository extends PagingAndSortingRepository<Role, Long> {
    Set<Role> findByNameIn(Set<String> names);
}
