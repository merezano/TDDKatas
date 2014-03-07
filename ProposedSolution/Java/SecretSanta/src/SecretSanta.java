import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class SecretSanta {
	private List<String> participants;

	public SecretSanta() {
		participants = new ArrayList<String>();
	}

	public void addParticipant(String newParticipant) {
		if (participants.contains(newParticipant))
			throw new IllegalStateException();

		participants.add(newParticipant);
	}

	private Map<String, String> autoAssignment() {
		HashMap<String, String> santas = new HashMap<String, String>();

		int i = 0;
		for (String participant : participants) {
			santas.put(participant, participants.get(++i % participants.size()));
		}

		return santas;
	}

	public List<String> getParticipants() {
		return participants;
	}

	public Map<String, String> getSantas() {
		if (participants.size() < 3)
			throw new IllegalStateException();

		shuffleParticipants();
		return autoAssignment();
	}

	private void shuffleParticipants() {
		Collections.shuffle(participants);
	}

}
