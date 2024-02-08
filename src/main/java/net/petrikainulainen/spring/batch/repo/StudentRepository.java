package net.petrikainulainen.spring.batch.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import net.petrikainulainen.spring.batch.entity.StudentEntity;

@Repository
public interface StudentRepository extends CrudRepository<StudentEntity, Integer> {

}
