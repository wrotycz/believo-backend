package pl.weglarz.believo.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import pl.weglarz.believo.model.entities.Trait;

@RepositoryRestResource(collectionResourceRel = "traits", path = "traits")
public interface TraitRepository extends PagingAndSortingRepository<Trait, Long> {
}
