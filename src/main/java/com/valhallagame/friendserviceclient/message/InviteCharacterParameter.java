package com.valhallagame.friendserviceclient.message;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class InviteCharacterParameter {
	private String senderUsername;
	private String receiverCharacter;
}
