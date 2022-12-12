package ispan.model;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface WorkMessagesRepository extends JpaRepository<WorkMessages, Integer> {

	public WorkMessages findFirstByOrderByAddedDesc();
	
}
