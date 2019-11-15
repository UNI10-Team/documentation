package ubb.uni10.demo.repository;

import org.springframework.data.jpa.domain.Specification;
import ubb.uni10.demo.entity.Human;

public class HumanSpecifications {

    public static Specification<Human> customerHasBirthday() {
        return (Specification<Human>) (root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get("age"), 24);
    }

}
