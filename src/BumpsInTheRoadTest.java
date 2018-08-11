import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BumpsInTheRoadTest {


    @Test
    public void basicTest() {
        assertEquals(BumpsInTheRoad.bumps("n"), "Woohoo!");
        assertEquals(BumpsInTheRoad.bumps("_nnnnnnn_n__n______nn__nn_nnn"), "Car Dead");
        assertEquals(BumpsInTheRoad.bumps("______n___n_"), "Woohoo!");
        assertEquals(BumpsInTheRoad.bumps("nnnnnnnnnnnnnnnnnnnnn"), "Car Dead");
    }


    @Test
    public void bumps() {
    }
}
