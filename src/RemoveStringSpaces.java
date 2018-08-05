public class RemoveStringSpaces {


    public static void main(String[] args) {

        System.out.println(noSpace("This has space"));

    }


    static String noSpace(String x) {
        return x.replaceAll("\\s+", "");
    }
}
