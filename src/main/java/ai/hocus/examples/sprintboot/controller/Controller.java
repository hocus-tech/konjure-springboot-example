package ai.hocus.examples.sprintboot.controller;

import ai.hocus.examples.sprintboot.model.User;
import ai.hocus.examples.sprintboot.repository.UserRepository;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    @Autowired
    private KafkaTemplate<Object, Object> kafkaTemplate;

    private final UserRepository userRepository;

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Autowired
    private MongoTemplate mongoTemplate;

    public Controller(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @PostMapping(path = "/send/{message}")
    public void sendMessage(@PathVariable String message) {
        this.kafkaTemplate.send("topic", message);
    }

    @PostMapping(path = "/insert/user")
    public void insertUser(@RequestBody User user) {
        userRepository.save(user);
    }

    @PostMapping(path = "/queue/{message}")
    public void queueMessage(@PathVariable String message) {
        rabbitTemplate.send(new Message(message.getBytes()));
    }

}
