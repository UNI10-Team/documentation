package ubb.uni10.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.web.bind.annotation.*;
import ubb.uni10.demo.entity.Human;
import ubb.uni10.demo.service.HumanService;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/humans")
public class HumanController {

    private HumanService humanService;

    @Autowired
    public HumanController(HumanService humanService) {
        this.humanService = humanService;
    }

    @PostMapping("/")
    public Human save(@Valid @RequestBody Human entity) {
        return humanService.save(entity);
    }

    @GetMapping("/names")
    public List<String> getNames(@RequestParam(name = "age", required = false, defaultValue = "0") int age) {
        return humanService.getNames(age);
    }

    @GetMapping("/majors")
    public List<Human> getMajors() {
        return humanService.findAll(
                (root, query, criteriaBuilder) -> criteriaBuilder.greaterThan(root.get("age"), 18));
    }
}
