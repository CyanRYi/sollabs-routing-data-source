package tech.sollabs.routingdatasource.dummy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
public class HumanController {

    @Autowired
    private HumanService humanService;

    @PostMapping(path = "/")
    public void postHuman(@RequestBody Human human) {

        humanService.registerHuman(human);
    }

    @GetMapping(path = "/")
    public Collection<Human> getHumanList() {

        return humanService.findHumanList();
    }
}
