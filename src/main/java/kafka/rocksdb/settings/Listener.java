package kafka.rocksdb.settings;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class Listener {

//    @KafkaListener(topics = "baeldung")
//    public void listenGroupFoo(String message) {
//        System.out.println("Received Message in group foo: " + message);
//    }
//
//    @KafkaListener(topics = "baeldung2")
//    public void listenGroupFoo2(String message) {
//        System.out.println("Received Message in group foo: " + message);
//    }

    @KafkaListener(topics = "joinedTopic")
    public void listenGroupFoo3(String message) {
        System.out.println("joinedTopic Received Message in group foo: " + message);
    }



}
