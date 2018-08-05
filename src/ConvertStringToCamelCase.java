public class ConvertStringToCamelCase {

    public static void main(String[] args) {


        System.out.println(toCamelCase("the-stealth-warrior"));

    }

    public static String toCamelCase(String s){

        StringBuilder camelCasedString = new StringBuilder();
        boolean nextIsCapital = false;
        for (int i = 0; i < s.length(); i++) {

            if(Character.isAlphabetic(s.charAt(i))) {
                if(nextIsCapital) {
                    camelCasedString.append(Character.toUpperCase(s.charAt(i)));
                    nextIsCapital = false;
                }else {
                    camelCasedString.append(s.charAt(i));
                }

            } else {
                nextIsCapital = true;
            }
        }
        return camelCasedString.toString();
    }
}
