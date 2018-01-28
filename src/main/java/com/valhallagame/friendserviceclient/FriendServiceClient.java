package com.valhallagame.friendserviceclient;

import java.io.IOException;

import com.valhallagame.common.DefaultServicePortMappings;
import com.valhallagame.common.RestCaller;
import com.valhallagame.common.RestResponse;
import com.valhallagame.friendserviceclient.message.AcceptCharacterInviteParameter;
import com.valhallagame.friendserviceclient.message.AcceptPersonInviteParameter;
import com.valhallagame.friendserviceclient.message.DeclineCharacterParameter;
import com.valhallagame.friendserviceclient.message.DeclinePersonInviteParameter;
import com.valhallagame.friendserviceclient.message.GetFriendDataParameter;
import com.valhallagame.friendserviceclient.message.InviteCharacterParameter;
import com.valhallagame.friendserviceclient.message.InvitePersonParameter;
import com.valhallagame.friendserviceclient.message.RemoveCharacterFriendParameter;
import com.valhallagame.friendserviceclient.message.RemovePersonFriendParameter;
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

	public RestResponse<String> sendPersonInvite(String username, String receiverUsername) throws IOException {
		return restCaller.postCall(friendServiceServerUrl + "/v1/friend/send-person-invite",
				new InvitePersonParameter(username, receiverUsername), String.class);
	}
	
	public RestResponse<String> sendCharacterInvite(String username, String receiverCharacterName) throws IOException {
		return restCaller.postCall(friendServiceServerUrl + "/v1/friend/send-character-invite",
				new InviteCharacterParameter(username, receiverCharacterName), String.class);
	}

	public RestResponse<String> acceptPersonInvite(String username, String accpeteeUsername) throws IOException {
		return restCaller.postCall(friendServiceServerUrl + "/v1/friend/accept-person-invite",
				new AcceptPersonInviteParameter(username, accpeteeUsername), String.class);
	}

	public RestResponse<String> acceptCharacterInvite(String username, String accpeteeCharacterName) throws IOException {
		return restCaller.postCall(friendServiceServerUrl + "/v1/friend/accept-character-invite",
				new AcceptCharacterInviteParameter(username, accpeteeCharacterName), String.class);
	}

	public RestResponse<String> declinePersonInvite(String username, String declineeUsername) throws IOException {
		return restCaller.postCall(friendServiceServerUrl + "/v1/friend/decline-person-invite",
				new DeclinePersonInviteParameter(username, declineeUsername), String.class);
	}

	public RestResponse<String> declineCharacterInvite(String username, String declineeCharacterName) throws IOException {
		return restCaller.postCall(friendServiceServerUrl + "/v1/friend/decline-character-invite",
				new DeclineCharacterParameter(username, declineeCharacterName), String.class);
	}
	
	
	public RestResponse<String> removePersonFriend(String username, String removeeUsername) throws IOException {
		return restCaller.postCall(friendServiceServerUrl + "/v1/friend/remove-person-friend",
				new RemovePersonFriendParameter(username, removeeUsername), String.class);
	}
	
	public RestResponse<String> removeCharacterFriend(String username, String removeeCharacterName) throws IOException {
		return restCaller.postCall(friendServiceServerUrl + "/v1/friend/remove-character-friend",
				new RemoveCharacterFriendParameter(username, removeeCharacterName), String.class);
	}

	public RestResponse<FriendsData> getFriendData(String username) throws IOException {
		return restCaller.postCall(friendServiceServerUrl + "/v1/friend/get-friend-data",
				new GetFriendDataParameter(username), FriendsData.class);
	}
}
