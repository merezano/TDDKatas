import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

public class SecretSantaTest {
	SecretSanta sut;

	@Before
	public void setUp() throws Exception {
		sut = new SecretSanta();
		sut.addParticipant("amy");
		sut.addParticipant("bob");
		sut.addParticipant("charlie");
	}

	@Test(expected = IllegalStateException.class)
	public void cannotAssignSantasWithAnEmptyListOfParticipants() {
		SecretSanta emptySanta = new SecretSanta();
		emptySanta.getSantas();
	}

	@Test(expected = IllegalStateException.class)
	public void twoParticipantsDontMakeASecretSanta() {
		SecretSanta sillySanta = new SecretSanta();
		sillySanta.addParticipant("amy");
		sillySanta.addParticipant("bob");
		sillySanta.getSantas();
	}

	@Test
	public void participantIsAddedToTheList() {
		sut.addParticipant("david");
		assertTrue(sut.getParticipants().contains("david"));
	}

	@Test
	public void aSecretSantaWithThreeParticipantsIsOK() {
		assertEquals(3, sut.getSantas().size());
	}

	@Test
	public void everyParticipantIsASanta() {
		sut.addParticipant("david");
		List<String> participants = sut.getParticipants();
		HashMap<String, String> santas = sut.getSantas();

		for (String participant : participants) {
			assertTrue(santas.containsKey(participant));
		}
	}

	@Test
	public void everyParticipantHasASanta() {
		List<String> participants = sut.getParticipants();
		HashMap<String, String> santas = sut.getSantas();

		for (String participant : participants) {
			assertTrue(santas.containsValue(participant));
		}
	}

	@Test
	public void noSelfSantas() {
		List<String> participants = sut.getParticipants();
		HashMap<String, String> santas = sut.getSantas();

		for (String participant : participants) {
			System.out.println(participant + " --> " + santas.get(participant));
			assertTrue((String) santas.get(participant) != participant);
		}
	}

	@Test(expected = IllegalStateException.class)
	public void participantsMustBeUnique() {
		sut.addParticipant("amy");
	}
}
