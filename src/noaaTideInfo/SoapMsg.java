package noaaTideInfo;

import javax.xml.soap.MessageFactory;
import javax.xml.soap.Name;
import javax.xml.soap.SOAPBody;
import javax.xml.soap.SOAPBodyElement;
import javax.xml.soap.SOAPElement;
import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPFactory;
import javax.xml.soap.SOAPHeader;
import javax.xml.soap.SOAPMessage;

public abstract class SoapMsg {
	
	
	protected static SOAPMessage prepareNOAATidesHLMsg() {
		SOAPMessage retMsg = null;
		try {
			SOAPFactory spFactory = SOAPFactory.newInstance();
			MessageFactory msgFactory = MessageFactory.newInstance();
			retMsg = msgFactory.createMessage();
			
			SOAPHeader spHeader = retMsg.getSOAPHeader();
			SOAPBody spBody = retMsg.getSOAPBody();
			spHeader.detachNode();
			retMsg.getMimeHeaders().addHeader("SOAPAction", "");
			
			Name bodyName = spFactory.createName("getHLPredAndMetadata", "hilo",
					"https://opendap.co-ops.nos.noaa.gov/axis/webservices/highlowtidepred/wsdl");
			SOAPBodyElement bodyElem = spBody.addBodyElement(bodyName);
			
			constructRequestBodyNOAATidesHL(spFactory, bodyElem);
		}
		catch (SOAPException se) {
			System.err.println("Error in preparing SOAP Message");
			System.err.println(se.toString());
			se.printStackTrace();
		}
		return retMsg;
	}
	
	private static void constructRequestBodyNOAATidesHL(final SOAPFactory theSOAPFactory, 
														final SOAPBodyElement theBodyElement) {
		try {
		Name elemName = theSOAPFactory.createName("stationId");
		SOAPElement elemSymbol = theBodyElement.addChildElement(elemName);
		elemSymbol.addTextNode("8454000");
		elemName = theSOAPFactory.createName("beginDate");
		elemSymbol = theBodyElement.addChildElement(elemName);
		elemSymbol.addTextNode("20170901 00:00");
		elemName = theSOAPFactory.createName("endDate");
		elemSymbol = theBodyElement.addChildElement(elemName);
		elemSymbol.addTextNode("20170930 23:59");
		elemName = theSOAPFactory.createName("datum");
		elemSymbol = theBodyElement.addChildElement(elemName);
		elemSymbol.addTextNode("MLLW");
		elemName = theSOAPFactory.createName("unit");
		elemSymbol = theBodyElement.addChildElement(elemName);
		elemSymbol.addTextNode("0");
		elemName = theSOAPFactory.createName("timeZone");
		elemSymbol = theBodyElement.addChildElement(elemName);
		elemSymbol.addTextNode("0");
				
		}
		catch (SOAPException se) {
			System.err.println("Error in preparing SOAP Message");
			System.err.println(se.toString());
			se.printStackTrace();
		}
	}
}
