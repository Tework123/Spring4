package ru.tework.spring4.controllers;

import java.util.concurrent.ExecutionException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import ru.tework.spring4.dto.KafkaDto;
import ru.tework.spring4.services.KafkaServiceImpl;

@RestController
public class KafkaController {

    private KafkaServiceImpl kafkaServiceImpl;

    public KafkaController(KafkaServiceImpl kafkaServiceImpl) {
        this.kafkaServiceImpl = kafkaServiceImpl;

    }

    @PostMapping("/kafka")
    public ResponseEntity<Integer> postMethodName(@RequestBody KafkaDto kafkaDto) throws InterruptedException, ExecutionException {
        Integer kafkaId = kafkaServiceImpl.createKafkaDto(kafkaDto);

        return ResponseEntity.status(HttpStatus.CREATED).body(kafkaId);
    }
}
