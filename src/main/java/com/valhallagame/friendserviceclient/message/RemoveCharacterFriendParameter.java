package com.valhallagame.friendserviceclient.message;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RemoveCharacterFriendParameter {
	private String removerUsername;
	private String removeeCharacterName;
}
