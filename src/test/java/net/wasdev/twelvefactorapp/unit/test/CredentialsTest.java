package net.wasdev.twelvefactorapp.unit.test;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

import net.wasdev.twelvefactorapp.storage.cloudant.CloudantCredentials;


public class CredentialsTest {

    @Test
    @Ignore
    public void testStandardParameters() throws Exception {
        CloudantCredentials cc = new CloudantCredentials("dbUser", "dbPassword", "http://dbUrl:9080");
        Assert.assertEquals("The username should be dbUser", "dbUser", cc.getUsername());
        Assert.assertEquals("The password should be dbPassword", "dbPassword", cc.getPassword());
        Assert.assertEquals("The url should be http://dbUrl:9080", "http://dbUrl:9080", cc.getUrl());
    }

}
