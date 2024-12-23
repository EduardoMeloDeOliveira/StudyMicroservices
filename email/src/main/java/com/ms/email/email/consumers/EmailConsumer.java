package com.ms.email.email.consumers;

import com.ms.email.email.dtos.EmailRecordDTO;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class EmailConsumer {

    @RabbitListener(queues = "${broker.queue.email.name}")
    public void listenEmailQueue(@Payload EmailRecordDTO dto){
        System.out.println(dto.email());
    }

}
