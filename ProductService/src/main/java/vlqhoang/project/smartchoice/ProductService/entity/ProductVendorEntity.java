package vlqhoang.project.smartchoice.ProductService.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name = "PRODUCT_VENDOR")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductVendorEntity {

    @Id
    @Column(name = "vendor_id", unique = true, nullable = false)
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "org.hibernate.id.UUIDGenerator")
    private String vendorId;

    @Column(name = "vendor_name")
    private String vendorName;

    @Column(name = "vendor_page")
    private String vendorOfficialPage;
}
