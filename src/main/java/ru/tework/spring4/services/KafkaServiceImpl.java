package ru.tework.spring4.services;

import java.util.Random;
import java.util.UUID;
import java.util.concurrent.ExecutionException;
import java.util.logging.Logger;

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
    public Integer createKafkaDto(KafkaDto kafkaDto) throws InterruptedException, ExecutionException {
        Random rnd = new Random();
        Integer kafkaId = rnd.nextInt(6);

        KafkaEventMy kafkaEvent = new KafkaEventMy(kafkaId, kafkaDto.getTitle(),
                kafkaDto.getPrice(),
                kafkaDto.getQuantity());

        SendResult<String, KafkaEventMy> result = kafkaTemplate.send("product-created-events-topic",
                kafkaId.toString(0), kafkaEvent).get();

        LOGGER.info("Topic: {}", result.getRecordMetadata().topic());
        LOGGER.info("Partition: {}", result.getRecordMetadata().partition());

        LOGGER.info("Offset: {}", result.getRecordMetadata().offset());
        LOGGER.info("Return: {}", kafkaId);

        return kafkaId;
    }

}
