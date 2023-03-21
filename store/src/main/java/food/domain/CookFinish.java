package food.domain;

import food.domain.*;
import food.infra.AbstractEvent;
import java.util.*;
import lombok.*;

@Data
@ToString
public class CookFinish extends AbstractEvent {

    private Long id;
    private String orderid;
    private String status;

    public CookFinish(Cook aggregate) {
        super(aggregate);
    }

    public CookFinish() {
        super();
    }
}
