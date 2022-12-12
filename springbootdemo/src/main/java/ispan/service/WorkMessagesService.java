package ispan.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ispan.model.WorkMessages;
import ispan.model.WorkMessagesRepository;

@Transactional
@Service
public class WorkMessagesService {
	
	@Autowired
	private WorkMessagesRepository messagesRepository;

	public WorkMessages insert(WorkMessages messages) {
		return messagesRepository.save(messages);
	}

	//找尋找是否存在	
	public WorkMessages findById(Integer Id) {
		Optional<WorkMessages> optionId = messagesRepository.findById(Id);
		if(optionId.isPresent()) {
			return optionId.get();
		}
		return null;
	}
	
//刪除
	public void deleteById(Integer Id){
		messagesRepository.deleteById(Id);
	}
	
	
	//製作分頁
										   //用頁數找到頁面
	public Page<WorkMessages> findByPage(Integer pageNumber){
							   //請求頁面方法 (從第幾頁開始  ,每頁幾筆 ,排序           , 以哪個屬性排序)
	PageRequest pageRequest = PageRequest.of(pageNumber-1, 3, Sort.Direction.DESC, "added");
	Page<WorkMessages> page = messagesRepository.findAll(pageRequest);
	return page;
	}
	
	
	public WorkMessages findLatest() {
		return messagesRepository.findFirstByOrderByAddedDesc();
	}
	
}
