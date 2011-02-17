import com.phidgets.event.TagGainEvent;
import com.phidgets.event.TagGainListener;
import com.phidgets.event.TagLossEvent;
import com.phidgets.event.TagLossListener;

public class TagListener implements TagGainListener, TagLossListener {

	public void tagGained(TagGainEvent tge) {
		System.out.println(tge);
	}

	public void tagLost(TagLossEvent tle) {
		System.out.println(tle);
	}

}