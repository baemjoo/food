package food.infra;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import food.config.kafka.KafkaProcessor;
import food.domain.*;
import javax.naming.NameParser;
import javax.naming.NameParser;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class PolicyHandler {

    @Autowired
    OrderRepository orderRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whatever(@Payload String eventString) {}

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='CookStart'"
    )
    public void wheneverCookStart_UpdateStatus(@Payload CookStart cookStart) {
        CookStart event = cookStart;
        System.out.println(
            "\n\n##### listener UpdateStatus : " + cookStart + "\n\n"
        );

        // Sample Logic //
        Order.updateStatus(event);
    }

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='PickUpFood'"
    )
    public void wheneverPickUpFood_UpdateStatus(
        @Payload PickUpFood pickUpFood
    ) {
        PickUpFood event = pickUpFood;
        System.out.println(
            "\n\n##### listener UpdateStatus : " + pickUpFood + "\n\n"
        );

        // Sample Logic //
        Order.updateStatus(event);
    }
}
