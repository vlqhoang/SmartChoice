package vlqhoang.project.smartchoice.EventService.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vlqhoang.project.smartchoice.EventService.entity.UserEventEntity;

@Repository
public interface UserEventRepository extends JpaRepository<UserEventEntity, String> {
}
