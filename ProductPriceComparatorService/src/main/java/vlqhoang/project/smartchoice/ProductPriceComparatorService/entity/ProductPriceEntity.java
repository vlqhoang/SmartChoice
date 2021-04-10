package vlqhoang.project.smartchoice.ProductPriceComparatorService.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "PRODUCT_PRICE")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductPriceEntity {

    @Id
    @Column(name = "id", unique = true, nullable = false)
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "org.hibernate.id.UUIDGenerator")
    private String id;

    @Column(name = "ref_product_code")
    private String productCode;

    @Column(name = "ref_vendor_id")
    private String vendorId;

    @Column(name = "product_origin_code")
    private String productOriginCode;

    @Column(name = "price")
    private Double price;

    @Column(name = "update_time")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updateTime;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="ref_product_code", referencedColumnName="product_code", insertable = false, updatable = false)
    private ProductEntity product;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="ref_vendor_id", referencedColumnName="vendor_id", insertable = false, updatable = false)
    private ProductVendorEntity vendor;
}
