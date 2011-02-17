import com.phidgets.*;
import com.phidgets.event.*;

public class InstrumentSelector {
//	private String[] instrument = {"guitar", "drums"};
	public InstrumentSelector() {
		System.out.println("instatiating");
	}
	
	public static void main(String args[]) throws Exception {
		RFIDPhidget rfid1;//, rfid2;
		TagListener tl = new TagListener();

		// System.out.println(Phidget.getLibraryVersion());

		System.out.println("instatiating");
		rfid1 = new RFIDPhidget();
		//rfid2 = new RFIDPhidget();

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

		/*
		rfid2.addAttachListener(new AttachListener() {
			public void attached(AttachEvent ae) {
				try {
					((RFIDPhidget) ae.getSource()).setAntennaOn(true);
					((RFIDPhidget) ae.getSource()).setLEDOn(true);
				} catch (PhidgetException ex) {
				}
				System.out.println("attachment of " + ae);
			}
		});
		*/

		/*
		 * rfid.addDetachListener(new DetachListener() { public void
		 * detached(DetachEvent ae) { System.out.println("detachment of " + ae);
		 * } }); rfid.addErrorListener(new ErrorListener() { public void
		 * error(ErrorEvent ee) { System.out.println("error event for " + ee); }
		 * });
		 */

		rfid1.addTagGainListener(tl);
		rfid1.addTagLossListener(tl);
		//rfid2.addTagGainListener(tl);
		//rfid2.addTagLossListener(tl);

		
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
		//rfid2.close();
		// rfid = null;
		// System.out.println(" ok");
		// if (false) {
		// System.out.println("wait for finalization...");
		// System.gc();
		// }
	}
}
