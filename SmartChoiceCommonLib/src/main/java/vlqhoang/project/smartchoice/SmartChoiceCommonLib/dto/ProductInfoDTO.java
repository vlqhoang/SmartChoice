package vlqhoang.project.smartchoice.SmartChoiceCommonLib.dto;

import lombok.Data;

@Data
public class ProductInfoDTO {

    private String productCode;
    private String productName;
    private String type;
    private byte[] image;
}
