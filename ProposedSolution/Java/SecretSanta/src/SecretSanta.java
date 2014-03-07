import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SecretSanta {
	private static final int MINIMUM_NUMBER_OF_PARTICIPANTS = 3;
	private List<String> participants;
	private Map<String, String> pairs;

	public SecretSanta() {
		participants = new ArrayList<String>();
		pairs = new HashMap<String, String>();
	}

	public final void addParticipant(final String newParticipant) {
		if (participants.contains(newParticipant)) {
			throw new IllegalArgumentException("Participant already exists.");
		}

		participants.add(newParticipant);
	}

	/**
	 * TODO: This method could it be a good candidate for Strategy pattern
	 */
	public void draw() {
		if (participants.size() < MINIMUM_NUMBER_OF_PARTICIPANTS) {
			throw new IllegalStateException("Not enough participants.");
		}

		Collections.shuffle(participants);

		int i = 0;
		for (String giver : participants) {
			final String receiver = participants.get(++i % participants.size());
			pairs.put(giver, receiver);
		}
	}

	public final Map<String, String> pairs() {
		return pairs;
	}

	public final List<String> participants() {
		return participants;
	}
}
