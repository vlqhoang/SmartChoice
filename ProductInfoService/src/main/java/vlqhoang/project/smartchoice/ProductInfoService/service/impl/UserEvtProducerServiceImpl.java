package vlqhoang.project.smartchoice.ProductInfoService.service.impl;

import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import vlqhoang.project.smartchoice.ProductInfoService.service.UserEvtProducerService;
import vlqhoang.project.smartchoice.SmartChoiceCommonLib.dto.UserSearchEvtDTO;

@Service
@Log4j2
public class UserEvtProducerServiceImpl implements UserEvtProducerService {

    @Value("${application.configs.topic.name}")
    private String topicName;

    @Autowired
    private KafkaTemplate<String, UserSearchEvtDTO> kafkaTemplateProducer;

    @Override
    @Transactional(transactionManager = "userSearchEvtTransactionManager")
    public void sendUserSearchEvt(UserSearchEvtDTO searchEvtDTO) {
        log.info(String.format("Producing search event, searching for: %s by user id: %s",
                searchEvtDTO.getSearchStr(), searchEvtDTO.getUserId()));
        kafkaTemplateProducer.send(topicName, searchEvtDTO.getUserId(), searchEvtDTO);
    }
}
