package ru.tework.spring4.services;

import java.util.concurrent.ExecutionException;

import ru.tework.spring4.dto.KafkaDto;

public interface KafkaService {

    String createKafkaDto(KafkaDto kafkaDto) throws InterruptedException, ExecutionException;

}
