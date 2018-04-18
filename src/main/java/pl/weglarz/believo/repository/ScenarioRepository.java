package pl.weglarz.believo.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.security.access.prepost.PreAuthorize;
import pl.weglarz.believo.model.entities.Scenario;

@RepositoryRestResource(collectionResourceRel = "scenarios", path = "scenarios")
@PreAuthorize("hasAuthority('CAN_ACCESS_DOMAIN')")
public interface ScenarioRepository extends PagingAndSortingRepository<Scenario, Long> {
}
