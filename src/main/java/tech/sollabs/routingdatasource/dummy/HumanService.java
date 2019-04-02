package tech.sollabs.routingdatasource.dummy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class HumanService {

    @Autowired
    private HumanRepository humanRepository;

    public void registerHuman(Human human) {
        humanRepository.save(human);
    }

    public Collection<Human> findHumanList() {
        return humanRepository.findAll();
    }
}
