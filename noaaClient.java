package noaaTideInfo;

import java.net.MalformedURLException;
import java.net.URL;

import javax.xml.soap.*;

public class noaaClient {
	public static void main(String[] args) {
		try {
			openSendMsgClose();
			
						
			
		} 
		catch (UnsupportedOperationException uoe)  {
			
		}
		catch (SOAPException se) {
			
		}
		catch (MalformedURLException mue) {
			
		}
		
	}
	
	private static void openSendMsgClose() throws UnsupportedOperationException, SOAPException, MalformedURLException {
		SOAPConnectionFactory mySoapConnFactory = SOAPConnectionFactory.newInstance();
		SOAPConnection mySoapConn = mySoapConnFactory.createConnection();
		SOAPFactory mySoapFactory = SOAPFactory.newInstance();
		SOAPMessage myMessage = SoapMsg.prepareMessage();
		
		URL myConnPoint = new URL("https://opendap.co-ops.nos.noaa.gov/axis/services/highlowtidepred");
		SOAPMessage myResponseObj = mySoapConn.call(myMessage, mySoapConn);
		mySoapConn.close();
	}
}
