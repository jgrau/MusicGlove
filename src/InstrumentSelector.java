/*
 * Copyright 2007 Phidgets Inc.  All rights reserved.
 */

import java.util.ArrayList;

import com.phidgets.*;
import com.phidgets.event.*;

public class InstrumentSelector {
	private ArrayList<String> instruments;
	private String instrument;

	public InstrumentSelector() throws Exception {	
		instruments = new ArrayList<String>();
		instruments.add("0107ee5fcf"); instruments.add("0106933e94"); instruments.add("0107ee5fcf");
		
		RFIDPhidget rfid1;
		//		TagListener tl = new TagListener();
		//		System.out.println("instatiating");
		rfid1 = new RFIDPhidget();
		System.out.println("adding listneners");
		rfid1.addAttachListener(new AttachListener() {
			public void attached(AttachEvent ae) {
				try {
					((RFIDPhidget) ae.getSource()).setAntennaOn(true);
					((RFIDPhidget) ae.getSource()).setLEDOn(false);
				} catch (PhidgetException ex) {
				}
				System.out.println("attachment of " + ae);
			}
		});

		rfid1.addTagGainListener(new TagListener() {
			public void tagGained(TagGainEvent tge) {
				instrument = tge.getValue();
				//				System.out.println("I am now a: " + instrument);
			}
		});
		rfid1.addTagLossListener(new TagListener() {
			public void tagLost(TagLossEvent tle) {
				System.out.println("Tag lost. Before it was: " + instrument);
			}
		});
		rfid1.addOutputChangeListener(new OutputChangeListener() { 
			public void outputChanged(OutputChangeEvent oe) { 
				System.out.println(oe); 
			} 
		});


		System.out.println("opening");
		rfid1.openAny();
		//rfid2.open(56149);
		System.out.println("waiting for RFID attachment...");
		rfid1.waitForAttachment(1000);
		//rfid2.waitForAttachment(1000);
		System.out.println("waiting done");

		// System.out.println("Serial: " + rfid.getSerialNumber());
		// System.out.println("Outputs: " + rfid.getOutputCount());
		//
		// System.out.println("Outputting events.  Input to stop.");
		System.in.read();
		System.out.print("closing...");
		rfid1.close();
	}


	public static final void main(String args[]) throws Exception {
		new InstrumentSelector();
	}

	public int getInstrument() {
//		for (int i = 0; i < instruments.length; i++) { 
//			if(instruments[i].equals(instrument)) {
//				return i;
//			}
//		}
//		return 0;
		return instruments.indexOf(instrument);
	}
}