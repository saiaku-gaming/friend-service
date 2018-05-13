package com.valhallagame.friendserviceclient.message;

import javax.validation.constraints.NotNull;

import com.valhallagame.common.ExposedNameInYmer;
import com.valhallagame.common.validation.CheckLowercase;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DeclineCharacterParameter {
	@NotNull
	@CheckLowercase
	private String username;
	@NotNull
	@ExposedNameInYmer("characterName")
	private String displayCharacterName;
}
