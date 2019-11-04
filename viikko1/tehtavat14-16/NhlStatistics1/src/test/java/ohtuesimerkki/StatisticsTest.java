package ohtuesimerkki;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class StatisticsTest {

    Reader readerStub = new Reader() {

        public List<Player> getPlayers() {
            ArrayList<Player> players = new ArrayList<>();

            players.add(new Player("Semenko", "EDM", 4, 12));
            players.add(new Player("Lemieux", "PIT", 45, 54));
            players.add(new Player("Kurri",   "EDM", 37, 53));
            players.add(new Player("Yzerman", "DET", 42, 56));
            players.add(new Player("Gretzky", "EDM", 35, 89));

            return players;
        }
    };

    Statistics stats;

    @Before
    public void setUp(){
        // luodaan Statistics-olio joka käyttää "stubia"
        stats = new Statistics(readerStub);
    }

    @Test
    public void getTeam() {
        List<Player> players = stats.team("EDM");
        List<Player> expectedPlayers = new ArrayList<Player>(
                Arrays.asList(
                        new Player("Semenko", "EDM", 4, 12),
                        new Player("Kurri",   "EDM", 37, 53),
                        new Player("Gretzky", "EDM", 35, 89)
                )
        );

        assertEquals(true, expectedPlayers.equals(players));
    }

    @Test
    public void getTopScorers() {
        List<Player> players = stats.topScorers(2);
        List<Player> expectedPlayers = new ArrayList<Player>(
            Arrays.asList(
                    new Player("Gretzky", "EDM", 35, 89),
                    new Player("Lemieux", "PIT", 45, 54),
                    new Player("Yzerman", "DET", 42, 56)
            )
        );

        assertEquals(true, expectedPlayers.equals(players));
    }

    @Test
    public void searchWithUnknownPlayer() {
        Player player = stats.search("ABCDEFG");
        assertEquals(null, player);
    }

    @Test
    public void searchRealPlayer() {
        Player player = stats.search("Kurri");
        Player expectedPlayer = new Player("Kurri",   "EDM", 37, 53);

        assertEquals(new Player("Kurri",   "EDM", 37, 53), player);
    }
}
