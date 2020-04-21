package cn.project.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.HttpClientUtils;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

public class HttpClientHelper {
	private HttpServletRequest request;
	private ObjectMapper objectMapper = new ObjectMapper();
	
	public HttpClientHelper(HttpServletRequest request) {
		this.request = request;
	}
	
	public Response get(String uri) {
		CloseableHttpClient  httpClient = HttpClientBuilder.create().build();
		CloseableHttpResponse  response = null;
		try {
			String ssoCookies = (String) request.getAttribute("ssoCookies");
			HttpGet httpGet = new HttpGet(uri);
			httpGet.addHeader("Cookie", ssoCookies);
			response = httpClient.execute(httpGet);
			HttpEntity httpEntity = response.getEntity();
			//授权过期,需要用户重新授权
			Header contentType = (Header) response.headerIterator("Content-Type").next();
			if(contentType.getValue().startsWith("text/html")) {//请求授权页面
				return new Response(ResponseEnum.ERROR).setResponseBody("调用目标的授权已经失效，请先重新获取授权<a href='"+uri+"'>授权</a>");
			}
			String result = null;
			if(httpEntity != null) {
				result = EntityUtils.toString(httpEntity);
				if(response.getStatusLine().getStatusCode() == 200) {
					System.out.println(result);
					return objectMapper.readValue(result,Response.class);
				}
			}
			System.out.println(result);
		} catch(Exception ex) {
			ex.printStackTrace();
		} finally {
			HttpClientUtils.closeQuietly(httpClient);
			HttpClientUtils.closeQuietly(response);
		}
		return new Response(ResponseEnum.ERROR).setResponseBody("出错了");
	}


}
