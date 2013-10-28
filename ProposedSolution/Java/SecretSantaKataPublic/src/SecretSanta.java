import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class SecretSanta {
	private List<String> participants;

	public HashMap<String, String> getSantas() {
		if (participants.size() < 3)
			throw new IllegalStateException();

		shuffleParticipants();
		return autoAssignment();
	}

	private HashMap<String, String> autoAssignment() {
		HashMap<String, String> santas = new HashMap<String, String>();

		int i = 0;
		for (String participant : participants) {
			santas.put(participant, participants.get(++i % participants.size()));
		}

		return santas;
	}

	private void shuffleParticipants() {
		Collections.shuffle(participants);
	}

	public SecretSanta() {
		participants = new ArrayList<String>();
	}

	public List<String> getParticipants() {
		return participants;
	}

	public void addParticipant(String newParticipant) {
		if (participants.contains(newParticipant))
			throw new IllegalStateException();

		participants.add(newParticipant);
	}

}
