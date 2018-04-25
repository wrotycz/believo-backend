package pl.weglarz.believo.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.security.access.prepost.PreAuthorize;
import pl.weglarz.believo.model.entities.Character;

import java.util.Set;

@RepositoryRestResource(collectionResourceRel = "characters", path = "characters")
@PreAuthorize("hasAuthority('CAN_ACCESS_DOMAIN')")
public interface CharacterRepository extends PagingAndSortingRepository<Character, Long> {
    Set<Character> findAllByScenarioId(@Param("scenarioId") Long scenarioId);
}
