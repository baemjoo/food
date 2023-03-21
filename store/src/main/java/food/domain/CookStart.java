package food.domain;

import food.domain.*;
import food.infra.AbstractEvent;
import java.util.*;
import lombok.*;

@Data
@ToString
public class CookStart extends AbstractEvent {

    private Long id;
    private String orderid;
    private String status;

    public CookStart(Cook aggregate) {
        super(aggregate);
    }

    public CookStart() {
        super();
    }
}
