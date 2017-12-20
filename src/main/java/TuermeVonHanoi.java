import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class TuermeVonHanoi {
    public static void main(String[] args) {
        List<Umlegung> schritte = new TuermeVonHanoi(Integer.parseInt(args[0]))
            .getSchritte();

        for (Umlegung schritt : schritte) {
            System.out.println(schritt);
        }
    }

    private List<Stack<Integer>> stapel = new ArrayList<>(3);
    private List<Umlegung> umlegungen;

    public TuermeVonHanoi(int anzahlRinge) {
        for (int i = 0; i < 3; i++) {
            stapel.add(new Stack<>());
        }

        Stack<Integer> stapel1 = stapel.get(0);
        for (int g = anzahlRinge; g > 0; g--) {
            stapel1.push(g);
        }

        umlegungen = new LinkedList<>();

        baueUm(anzahlRinge, 0, 2);
    }

    public List<Umlegung> getSchritte() {
        return umlegungen;
    }

    private void baueUm(int anzahl, int von, int nach) {
        if (anzahl == 1) {
            legeUm(von, nach);
        } else if (anzahl > 1) {
            int anderer = 3 - nach - von;

            baueUm(anzahl - 1, von, anderer);
            legeUm(von, nach);
            baueUm(anzahl - 1, anderer, nach);
        }
    }

    private void legeUm(int von, int nach) {
        if (!stapel.get(nach).isEmpty() && stapel.get(nach).top() < stapel.get(von).top()) {
            throw new IllegalArgumentException();
        }

        umlegungen.add(new Umlegung(von, nach));

        stapel.get(nach).push(stapel.get(von).pop());
    }

    public static class Umlegung {
        private int von;
        private int nach;

        protected Umlegung(int von, int nach) {
            this.von = von;
            this.nach = nach;
        }

        public int getVon() { return von; }
        public int getNach() { return nach; }

        @Override
        public String toString() {
            return "Umlegung: " + von + " -> " + nach;
        }

        @Override
        public boolean equals(Object o) {
            if (o instanceof Umlegung) {
                Umlegung umlegung = (Umlegung) o;
                return von == umlegung.von && nach == umlegung.nach;
            }
            return false;
        }
    }
}
