package com.free.covi19.spain.api.util;

import java.util.HashSet;
import java.util.Set;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSession;

public enum WhitelistHostnameVerifier {

	// these hosts get whitelisted
    INSTANCE("localhost", "sub.domain.com");

    private Set whitelist = new HashSet<>();
    private HostnameVerifier defaultHostnameVerifier =
            HttpsURLConnection.getDefaultHostnameVerifier();

    WhitelistHostnameVerifier(String... hostnames) {
        for (String hostname : hostnames) {
            whitelist.add(hostname);
        }
    }

    public boolean verify(String host, SSLSession session) {
//        if (whitelist.contains(host)) {
//            return true;
//        }
//        // important: use default verifier for all other hosts
//        return defaultHostnameVerifier.verify(host, session);
    	
        return true;
        
    }
}
