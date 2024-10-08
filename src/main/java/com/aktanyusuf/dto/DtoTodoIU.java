package com.aktanyusuf.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DtoTodoIU {

	private String todo;
	private String description;
	private Boolean completed;

}
