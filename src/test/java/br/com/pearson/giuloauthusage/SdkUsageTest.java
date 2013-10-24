package br.com.pearson.giuloauthusage;

import org.junit.Test;

import br.com.pearson.oauth.basic.OAuthConsumer;
import br.com.pearson.oauth.basic.OAuthToken;
import br.com.pearson.oauth.request.LoginCall;
import br.com.pearson.oauth.request.RequestTokenCall;

public class SdkUsageTest {

	@Test
	public void testDoLogin() {
		String urlBase = "http://office-sp.dclick.com.br/giul/api";
		LoginCall call = new LoginCall(urlBase);
		String result = call.doLogin("bruno.sales", "admin", "coc");
		System.out.println(result);
	}
	

	@Test
	public void testRequestToken() throws Exception {
		String urlBase = "http://office-sp.dclick.com.br/giul/api";
		RequestTokenCall call = new RequestTokenCall(urlBase);
		OAuthToken result = call.call(new OAuthConsumer("consumerKey", "consumerSecret"));
		System.out.println(result);
	}


}
