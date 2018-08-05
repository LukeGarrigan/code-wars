public class FatFingers {

    public static void main(String[] args) {

        System.out.println(fatFingersTwo("aaaaaaAAAA"));


    }

    public static String fatFingersTwo(String str) {

        if(str == null ) return null;
        if(str == "") return "";
        StringBuilder fatFingeredString = new StringBuilder();
        boolean isCapSet = false;
        if(str.charAt(0) != 'a' && str.charAt(0) != 'a') fatFingeredString.append(str.charAt(0));
        for (int i = 1; i < str.length(); i++) {
            char currentCharacter = str.charAt(i);
            if(currentCharacter == 'a'){
                isCapSet = !isCapSet;
            }
            if(isCapSet && currentCharacter != 'a' && currentCharacter != 'A') {
                fatFingeredString.append(Character.toUpperCase(currentCharacter));
            } else if (!isCapSet && currentCharacter != 'a' && currentCharacter != 'A' ){
                fatFingeredString.append(Character.toLowerCase(currentCharacter));
            }
        }
        return fatFingeredString.toString();
    }

    public static String fatFingers(String str) {
        // Beautiful code

        StringBuilder nonCapslockedString = new StringBuilder();
        boolean isPreviousUpper = false;
        nonCapslockedString.append(str.charAt(0));
        for (int i = 1; i < str.length(); i++) {
            char currentCharacter = str.charAt(i);
            if(Character.isUpperCase(currentCharacter)) {
                if(!isPreviousUpper) {
                    nonCapslockedString.append('a');

                }
                isPreviousUpper = true;
            } else if(currentCharacter != ' '){
                isPreviousUpper = false;
            }
            nonCapslockedString.append(Character.toLowerCase(currentCharacter));
        }
        return nonCapslockedString.toString();

    }
}
