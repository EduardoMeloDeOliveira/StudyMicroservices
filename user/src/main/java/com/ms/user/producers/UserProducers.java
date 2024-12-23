package com.ms.user.producers;

import com.ms.user.dtos.EmailDto;
import com.ms.user.models.UserModel;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class UserProducers {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Value("${broker.queue.email.name}")
    private String routingKey;


    public void publishMessageEmail(UserModel userModel) {


        EmailDto dto = EmailDto.builder()
                .id(userModel.getId())
                .email(userModel.getEmail())
                .subject("Cadastro realizado com sucesso")
                .text("""
                        %s, seja muito bem vindo!
                        Agradecemos o seu cadastro,aproveite a plataforma""".formatted(userModel.getName()))
                .build();


        rabbitTemplate.convertAndSend("",routingKey,dto);

    }


}
