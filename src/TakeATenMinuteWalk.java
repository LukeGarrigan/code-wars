public class TakeATenMinuteWalk {


    public static void main(String[] args) {

        System.out.println(isValid(new char[] {'w','e','w','e','w','e','w','e','w','e','w','e'}));
    }


    public static boolean isValid(char[] walk) {
        // Insert brilliant code here
        int northSouth = 0;
        int westEast = 0;

        for (int i = 0; i < walk.length; i++) {
            if (walk[i] == 'n') {
                northSouth += 1;
            } else if (walk[i] == 's') {
                northSouth -= 1;
            } else if (walk[i] == 'e') {
                westEast += 1;
            } else if (walk[i] == 'w') {
                westEast -= 1;
            }
        }
        if(walk.length == 10 && northSouth == 0 && westEast ==0 ) {
            return true;
        }else {
            return false;
        }
    }

}
