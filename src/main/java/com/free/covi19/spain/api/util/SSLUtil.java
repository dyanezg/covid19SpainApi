package com.free.covi19.spain.api.util;

import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import javax.security.cert.X509Certificate;

//https://stackoverflow.com/questions/23504819/how-to-disable-ssl-certificate-checking-with-spring-resttemplate
public class SSLUtil {

	 private static final TrustManager[] UNQUESTIONING_TRUST_MANAGER = new TrustManager[]{
	            new X509TrustManager() {
	                public java.security.cert.X509Certificate[] getAcceptedIssuers(){
	                    return null;
	                }
	                public void checkClientTrusted( X509Certificate[] certs, String authType ){}
	                public void checkServerTrusted( X509Certificate[] certs, String authType ){}
					@Override
					public void checkClientTrusted(java.security.cert.X509Certificate[] arg0, String arg1)
							throws CertificateException {
						// TODO Auto-generated method stub
						
					}
					@Override
					public void checkServerTrusted(java.security.cert.X509Certificate[] arg0, String arg1)
							throws CertificateException {
						// TODO Auto-generated method stub
						
					}
	            }
	        };

	    public  static void turnOffSslChecking() throws NoSuchAlgorithmException, KeyManagementException {
	        // Install the all-trusting trust manager
	        final SSLContext sc = SSLContext.getInstance("SSL");
	        sc.init( null, UNQUESTIONING_TRUST_MANAGER, null );
	        HttpsURLConnection.setDefaultSSLSocketFactory(sc.getSocketFactory());
	    }

	    //TODO Revisar para activar
	    public static void turnOnSslChecking() throws KeyManagementException, NoSuchAlgorithmException {
	        // Return it to the initial state (discovered by reflection, now hardcoded)
	        SSLContext.getInstance("SSL").init( null, null, null );
	    }

	    private SSLUtil(){
	        throw new UnsupportedOperationException( "Do not instantiate libraries.");
	    }
	
}
