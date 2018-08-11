public class BumpsInTheRoad {

    public static void main(String[] args) {

    }

    public static String bumps(final String road) {
        return road.chars().filter(value -> value == 'n').count() > 15 ? "Car Dead": "Woohoo!";

    }
}
