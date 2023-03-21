package food.domain;

import food.domain.*;
import food.infra.AbstractEvent;
import java.util.*;
import lombok.*;

@Data
@ToString
public class Reject extends AbstractEvent {

    private Long id;
    private String orderid;

    public Reject(Cook aggregate) {
        super(aggregate);
    }

    public Reject() {
        super();
    }
}