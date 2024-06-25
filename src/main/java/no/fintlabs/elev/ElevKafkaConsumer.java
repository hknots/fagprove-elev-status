//package no.fintlabs.elev;
//
//import lombok.RequiredArgsConstructor;
//import no.fintlabs.kafka.entity.EntityConsumerFactoryService;
//import no.fintlabs.kafka.entity.topic.EntityTopicNameParameters;
//import org.apache.kafka.clients.consumer.ConsumerRecord;
//import org.springframework.context.annotation.Bean;
//import org.springframework.kafka.listener.ConcurrentMessageListenerContainer;
//import org.springframework.stereotype.Service;
//
//@Service
//@RequiredArgsConstructor
//public class ElevKafkaConsumer {
//
//    private final EntityConsumerFactoryService entityConsumerFactoryService;
//
//    @Bean
//    public ConcurrentMessageListenerContainer<String, Elev> registerElevKafkaConsumer() {
//        return entityConsumerFactoryService.createFactory(
//                Elev.class,
//                this::consume
//        ).createContainer(
//                EntityTopicNameParameters.builder()
//                        .resource("elev")
//                        .build()
//        );
//    }
//
//    // fintlabs-no.fagprove.entity.elev
//
//    private void consume(ConsumerRecord<String, Elev> consumerRecord) {
//
//    }
//
//}
