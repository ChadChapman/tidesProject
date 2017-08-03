package noaaTideInfo;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import javax.xml.soap.*;

public class noaaClient {
	
	public static SOAPMessage myResponseObj;
	private static String myOutputFileName;
	
	public static void main(String[] args) {
		try {
			//TODO will need to parse CL args
			final String clArg1 = args[1]; //message type eg tides
			openSendMsgClose(clArg1); //tides
			
			final String clArg2 = args[2]; //file extension type eg txt, csv
			final String clArg3 = args[3]; //how much info to write to output file eg response, all
			myOutputFileName = buildOutputFileName(clArg1, clArg2, clArg3);
			outputInfoAsFile(clArg1, "txt", "response");
						
			
		} 
		catch (UnsupportedOperationException uoe)  {
			
		}
		catch (SOAPException se) {
			
		}
		catch (MalformedURLException mue) {
			
		}
				
	}
	
	private static void openSendMsgClose(final String theMsgType) throws UnsupportedOperationException, 
	SOAPException, MalformedURLException {
		SOAPConnectionFactory mySoapConnFactory = SOAPConnectionFactory.newInstance();
		SOAPConnection mySoapConn = mySoapConnFactory.createConnection();
		SOAPFactory mySoapFactory = SOAPFactory.newInstance();
		//under here need to specify which message type
		SOAPMessage myMessage = SoapMsg.prepareMessage();
		
		URL myConnPoint = new URL("https://opendap.co-ops.nos.noaa.gov/axis/services/highlowtidepred");
		myResponseObj = mySoapConn.call(myMessage, mySoapConn);
		mySoapConn.close();
	}
	
	private static String buildOutputFileName(final String theMsgType, final String theFileType, 
			final String theDataToWrite) {
		final char spacer = '_';
		final StringBuilder sb = new StringBuilder();
		sb.append("noaaResponseMsg_");
		sb.append(theMsgType);
		sb.append(spacer);
		sb.append(theDataToWrite);
		sb.append('.');
		sb.append(theFileType);
		
		return sb.toString();
	}
	
	private static void outputInfoAsFile(final String theMsgType, final String theFileType, 
			final String theDataToWrite) {
		
		//TODO conditional to select which info to output
		final int outputChoice = selectOutputVolume(theDataToWrite);
		FileOutputStream fileOutStream;
		try {
			fileOutStream = new FileOutputStream(myOutputFileName);
			myResponseObj.writeTo(fileOutStream);
			fileOutStream.close();
		} catch (FileNotFoundException fnfe) {
			fnfe.printStackTrace();
		}
		catch (SOAPException | IOException e) {
			e.printStackTrace();
		}
	}
	
	private static int selectOutputVolume(final String theDataToWrite) {
		int retInt = 0;
		
		return retInt;
	}
}
