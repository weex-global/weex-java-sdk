package com.weex.openapi;

import com.weex.openapi.common.client.WeexRestClient;
import org.junit.After;
import org.junit.Before;

import com.weex.openapi.common.domain.ClientParameter;
import com.weex.openapi.common.enums.SupportedLocaleEnum;

/**
 * @author weex-sdk-team
 * @date 2019-01-15
 */
public class BaseTest {
	
	/**
	 * 用户 apiKey 替换成自己的
	 */
	private final String apiKey = "weex_015b7fa0ce4da88fb8151494a061b327";
	/**
	 * 用户 secretKey 替换成自己的
	 */
	private final String secretKey = "235cd58a3443cf8e36bcc1c95a235cc825f559b9bd63314dc19e85b8fd1be49b";
	/**
	 * 口令 替换成自己的
	 */
	private final String passphrase = "a1234567";
	/**
	 * weex open api 根路径
	 */
    private final String baseUrl = "https://gateway.weextest.com";

	private final ClientParameter parameter = ClientParameter.builder().apiKey(apiKey).secretKey(secretKey).passphrase(passphrase).baseUrl(baseUrl)
			.locale(SupportedLocaleEnum.ZH_CN.getName()).build();
	public WeexRestClient weexRestClient;
	
	@Before
	public void setup() {
		weexRestClient = WeexRestClient.builder().configuration(parameter).build();
	}
	
	@After
	public void tearDown() {
		
	}
}
