package ispan.service;



import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ispan.model.GoodPhoto;
import ispan.model.GoodPhotoRepository;

@Transactional
@Service
public class GoodPhotoService {

	@Autowired
	private GoodPhotoRepository goodPhotoRepository;
	
	
	public GoodPhoto insertPhoto(GoodPhoto goodPhoto) {
		return goodPhotoRepository.save(goodPhoto);
	}
	
	public List<GoodPhoto> listPhoto(){
		return goodPhotoRepository.findAll();
	}
	
	public GoodPhoto getPhotoById(Integer id) {
		Optional<GoodPhoto> optionalId = goodPhotoRepository.findById(id);
		if (optionalId.isPresent()) {
			return optionalId.get();
		}
		return null;
	}
}
