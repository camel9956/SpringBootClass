package ispan.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

@Entity
@Table(name = "goodPhoto")
public class GoodPhoto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "photo_name")
	private String goodName;
	
	@Lob  //跟hibernate 說是largeObject(file)，否則會傳回字串
	@Column(name = "photo_file")
	private byte[] goodfile;
	
	public GoodPhoto() {
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getGoodName() {
		return goodName;
	}

	public void setGoodName(String goodName) {
		this.goodName = goodName;
	}

	public byte[] getGoodfile() {
		return goodfile;
	}

	public void setGoodfile(byte[] goodfile) {
		this.goodfile = goodfile;
	}

	
}
