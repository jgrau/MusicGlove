import com.phidgets.event.TagGainEvent;
import com.phidgets.event.TagGainListener;
import com.phidgets.event.TagLossEvent;
import com.phidgets.event.TagLossListener;

public class TagListener implements TagGainListener, TagLossListener {

	public void tagGained(TagGainEvent tge) {
		System.out.println(tge);
		System.out.println("My name is: " + tge.getValue());
		InstrumentSelector.setInstrument(tge.getValue());
	}

	public void tagLost(TagLossEvent tle) {
		System.out.println(tle);
	}

}
