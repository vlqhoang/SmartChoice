package vlqhoang.project.smartchoice.ProductService.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "PRODUCT")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductEntity {

    @Id
    @Column(name = "product_code", unique = true, nullable = false)
    private String productCode;

    @Column(name = "product_name")
    private String productName;

    @Column(name = "product_type")
    private String productType;
}
