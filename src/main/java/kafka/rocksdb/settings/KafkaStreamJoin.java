package kafka.rocksdb.settings;

import org.apache.kafka.common.serialization.Serdes;
import org.apache.kafka.streams.StreamsBuilder;
import org.apache.kafka.streams.kstream.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.Duration;

@Configuration
public class KafkaStreamJoin {

    @Bean
    public KStream<String, String> join(StreamsBuilder builder) {
        KStream<String, String> stream1 = builder.stream("baeldung", Consumed.with(Serdes.String(), Serdes.String()));
        KStream<String, String> stream2 = builder.stream("baeldung2", Consumed.with(Serdes.String(), Serdes.String()));


// Join stream1 and stream2
        KStream<String, String> joinedStream = stream1.join(
                stream2,
                (value1, value2) -> value1 + "-" + value2,  // Value Joiner
                JoinWindows.ofTimeDifferenceWithNoGrace(Duration.ofMinutes(1)),  // Window duration
                StreamJoined.with(Serdes.String(), Serdes.String(), Serdes.String())  // Serdes
        );

// Write the result to another topic
        joinedStream.to("joinedTopic", Produced.with(Serdes.String(), Serdes.String()));


        return  joinedStream;
    }
}
