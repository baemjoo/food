package food.domain;

import food.domain.*;
import food.infra.AbstractEvent;
import java.util.*;
import lombok.*;

@Data
@ToString
public class PickUpFood extends AbstractEvent {

    private Long id;
    private String orderid;
}
