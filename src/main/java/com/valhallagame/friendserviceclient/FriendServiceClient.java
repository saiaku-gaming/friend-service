package com.valhallagame.friendserviceclient;

import java.io.IOException;

import com.valhallagame.common.DefaultServicePortMappings;
import com.valhallagame.common.RestCaller;
import com.valhallagame.common.RestResponse;
import com.valhallagame.friendserviceclient.message.AcceptCharacterParameter;
import com.valhallagame.friendserviceclient.message.AcceptPersonParameter;
import com.valhallagame.friendserviceclient.message.DeclineCharacterParameter;
import com.valhallagame.friendserviceclient.message.DeclinePersonParameter;
import com.valhallagame.friendserviceclient.message.InviteCharacterParameter;
import com.valhallagame.friendserviceclient.message.InvitePersonParameter;
import com.valhallagame.friendserviceclient.message.RemoveCharacterFriendParameter;
import com.valhallagame.friendserviceclient.message.RemovePersonFriendParameter;
import com.valhallagame.friendserviceclient.message.UsernameParameter;
import com.valhallagame.friendserviceclient.model.FriendsData;

public class FriendServiceClient {
	private static FriendServiceClient friendServiceClient;

	private String friendServiceServerUrl = "http://localhost:" + DefaultServicePortMappings.FRIEND_SERVICE_PORT;
	private RestCaller restCaller;

	private FriendServiceClient() {
		restCaller = new RestCaller();
	}

	public static void init(String friendServiceServerUrl) {
		FriendServiceClient client = get();
		client.friendServiceServerUrl = friendServiceServerUrl;
	}

	public static FriendServiceClient get() {
		if (friendServiceClient == null) {
			friendServiceClient = new FriendServiceClient();
		}

		return friendServiceClient;
	}

	public RestResponse<String> sendPersonInvite(String senderUsername, String receiverUsername) throws IOException {
		return restCaller.postCall(friendServiceServerUrl + "/v1/friend/send-person-invite",
				new InvitePersonParameter(senderUsername, receiverUsername), String.class);
	}
	
	public RestResponse<String> sendCharacterInvite(String senderUsername, String receiverCharacterName) throws IOException {
		return restCaller.postCall(friendServiceServerUrl + "/v1/friend/send-character-invite",
				new InviteCharacterParameter(senderUsername, receiverCharacterName), String.class);
	}

	public RestResponse<String> acceptPersonInvite(String accepterUsername, String accpeteeUsername) throws IOException {
		return restCaller.postCall(friendServiceServerUrl + "/v1/friend/accept-person-invite",
				new AcceptPersonParameter(accepterUsername, accpeteeUsername), String.class);
	}

	public RestResponse<String> acceptCharacterInvite(String accepterUsername, String accpeteeCharacterName) throws IOException {
		return restCaller.postCall(friendServiceServerUrl + "/v1/friend/accept-character-invite",
				new AcceptCharacterParameter(accepterUsername, accpeteeCharacterName), String.class);
	}

	public RestResponse<String> declinePersonInvite(String declinerUsername, String declineeUsername) throws IOException {
		return restCaller.postCall(friendServiceServerUrl + "/v1/friend/decline-person-invite",
				new DeclinePersonParameter(declinerUsername, declineeUsername), String.class);
	}

	public RestResponse<String> declineCharacterInvite(String declinerUsername, String declineeCharacterName) throws IOException {
		return restCaller.postCall(friendServiceServerUrl + "/v1/friend/decline-character-invite",
				new DeclineCharacterParameter(declinerUsername, declineeCharacterName), String.class);
	}
	
	
	public RestResponse<String> removePersonFriend(String removerUsername, String removeeUsername) throws IOException {
		return restCaller.postCall(friendServiceServerUrl + "/v1/friend/remove-person-friend",
				new RemovePersonFriendParameter(removerUsername, removeeUsername), String.class);
	}
	
	public RestResponse<String> removeCharacterFriend(String removerUsername, String removeeCharacterName) throws IOException {
		return restCaller.postCall(friendServiceServerUrl + "/v1/friend/remove-character-friend",
				new RemoveCharacterFriendParameter(removerUsername, removeeCharacterName), String.class);
	}

	public RestResponse<FriendsData> getFriendData(String username) throws IOException {
		return restCaller.postCall(friendServiceServerUrl + "/v1/friend/get-friend-data",
				new UsernameParameter(username), FriendsData.class);
	}
}
