package pl.weglarz.believo.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.security.access.prepost.PreAuthorize;
import pl.weglarz.believo.model.entities.Privilege;

@RepositoryRestResource(collectionResourceRel = "privileges", path = "privileges")
@PreAuthorize("hasAuthority('CAN_ACCESS_PRIVILEGES')")
public interface PrivilegeRepository extends PagingAndSortingRepository<Privilege, Long> {
}
