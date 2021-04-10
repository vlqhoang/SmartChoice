package vlqhoang.project.smartchoice.ProductInfoService.service;

import vlqhoang.project.smartchoice.SmartChoiceCommonLib.dto.UserSearchEvtDTO;

public interface UserEvtProducerService {

    public void sendUserSearchEvt(UserSearchEvtDTO searchEvtDTO);
}
