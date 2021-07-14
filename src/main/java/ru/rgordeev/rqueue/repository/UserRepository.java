package ru.rgordeev.rqueue.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import ru.rgordeev.rqueue.model.User;

@Repository
public interface UserRepository extends PagingAndSortingRepository<User, Long> {

}
