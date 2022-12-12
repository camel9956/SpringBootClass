package ispan.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import ispan.dto.MessageDto;
import ispan.model.WorkMessages;
import ispan.service.WorkMessagesService;

@Controller
public class MessagesController {

	@Autowired
	private WorkMessagesService messagesService;
	
	@GetMapping("/messages/add")
	public String addMessage(Model model) {
		//送出空白表單
		WorkMessages workMessages = new WorkMessages();
		model.addAttribute("workMessages", workMessages);
		//顯示最新留言
		WorkMessages latestMsg = messagesService.findLatest();
		model.addAttribute("latestMsg", latestMsg);
		
		return "messages/addMessages";
	}
	
	@PostMapping("/messages/add")
	public String postMessages(@ModelAttribute WorkMessages messages,Model model) {
		messagesService.insert(messages);
		WorkMessages workMessages = new WorkMessages();
		model.addAttribute("workMessages", workMessages);
		//顯示最新留言
		WorkMessages latestMsg = messagesService.findLatest();
		model.addAttribute("latestMsg", latestMsg);
		return "messages/addMessages" ;
	}
	
	@GetMapping("/messages/page")
	public String viewMessages(@RequestParam(name="p",defaultValue = "1") Integer pageNumber,Model model) {
		Page<WorkMessages> page=messagesService.findByPage(pageNumber);
		model.addAttribute("page",page);	
		return "messages/viewMessages" ;
	}
	
	@GetMapping("/message/edit")
	public String editMessage(@RequestParam Integer id,Model model) {
		WorkMessages findMessage = messagesService.findById(id);
		model.addAttribute("editMessage",findMessage);
		return "messages/editMessage";
	}

	@PostMapping("/message/posteditMessage")
	public String postEditMessage(@ModelAttribute WorkMessages messages) {
		messagesService.insert(messages);
		return "redirect:/messages/page";
	}
	
	@GetMapping("/messages/delete")
	public String deleteMessage(@RequestParam Integer id,Model model) {
		messagesService.deleteById(id);
		return "redirect:/messages/page" ;
	}

	//送出message之後，顯示最新的三則留言
	//RESTfull  ajax
	@ResponseBody
	@PostMapping("/api/postMessages")
	public List<WorkMessages> postMessages(@RequestBody MessageDto messageDto){
		String newMsg= messageDto.getMsg();
		WorkMessages workMessages = new WorkMessages();
		workMessages.setText(newMsg);
		messagesService.insert(workMessages);

		Page<WorkMessages> page=messagesService.findByPage(1);
		List<WorkMessages> list = page.getContent();
		return list;
	}
	
	@GetMapping("/messages/ajaxMessages")
	public String ajaxPage() {
		return "messages/ajaxMessages";
	}
}
