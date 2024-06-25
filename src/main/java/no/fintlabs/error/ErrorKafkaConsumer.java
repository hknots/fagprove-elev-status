//package no.fintlabs.error;
//
//import lombok.RequiredArgsConstructor;
//import no.fintlabs.kafka.event.error.ErrorCollection;
//import no.fintlabs.kafka.event.error.ErrorEventConsumerFactoryService;
//import no.fintlabs.kafka.event.error.topic.ErrorEventTopicNameParameters;
//import org.apache.kafka.clients.consumer.ConsumerRecord;
//import org.springframework.context.annotation.Bean;
//import org.springframework.kafka.listener.ConcurrentMessageListenerContainer;
//import org.springframework.stereotype.Service;
//
//@Service
//@RequiredArgsConstructor
//public class ErrorKafkaConsumer {
//
//    private final ErrorEventConsumerFactoryService errorEventConsumerFactoryService;
//
//    @Bean
//    public ConcurrentMessageListenerContainer<String, ErrorCollection> registerErrorLogKafkaConsumer() {
//        return errorEventConsumerFactoryService.createFactory(
//                this::consume
//        ).createContainer(
//                ErrorEventTopicNameParameters.builder()
//                        .errorEventName("elev")
//                        .build()
//        );
//    }
//
//    // fintlabs-no.fagprove.event.error.elev
//
//    private void consume(ConsumerRecord<String, ErrorCollection> stringErrorCollectionConsumerRecord) {
//
//    }
//
//}
