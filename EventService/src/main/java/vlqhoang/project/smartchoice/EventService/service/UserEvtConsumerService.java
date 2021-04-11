package vlqhoang.project.smartchoice.EventService.service;

import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.stereotype.Service;
import vlqhoang.project.smartchoice.EventService.repository.UserEventRepository;
import vlqhoang.project.smartchoice.EventService.utils.EntityConverter;
import vlqhoang.project.smartchoice.SmartChoiceCommonLib.dto.UserSearchEvtDTO;

@Service
@Log4j2
public class UserEvtConsumerService {

    @Autowired
    private UserEventRepository userEventRepository;

    /**
     * Kafka consumer - listening on incoming messages
     * @param searchEvtDTO - message DTO
     * @param acknowledgment - for manual committing message
     */
    @KafkaListener(topics = "evt-usr-search-topic", containerFactory = "userSearchEvtListenerContainerFactory")
    private void searchEvtListener(UserSearchEvtDTO searchEvtDTO, Acknowledgment acknowledgment){
        log.info("User is searching for {}", searchEvtDTO.getSearchStr());
        userEventRepository.save(EntityConverter.convertToUserEvtEntity(searchEvtDTO));
        acknowledgment.acknowledge(); // commit
    }
}
