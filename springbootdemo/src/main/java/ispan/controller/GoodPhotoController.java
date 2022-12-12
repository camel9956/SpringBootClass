package ispan.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import ispan.model.GoodPhoto;
import ispan.service.GoodPhotoService;

@Controller
public class GoodPhotoController {

	@Autowired
	private GoodPhotoService goodPhotoService;
	
	@GetMapping("/newPhoto")
	public String newPhoto() {
		return "goodphoto/uploadPage";
	}
	
	@PostMapping("/fileUpload")
	public String postNewPhoto(@RequestParam("photoName") String name,
							   @RequestParam("file") MultipartFile file) {
		GoodPhoto goodPhoto = new GoodPhoto();
		try {
			goodPhoto.setGoodName(name);
			goodPhoto.setGoodfile(file.getBytes());
			
			goodPhotoService.insertPhoto(goodPhoto);
			
			return "goodphoto/uploadSuccessPage";
		
		} catch (IOException e) {
			e.printStackTrace();
			return "redirect:/";
		}
	}
	
	@GetMapping("/listPhoto")
	public String listPhoto(Model model){
		List<GoodPhoto> list = goodPhotoService.listPhoto();
		model.addAttribute("listPhoto", list);
		return "goodphoto/listPhoto";
	}
	
	@GetMapping("/downloadImage/{id}")
	public ResponseEntity<byte[]> listImg(@PathVariable("id") Integer id){
		GoodPhoto photoById = goodPhotoService.getPhotoById(id);
		//取得格式為byte[]
		byte[] img = photoById.getGoodfile();
		//設定回傳header格式為jpg，改掉header回傳的方式(圖片回傳的方式不是html)
		HttpHeaders headers = new HttpHeaders();	
		headers.setContentType(MediaType.IMAGE_PNG);
								 //要回傳的物件,headers,回傳狀態碼為OK(200)
		return new ResponseEntity<byte[]>(img,headers,HttpStatus.OK);
	}
}
