package com.base.ecom.user;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;

@JsonDeserialize(builder = UserDto.Builder.class)
public class UserDto {

    private long id;
    private String userName;
    private String password;

	public long getId() {
		return id;
	}

	public String getUserName() {
		return userName;
	}

	public String getPassword() {
		return password;
	}

    @JsonPOJOBuilder(buildMethodName = "build", withPrefix = "")
	public static class Builder {
		private long id;
	    private String userName;
	    private String password;

		public Builder id(long id) {
			this.id = id;
			return this;
		}

		public Builder password(String password) {
			this.password = password;
			return this;
		}

		public Builder userName(String userName) {
			this.userName = userName;
			return this;
		}

		public UserDto build() {
			return new UserDto(this);
		}
	}

    private UserDto(Builder builder) {
    	this.id = builder.id;
    	this.userName = builder.userName;
    	this.password = builder.password;
    }
}

