public class DigitalRoot {


    public static void main(String[]args) {

        System.out.println(digital_root(132189));
    }


    public static int digitalRoot(int n) {
        String numberAsString = String.valueOf(n);

        if (numberAsString.length() == 1) {
            return n;
        }
        return Character.getNumericValue(numberAsString.charAt(0)) +
                digitalRoot(Integer.parseInt(numberAsString.substring(1, numberAsString.length())));
    }

    public static int digital_root(int n) {
        int number = digitalRoot(n);
        if (number > 10) {
            return digital_root(number);
        }
        return number;
    }




}
