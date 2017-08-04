package noaaTideInfo;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Iterator;

import javax.xml.soap.*;

public class noaaClient {
	
	public static SOAPMessage myResponseObj;
	private static String myOutputFileName;
	private static SOAPMessage mySentMsg;
	private static SOAPFactory mySoapFactory;
	
	public static void main(String[] args) {
		try {
			//TODO will need to parse CL args
			//Create separate class for writing / storing data
			final String clArg1 = args[1]; //message type eg tides
			openSendMsgClose(clArg1); //tides
			//TODO need to get args for request submission also
			final String clArg2 = args[2]; //file extension type eg txt, csv
			final String clArg3 = args[3]; //how much info to write to output file eg response, all
			myOutputFileName = buildOutputFileName(clArg1, clArg2, clArg3);
			iterateThroughResponseBody();
			outputInfoAsFile(clArg1, "txt", "response");
			outputInfoToSystem(clArg1, clArg3); //display message in console
			
			
						
			
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
		mySoapFactory = SOAPFactory.newInstance();
		//under here need to specify which message type
		mySentMsg = SoapMsg.prepareNOAATidesHLMsg();
		
		URL myConnPoint = new URL("https://opendap.co-ops.nos.noaa.gov/axis/services/highlowtidepred");
		//TODO need to init mySentMsg here, not later
		myResponseObj = mySoapConn.call(mySentMsg, mySoapConn);
		mySoapConn.close();
	}
	
	private static void iterateThroughResponseBody() {
		//TODO this method def just for tide HL info
		System.out.println("\nChecking response message for faults: ");
		try {
		StringBuilder sb = new StringBuilder();	
		SOAPBody responseBody = myResponseObj.getSOAPBody();
		if (responseBody.hasFault()) {
			SOAPFault responseFault = responseBody.getFault();
			final String faultActor = responseFault.getFaultActor();
			sb.append("\nFault in RESPONSE BODY, contains fault code:\n");
			sb.append(responseFault.getFaultCodeAsName().getQualifiedName());
			sb.append("\nFault string:\n");
			sb.append(responseFault.getFaultString());
			if (faultActor != null) {
				sb.append("\nFault actor:\n");
				sb.append(faultActor);
			}
			System.out.println(sb.toString());
		} else {
			System.out.println("\nNo response faults, iterating through message: ");
			Iterator iter1 = responseBody.getChildElements();
			Iterator iter2, iter3, iter4 = null;
			String tagName = null;
			Name attributeName = null;
			SOAPElement spElem = null;
			//TODO this whole iteration process is clunky and hardcoded and def needs a refactor
			if(iter1.hasNext()) {
				spElem = (SOAPElement) iter1.next();
				iter1 = spElem.getChildElements();
				while (iter1.hasNext()) {
					spElem = (SOAPElement) iter1.next();
					//TODO this is where to switch type of metadata written, eg all, none, highlights
					writeAllElementMetadata(spElem);
					tagName = spElem.getElementName().getLocalName();
					if ("HighLowValues".equals(tagName)) {
						iter2 = spElem.getChildElements();
						while(iter2.hasNext()) {
							spElem = (SOAPElement) iter2.next();
							attributeName = mySoapFactory.createName("date");
							System.out.println("--------------------------------");
							System.out.println(spElem.getAttributeValue(attributeName));
							System.out.println("--------------------------------");
							iter3 = spElem.getChildElements();
							while(iter3.hasNext()){
								spElem = (SOAPElement) iter3.next();
								iter4 = spElem.getChildElements();
								while(iter4.hasNext()) {
									spElem = (SOAPElement) iter4.next();
									writeDataToSystem(spElem);
									//TODO choose between these two? yes
									writeDataToDataStructure(spElem);
								}
							}
							
						}
					}
				}
			}
		}
		
		
		
		}
		catch (SOAPException se) {
			se.printStackTrace();
		}
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
		if (theDataToWrite.equalsIgnoreCase("all")) {
			//return message as written, more human readable
			retInt = 0;
		} else if (theDataToWrite.equalsIgnoreCase("response")) {
			//return data structures of returned info, for further parsing
			retInt = 1;
		} else {
			//return data highlights , eg bare min. info but still readable
			retInt = 2;
		}
		return retInt;
	}

	private static void outputInfoToSystem(final String theMsgType, final String theDataToWrite) {
		System.out.print("\nMessage being sent reads as follows:\n");
		try {
			mySentMsg.writeTo(System.out);
		} catch (SOAPException | IOException e) {
			System.out.print("error in writing the SOAP REQUEST message to System.out");
			//e.printStackTrace();
		}
		System.out.println("\n\n");
	}
	
	private static void writeAllElementMetadata(final SOAPElement theSpElem) {
		//TODO include metadata tags to be written in "all" mode
	}
	
	private static void writeHighlightsElementMetadata(final SOAPElement theSpelem) {
		//TODO include "highlight" condensed metadata 
	}
	
	private static void writeDataToSystem(final SOAPElement se) {
		//TODO write returned data out to system.out or .err, dupe method?
	}
	
	private static void writeDataToDataStructure(final SOAPElement se) {
		//TODO write returned data to data struct - list for now?
	}

}


