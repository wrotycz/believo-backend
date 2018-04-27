package pl.weglarz.believo.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import pl.weglarz.believo.model.entities.User;

public interface UserRepository extends PagingAndSortingRepository<User, Long> {
    User findByName(@Param("name") String name);
}
