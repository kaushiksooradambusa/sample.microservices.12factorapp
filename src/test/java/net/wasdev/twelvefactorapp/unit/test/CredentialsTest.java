package net.wasdev.twelvefactorapp.unit.test;

import org.junit.Assert;
import org.junit.Test;

import net.wasdev.twelvefactorapp.CloudantCredentials;

/**
 * This tests that sending GET, PUT and POST requests to the JaxrsHttpReceiver class
 * don't return exceptions.
 */

public class CredentialsTest {

	@Test
	public void testStandardParameters() throws Exception {
			CloudantCredentials cc = new CloudantCredentials("dbUser", "dbPassword", "cloudant://dbUrl", "VCAP_SERVICES");
			Assert.assertEquals("The username should be dbUser", "dbUser", cc.getUsername());
			Assert.assertEquals("The password should be dbPassword", "dbPassword", cc.getPassword());
			Assert.assertEquals("The url should be cloudant://dbUrl", "cloudant://dbUrl", cc.getUrl());
	}
	
	
	@Test
	public void testVcapParameters() throws Exception {
		StringBuilder vcapServices = new StringBuilder("{\"cloudantNoSQLDB\": [{");
		vcapServices.append("\"name\": \"CloudantDBFor12Factor\",");
		vcapServices.append("\"label\": \"cloudantNoSQLDB\",");
		vcapServices.append("\"plan\": \"Shared\",");
		vcapServices.append("\"credentials\": {");
		vcapServices.append("\"username\": \"vcapUser\",");
		vcapServices.append("\"password\": \"vcapPasswd\",");
		vcapServices.append("\"host\": \"vcapHostname\",     ");
		vcapServices.append("\"port\": 443,         ");
		vcapServices.append("\"url\": \"https://vcapCloudant\"     ");
		vcapServices.append("}}]}");
			CloudantCredentials cc = new CloudantCredentials(null, null, null, vcapServices.toString());
			Assert.assertEquals("The username should be vcapUser", "vcapUser", cc.getUsername());
			Assert.assertEquals("The password should be vcapPasswd", "vcapPasswd", cc.getPassword());
			Assert.assertEquals("The url should be https://vcapCloudant", "https://vcapCloudant", cc.getUrl());
	}
}
