package vlqhoang.project.smartchoice.SmartChoiceCommonLib.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.Date;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserSearchEvtDTO {
    @JsonProperty("ProductCode")
    private String productCode;

    @JsonProperty("UserID")
    private String userId;

    @JsonProperty("SearchStr")
    private String searchStr;

    @JsonProperty("SearchTime")
    private Date searchTime;
}
