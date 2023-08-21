package ai.hocus.examples.sprintboot.queue;

import org.springframework.amqp.rabbit.annotation.RabbitListener;

public class QueueListener {

    @RabbitListener
    public void listen(String in) {
        System.out.println(in);
    }
}
