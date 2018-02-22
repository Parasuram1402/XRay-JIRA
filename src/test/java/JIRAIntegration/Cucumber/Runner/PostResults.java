package JIRAIntegration.Cucumber.Runner;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import org.apache.commons.io.FileUtils;

public class PostResults {

	public static void main(String args[]){
		System.out.println("Hello");
		String sUserPassword, sBasicAuth;
		try {
				TrustManager[] trustAllCerts = new TrustManager[] { new X509TrustManager() {

					@Override
					public void checkClientTrusted(X509Certificate[] chain, String authType)
							throws CertificateException {
						// TODO Auto-generated method stub
						
					}

					@Override
					public void checkServerTrusted(X509Certificate[] chain, String authType)
							throws CertificateException {
						// TODO Auto-generated method stub
						
					}

					@Override
					public X509Certificate[] getAcceptedIssuers() {
						// TODO Auto-generated method stub
						return null;
					}

				} };
				SSLContext sc = SSLContext.getInstance("SSL");
				sc.init(null, trustAllCerts, new java.security.SecureRandom());
				HttpsURLConnection.setDefaultSSLSocketFactory(sc.getSocketFactory());
				HostnameVerifier allHostsValid = new HostnameVerifier() {
					public boolean verify(String hostname, SSLSession session) {
						return true;
					}
				};
				HttpsURLConnection.setDefaultHostnameVerifier(allHostsValid);
				URL url = new URL("http://localhost:6060/rest/raven/1.0/import/execution/cucumber");
				HttpURLConnection conn= (HttpURLConnection) url.openConnection();
				//String report_json="";
				   String report_json = FileUtils.readFileToString(new File("F:\\Selenium_Workspace\\Cucumber\\report.json"));
				   System.out.println(report_json);
				
				
				sUserPassword="parasuram:y1cs226";
				sBasicAuth = "Basic " + javax.xml.bind.DatatypeConverter.printBase64Binary(sUserPassword.getBytes());
				conn.setRequestProperty("Authorization", sBasicAuth);
				conn.setRequestMethod("POST");
				conn.setRequestProperty("Accept", "application/json");
				conn.setRequestProperty("Content-Type", "application/json");
				conn.setDoInput(true);
				conn.setDoOutput(true);
		        OutputStream os = conn.getOutputStream();
		        os.write(report_json.getBytes("UTF-8"));
				os.close();
				if (conn.getResponseCode() != 200) {
					throw new RuntimeException("Failed : HTTP error code : "
							+ conn.getResponseCode());
				}
				BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));

				String output;
				System.out.println("Output from Server .... \n");
				while ((output = br.readLine()) != null) {
					System.out.println(output);
				}
				
				conn.disconnect();				
				

		} catch(Exception e) {
			
		}
	}
}
