package com.stackroute.userloginservice.userloginservice.service;

import com.stackroute.userloginservice.userloginservice.model.DAOUser;
import com.stackroute.userloginservice.userloginservice.model.MessageUser;
import com.stackroute.userloginservice.userloginservice.model.UserDTO;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class RabbitMQSender {

    @Autowired
    private AmqpTemplate rabbitTemplate;

    @Value("register.exchange")
    private String exchange;

    @Value("register.key")
    private String routingkey;

    public void sendToken(String token) {
        rabbitTemplate.convertAndSend(exchange, routingkey, token);
        System.out.println("Send token = " + token);
    }

    public void sendUser(MessageUser user) {
        rabbitTemplate.convertAndSend(exchange,routingkey, user);
        System.out.println("Send User = " + user);
    }

}
