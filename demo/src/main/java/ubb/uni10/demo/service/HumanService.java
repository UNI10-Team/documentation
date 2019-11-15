package ubb.uni10.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;
import ubb.uni10.demo.entity.Human;
import ubb.uni10.demo.repository.HumanRepository;

import java.util.List;

@Service
public class HumanService {

    private HumanRepository humanRepository;

    @Autowired
    public HumanService(HumanRepository repository) {
        this.humanRepository = repository;
    }

    public Human save(Human entity) {
        return humanRepository.save(entity);
    }

    public List<String> getNames(int age) {
        return humanRepository.getNames(age);
    }

    public List<Human> findAll(Specification<Human> spec) {
        return humanRepository.findAll(spec);
    }
}
