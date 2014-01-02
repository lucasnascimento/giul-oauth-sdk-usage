package br.com.pearson.giuloauthusage;

import org.junit.Test;

import br.com.pearson.oauth.basic.OAuthConsumer;
import br.com.pearson.oauth.basic.OAuthToken;
import br.com.pearson.oauth.basic.TokenType;
import br.com.pearson.oauth.request.APICall;
import br.com.pearson.oauth.request.AccessTokenCall;
import br.com.pearson.oauth.request.RequestTokenCall;

public class SdkUsageTest {

	private String token = "a96078c9-89f8-423a-9151-76cf71b68828";
	private String secret = "sRSDq8UdmAUrR6xw%2FU9ZpDwrj6jpt%2F%2F%2BGHlsiCbyQT3McXFaEWg8o2a3rLggvl5lb%2B4uj0OpXnur3T0dydhsO65fW7iUMnjfbkwmsfEZbzM%3D";

	@Test
	public void testGerarToken() throws Exception {
		
		String urlBase = "http://coc.dclick.com.br/giul/api";
		OAuthConsumer consumer = new OAuthConsumer("key", "secret");

		RequestTokenCall requestTokenCall = new RequestTokenCall(urlBase);
		OAuthToken requestToken = requestTokenCall.call(consumer);
		System.out.println(requestToken.getToken());

		// É necessário entrar no /api-explorer, e autorizar o requestToken

		AccessTokenCall accessTokenCall = new AccessTokenCall(urlBase);
		OAuthToken accessToken = accessTokenCall.call(consumer, requestToken);
		System.out.println(accessToken.getToken());
		System.out.println(accessToken.getSecret());
	}

	@Test
	public void testAPIME() throws Exception {

		String urlBase = "http://coc.dclick.com.br/giul/api";
		APICall apiCall = new APICall(urlBase);

		OAuthConsumer oAuthConsumer = new OAuthConsumer("key", "secret");
		OAuthToken accessToken = new OAuthToken(token, secret, TokenType.ACCESS);

		System.out.println(
				apiCall.get("/me", null, oAuthConsumer, accessToken));

		System.out.println(
				apiCall.get("/me/instituicoes", null, oAuthConsumer, accessToken));
		
	}

}
