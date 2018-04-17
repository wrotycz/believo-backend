package pl.weglarz.believo.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.security.access.annotation.Secured;
import pl.weglarz.believo.model.entities.Privilege;

@RepositoryRestResource(collectionResourceRel = "privileges", path = "privileges")
@Secured("CAN_ACCESS_PRIVILEGES")
public interface PrivilegeRepository extends PagingAndSortingRepository<Privilege, Long> {
}
