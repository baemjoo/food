package food.domain;

import food.StoreApplication;
import food.domain.Reject;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;

@Entity
@Table(name = "Cook_table")
@Data
public class Cook {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String orderid;

    private String status;

    @PostPersist
    public void onPostPersist() {
        Reject reject = new Reject(this);
        reject.publishAfterCommit();
    }

    public static CookRepository repository() {
        CookRepository cookRepository = StoreApplication.applicationContext.getBean(
            CookRepository.class
        );
        return cookRepository;
    }

    public void acceptOrReject(AcceptOrRejectCommand acceptOrRejectCommand) {
        Accept accept = new Accept(this);
        accept.publishAfterCommit();
    }

    public void start() {
        CookStart cookStart = new CookStart(this);
        cookStart.publishAfterCommit();
    }

    public void end() {
        CookFinish cookFinish = new CookFinish(this);
        cookFinish.publishAfterCommit();
    }

    public static void foodOrderInfo(OrderPlaced orderPlaced) {
        /** Example 1:  new item 
        Cook cook = new Cook();
        repository().save(cook);

        */

        /** Example 2:  finding and process
        
        repository().findById(orderPlaced.get???()).ifPresent(cook->{
            
            cook // do something
            repository().save(cook);


         });
        */

    }
}
