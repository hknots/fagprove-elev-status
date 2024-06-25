package no.fintlabs.action;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import no.fintlabs.kafka.entity.EntityConsumerFactoryService;
import no.fintlabs.kafka.entity.topic.EntityTopicNameParameters;
import no.fintlabs.kafka.event.topic.EventTopicNameParameters;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.listener.ConcurrentMessageListenerContainer;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class ActionLogKafkaConsumer {

    private final EntityConsumerFactoryService entityConsumerFactoryService;
    private final ActionController actionController;

    @Bean
    public ConcurrentMessageListenerContainer<String, ActionLog> registerActionLogKafkaConsumer() {
        return entityConsumerFactoryService.createFactory(
                ActionLog.class,
                this::consume
        ).createContainer(
                EntityTopicNameParameters.builder()
                        .resource("actionlog")
                        .build()
        );
    }

    // fintlabs-no.fagprove.entity.actionlog

    private void consume(ConsumerRecord<String, ActionLog> consumerRecord) {
        log.info("Consumed ActionLog: {}", consumerRecord.key());
        actionController.addActionLog(consumerRecord.value());
    }

}
