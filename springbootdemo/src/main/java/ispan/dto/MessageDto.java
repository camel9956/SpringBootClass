package ispan.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class MessageDto {

	@JsonProperty("Message")
	public String Msg;

	public MessageDto() {
	}

	public String getMsg() {
		return Msg;
	}

	public void setMsg(String msg) {
		Msg = msg;
	}

}
