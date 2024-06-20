package no.fintlabs.action;

import lombok.RequiredArgsConstructor;
import no.fintlabs.kafka.event.EventConsumerFactoryService;
import no.fintlabs.kafka.event.topic.EventTopicNameParameters;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.listener.ConcurrentMessageListenerContainer;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ActionLogKafkaConsumer {

    private final EventConsumerFactoryService eventConsumerFactoryService;

    @Bean
    public ConcurrentMessageListenerContainer<String, ActionLog> registerActionLogKafkaConsumer() {
        return eventConsumerFactoryService.createFactory(
                ActionLog.class,
                this::consume
        ).createContainer(
                EventTopicNameParameters.builder()
                        .eventName("elev-action")
                        .build()
        );
    }

    // fintlabs-no.fagprove.event.elev-action

    private void consume(ConsumerRecord<String, ActionLog> consumerRecord) {

    }

}
