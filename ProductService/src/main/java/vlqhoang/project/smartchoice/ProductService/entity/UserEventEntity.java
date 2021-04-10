package vlqhoang.project.smartchoice.ProductService.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "USR_EVT")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserEventEntity {

    @Id
    @Column(name = "id", unique = true, nullable = false)
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "org.hibernate.id.UUIDGenerator")
    private String id;

    @Column(name = "ref_product_code")
    private String productCode;

    @Column(name = "ref_user_id")
    private String userID;

    @Column(name = "search_str")
    private String searchString;

    @Column(name = "search_time")
    @Temporal(TemporalType.TIMESTAMP)
    private Date searchTime;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="ref_product_code", referencedColumnName="product_code", insertable = false, updatable = false)
    private ProductEntity product;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="ref_user_id", referencedColumnName="user_id", insertable = false, updatable = false)
    private UserEntity user;
}
