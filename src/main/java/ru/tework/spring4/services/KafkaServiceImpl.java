package ru.tework.spring4.services;

import java.util.Random;
import java.util.UUID;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import ru.tework.spring4.dto.KafkaDto;
import ru.tework.spring4.services.event.KafkaEventMy;

@Service
public class KafkaServiceImpl implements KafkaService {

    private KafkaTemplate<String, KafkaEventMy> kafkaTemplate;

    public KafkaServiceImpl(KafkaTemplate<String, KafkaEventMy> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    @Override
    public Integer createKafkaDto(KafkaDto kafkaDto) {
        Random rnd = new Random();
        Integer kafkaId = rnd.nextInt(6);

        KafkaEventMy kafkaEvent = new KafkaEventMy(kafkaId, kafkaDto.getTitle(),
                kafkaDto.getPrice(),
                kafkaDto.getQuantity());

        kafkaTemplate.send("product-created-events-topic", kafkaId.toString(0), kafkaEvent);


        return kafkaId;
    }

}
