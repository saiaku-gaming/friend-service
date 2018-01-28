package com.valhallagame.friendserviceclient;

import java.io.IOException;

import com.valhallagame.common.DefaultServicePortMappings;
import com.valhallagame.common.RestCaller;
import com.valhallagame.common.RestResponse;
import com.valhallagame.friendserviceclient.message.AcceptCharacterInviteParameter;
import com.valhallagame.friendserviceclient.message.DeclineCharacterParameter;
import com.valhallagame.friendserviceclient.message.GetFriendDataParameter;
import com.valhallagame.friendserviceclient.message.RemoveCharacterFriendParameter;
import com.valhallagame.friendserviceclient.message.SendCharacterInviteParameter;
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


	public RestResponse<String> sendCharacterInvite(String username, String receiverCharacterName) throws IOException {
		return restCaller.postCall(friendServiceServerUrl + "/v1/friend/send-character-invite",
				new SendCharacterInviteParameter(username, receiverCharacterName), String.class);
	}

	public RestResponse<String> acceptCharacterInvite(String username, String accpeteeCharacterName) throws IOException {
		return restCaller.postCall(friendServiceServerUrl + "/v1/friend/accept-character-invite",
				new AcceptCharacterInviteParameter(username, accpeteeCharacterName), String.class);
	}

	public RestResponse<String> declineCharacterInvite(String username, String declineeCharacterName) throws IOException {
		return restCaller.postCall(friendServiceServerUrl + "/v1/friend/decline-character-invite",
				new DeclineCharacterParameter(username, declineeCharacterName), String.class);
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
