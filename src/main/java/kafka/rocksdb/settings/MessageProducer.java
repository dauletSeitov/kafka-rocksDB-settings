package kafka.rocksdb.settings;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.UUID;
import java.util.concurrent.CompletableFuture;

@Service
public class MessageProducer {

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    @PostConstruct
    public void init() throws InterruptedException {

        CompletableFuture.runAsync(() -> {
            for (int i = 0; i < Integer.MAX_VALUE; i++) {
                String msg = "test-message: " + i;
                System.out.println("messagae: [" + msg + "] sent");
                kafkaTemplate.send("baeldung", "baeldung test-message: " + i, UUID.randomUUID().toString());
                kafkaTemplate.send("baeldung2", "baeldung2 test-message: " + i, UUID.randomUUID().toString());
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });

    }
}
