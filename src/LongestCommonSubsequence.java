public class LongestCommonSubsequence {


    /**
     * I have read the question completely wrong, ignore my answer
     *
     * @param args
     */
    public static void main(String[] args) {


        System.out.println(lcs("abcdef", "acf"));

    }

    static String lcs(String a, String b) {
        String longestSubsequence = "";

        for (int i = 0; i < a.length(); i++) {

            char startCharacter = a.charAt(i);

            for (int j = 0; j < b.length(); j++) {

                int count = 1;
                if (b.charAt(j) == startCharacter) {


                    int leftOfA = (a.length() - 1) - i;
                    int leftOfB = (b.length() - 1) - j;

                    int maxK = leftOfA < leftOfB ? leftOfA : leftOfB;

                    for (int k = 0; k < maxK; k++) {


                        if (a.charAt(k + i) == b.charAt(k + i)) {
                            count++;
                            if (count > longestSubsequence.length()) {
                                longestSubsequence = a.substring(i,i+count);
                            }
                        } else{
                            break;
                        }
                    }
                }


            }


        }
        return longestSubsequence;
    }
}
