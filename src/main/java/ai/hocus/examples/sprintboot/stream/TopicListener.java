package ai.hocus.examples.sprintboot.stream;

import org.springframework.kafka.annotation.KafkaHandler;
import org.springframework.kafka.annotation.KafkaListener;

@KafkaListener(id = "listener", topics = "default")
public class TopicListener {

    @KafkaHandler
    public void listen(String data) {
        System.out.println(data);
    }
}
