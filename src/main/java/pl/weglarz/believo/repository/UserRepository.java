package pl.weglarz.believo.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import pl.weglarz.believo.model.entities.User;

public interface UserRepository extends PagingAndSortingRepository<User, Long> {
    User findByName(String name);
}
