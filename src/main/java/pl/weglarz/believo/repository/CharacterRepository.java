package pl.weglarz.believo.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import pl.weglarz.believo.model.entities.Character;

@RepositoryRestResource(collectionResourceRel = "characters", path = "characters")
public interface CharacterRepository extends PagingAndSortingRepository<Character, Long> {
}
