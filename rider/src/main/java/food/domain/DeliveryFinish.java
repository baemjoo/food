package food.domain;

import food.domain.*;
import food.infra.AbstractEvent;
import java.util.*;
import lombok.*;

@Data
@ToString
public class DeliveryFinish extends AbstractEvent {

    private Long id;
    private String orderid;

    public DeliveryFinish(Delivery aggregate) {
        super(aggregate);
    }

    public DeliveryFinish() {
        super();
    }
}
