package org.medium.examples.metrics.repository;

import org.medium.examples.metrics.entity.IPerson;
import org.medium.examples.metrics.entity.Person;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends CrudRepository<Person, String> {
    Person getPersonById(String id);

    @Query(value="select p.name name , p.age age , c.name className from person p left join classroom c on p.id = c.id",
            countQuery = "select count(*) from person p left join classroom c on p.id = c.id", nativeQuery = true)
    Page<IPerson> page(Pageable pageable);
}
