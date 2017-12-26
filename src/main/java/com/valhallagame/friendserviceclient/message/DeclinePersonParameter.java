package com.valhallagame.friendserviceclient.message;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DeclinePersonParameter {
	private String decliner;
	private String declinee;
}
