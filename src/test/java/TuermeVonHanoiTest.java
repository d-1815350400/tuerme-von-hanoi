import org.junit.Test;
import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;

public class TuermeVonHanoiTest {
    @Test
    public void testKeineRinge() {
        TuermeVonHanoi tuerme = new TuermeVonHanoi(0);
        List<TuermeVonHanoi.Umlegung> schritte = tuerme.getSchritte();

        assertTrue(schritte.isEmpty());
    }

    @Test
    public void testEinRing() {
        TuermeVonHanoi tuerme = new TuermeVonHanoi(1);
        List<TuermeVonHanoi.Umlegung> schritte = tuerme.getSchritte();

        assertEquals(schritte, Arrays.asList(
            new TuermeVonHanoi.Umlegung(0, 2)));
    }

    @Test
    public void testZweiRinge() {
        TuermeVonHanoi tuerme = new TuermeVonHanoi(2);
        List<TuermeVonHanoi.Umlegung> schritte = tuerme.getSchritte();

        assertEquals(schritte, Arrays.asList(
            new TuermeVonHanoi.Umlegung(0, 1),
            new TuermeVonHanoi.Umlegung(0, 2),
            new TuermeVonHanoi.Umlegung(1, 2)));
    }

    @Test
    public void testDreiRinge() {
        TuermeVonHanoi tuerme = new TuermeVonHanoi(3);
        List<TuermeVonHanoi.Umlegung> schritte = tuerme.getSchritte();

        assertEquals(schritte, Arrays.asList(
            new TuermeVonHanoi.Umlegung(0, 2),
            new TuermeVonHanoi.Umlegung(0, 1),
            new TuermeVonHanoi.Umlegung(2, 1),
            new TuermeVonHanoi.Umlegung(0, 2),
            new TuermeVonHanoi.Umlegung(1, 0),
            new TuermeVonHanoi.Umlegung(1, 2),
            new TuermeVonHanoi.Umlegung(0, 2)));
    }
}
