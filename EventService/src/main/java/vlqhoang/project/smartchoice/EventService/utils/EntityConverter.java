package vlqhoang.project.smartchoice.EventService.utils;

import vlqhoang.project.smartchoice.EventService.entity.UserEventEntity;
import vlqhoang.project.smartchoice.SmartChoiceCommonLib.dto.UserSearchEvtDTO;

public class EntityConverter {

    /**
     * Convert dto to UserEventEntity entity
     * @param dto - UserSearchEvtDTO dto to be converted
     * @return UserEventEntity
     */
    public static UserEventEntity convertToUserEvtEntity(UserSearchEvtDTO dto) {
        UserEventEntity eventEntity = new UserEventEntity();
        eventEntity.setProductCode(dto.getProductCode());
        eventEntity.setUserID(dto.getUserId());
        eventEntity.setSearchString(dto.getSearchStr());
        eventEntity.setSearchTime(dto.getSearchTime());
        return eventEntity;
    }
}
