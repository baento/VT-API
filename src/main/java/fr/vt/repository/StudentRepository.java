package fr.vt.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fr.vt.model.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {
    List<Student> findByDeletedFalse();

    default List<Student> findAllActive() {
        return findByDeletedFalse();
    }

    Optional<Student> findById(Integer id);
}