import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;

public class SecretSantaTest {
	private SecretSanta sut;

	@Before
	public final void setUp() throws Exception {
		sut = new SecretSanta();
		sut.addParticipant("Amy");
		sut.addParticipant("Bob");
		sut.addParticipant("Charlie");
	}

	@Test(expected = IllegalStateException.class)
	public final void cannotDrawWithNoParticipants() {
		SecretSanta emptySanta = new SecretSanta();
		emptySanta.draw();
	}

	@Test(expected = IllegalStateException.class)
	public final void requireAtLeastThreeParticipants() {
		SecretSanta sillySanta = new SecretSanta();
		sillySanta.addParticipant("Dumb");
		sillySanta.addParticipant("Dumber");
		sillySanta.draw();
	}

	@Test(expected = IllegalArgumentException.class)
	public final void requireUniqueParticipants() {
		sut.addParticipant("Amy");
	}

	@Test
	public final void participantIsAddedToTheList() {
		sut.addParticipant("david");
		assertTrue(sut.participants().contains("david"));
	}

	@Test
	public final void aSecretSantaWithThreeParticipantsIsOK() {
		sut.draw();
		assertEquals(sut.participants().size(), sut.pairs().size());
	}

	@Test
	public final void everyParticipantIsASanta() {
		sut.draw();
		final Set<String> santas = sut.pairs().keySet();
		assertTrue(santas.containsAll(sut.participants()));
	}

	@Test
	public final void everyParticipantHasASanta() {
		sut.draw();
		final Collection<String> receivers = sut.pairs().values();
		assertTrue(receivers.containsAll(sut.participants()));
	}

	@Test
	public final void ensureNoSelfSantas() {
		for (Entry<String, String> pair : sut.pairs().entrySet()) {
			assertTrue(pair.getKey() != pair.getValue());
		}
	}
}
