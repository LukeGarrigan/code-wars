public class NearestSquareNumber {


    public static void main(String[] args) {


        System.out.println(nearestSq(10));


    }

    public static int nearestSq(int n){
        for (int i = 0; i < n; i++) {
            int squaredNumber = i * i;
            if(squaredNumber > n) {
                int difference = squaredNumber - n;
                int secondSquareNumber = (i-1)*(i-1);
                int differenceBelow = n - secondSquareNumber;
                if(difference < differenceBelow) {
                    return squaredNumber;
                }else {
                    return secondSquareNumber;
                }
            }
        }
        return 1;
    }
}
