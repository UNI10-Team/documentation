package ubb.uni10.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import ubb.uni10.demo.entity.Human;

import java.util.List;

public interface HumanRepository extends JpaRepository<Human, Long>, JpaSpecificationExecutor<Human> {

    @Query("select h.name from human h where h.age > ?1")
    List<String> getNames(int age);

}
