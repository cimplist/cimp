package com.cimplist.cip.user.web.rest;

import java.io.IOException;

import com.cimplist.cip.user.domain.User;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

public class UserSerializer extends JsonSerializer<User> {

	@Override
	public void serialize(User user, JsonGenerator jgen,
			SerializerProvider provider) throws IOException,
			JsonProcessingException {
		jgen.writeStartObject();
		jgen.writeNumberField("Key", user.getKey());
		jgen.writeStringField("UserID", user.getUserName());
		jgen.writeStringField("Name", user.getFname()+" "+user.getMname()+" "+user.getLname());
		jgen.writeStringField("Manager", user.getManager().getFname()+" "+user.getManager().getMname()+" "+user.getManager().getLname());
		jgen.writeStringField("Email", user.getEmail());		
		jgen.writeEndObject();

	}
}
