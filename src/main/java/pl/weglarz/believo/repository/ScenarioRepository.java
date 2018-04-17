package pl.weglarz.believo.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import pl.weglarz.believo.model.entities.Scenario;

@RepositoryRestResource(collectionResourceRel = "scenarios", path = "scenarios")
public interface ScenarioRepository extends PagingAndSortingRepository<Scenario, Long> {
}
