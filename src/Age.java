public class Age {


    public static void main(String[] args) {

        System.out.println(howOld("4 years old"));
    }


    public static int howOld(final String herOld) {

        return Integer.parseInt(String.valueOf(herOld.charAt(0)));

    }

}
