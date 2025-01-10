package ru.tework.spring4.services;

import java.util.Random;
import java.util.UUID;
import java.util.concurrent.ExecutionException;
import java.util.logging.Logger;

import org.apache.kafka.clients.producer.ProducerRecord;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;

import ru.tework.spring4.dto.KafkaDto;
import ru.tework.spring6kafka.KafkaEventMy;

@Service
public class KafkaServiceImpl implements KafkaService {

    private KafkaTemplate<String, KafkaEventMy> kafkaTemplate;
    private final org.slf4j.Logger LOGGER = LoggerFactory.getLogger(this.getClass());

    public KafkaServiceImpl(KafkaTemplate<String, KafkaEventMy> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    @Override
    public String createKafkaDto(KafkaDto kafkaDto) throws InterruptedException, ExecutionException {
        Random random = new Random();
        String kafkaId = UUID.randomUUID().toString();

        KafkaEventMy kafkaEvent = new KafkaEventMy(kafkaId, kafkaDto.getTitle(),
                kafkaDto.getPrice(),
                kafkaDto.getQuantity());

        // for headers
        ProducerRecord<String, KafkaEventMy> record = new ProducerRecord<String, KafkaEventMy>(
                "product-created-events-topic", kafkaId, kafkaEvent);

        record.headers().add("messageId", UUID.randomUUID().toString().getBytes());

        // send to broker kafka
        SendResult<String, KafkaEventMy> result = kafkaTemplate.send(record).get();

        LOGGER.info("Topic: {}", result.getRecordMetadata().topic());
        LOGGER.info("Partition: {}", result.getRecordMetadata().partition());

        LOGGER.info("Offset: {}", result.getRecordMetadata().offset());
        LOGGER.info("Return: {}", kafkaId);

        return kafkaId;
    }

}
