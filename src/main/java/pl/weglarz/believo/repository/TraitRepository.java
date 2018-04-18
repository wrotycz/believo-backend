package pl.weglarz.believo.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.security.access.prepost.PreAuthorize;
import pl.weglarz.believo.model.entities.Trait;

@RepositoryRestResource(collectionResourceRel = "traits", path = "traits")
@PreAuthorize("hasAuthority('CAN_ACCESS_DOMAIN')")
public interface TraitRepository extends PagingAndSortingRepository<Trait, Long> {
}
