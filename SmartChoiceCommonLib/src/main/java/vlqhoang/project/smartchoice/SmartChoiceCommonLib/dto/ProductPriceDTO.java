package vlqhoang.project.smartchoice.SmartChoiceCommonLib.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class ProductPriceDTO {
    private String productCode;
    private String productName;
    private Double price;
    private String vendorName;
}
