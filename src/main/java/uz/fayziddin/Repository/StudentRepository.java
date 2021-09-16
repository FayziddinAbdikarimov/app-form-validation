package uz.fayziddin.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.fayziddin.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Integer> {

}
