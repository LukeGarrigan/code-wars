public class Main {

    public static void main(String[] args) {


        String sentence = "Hello there";


        System.out.println(remove(sentence));
    }

    public static String remove(String str) {
        return str.substring(1, str.length()-1);
    }
}
