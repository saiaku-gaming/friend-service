package com.valhallagame.friendserviceclient.model;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FriendsData {
	private List<Friend> friends;
	private List<Invite> sentInvites;
	private List<Invite> receivedInvites;
}
