public class Dashatize {


    public static void main(String[] args) {


        System.out.println(dashatize(Integer.MIN_VALUE));

    }


    public static String dashatize(int num) {
        String number = String.valueOf(num);
        if (number.charAt(0) == '-') {
            number = number.substring(1, number.length());
        }

        StringBuilder numberWithDashes = new StringBuilder();
        for (int i = 0; i < number.length(); i++) {
            if (Character.getNumericValue(number.charAt(i)) % 2 != 0) {

                if (i != 0 && numberWithDashes.charAt(numberWithDashes.length() - 1) != '-') {
                    numberWithDashes.append("-");
                }
                numberWithDashes.append(number.charAt(i));
                if (i != number.length() - 1) {
                    numberWithDashes.append("-");
                }
            } else {
                numberWithDashes.append(number.charAt(i));
            }
        }
        return numberWithDashes.toString();
    }
}
