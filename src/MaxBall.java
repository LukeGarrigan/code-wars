public class MaxBall {


    public static void main(String[] args) {


        System.out.println(maxBall(37));

    }


    public static int maxBall(int v0) {
        // your code

        double metresPerSecond = v0 * 0.277778;
        double maxHeight = 0;
        for (int i = 0; i < Integer.MAX_VALUE; i++) {

            double currentHeight = metresPerSecond * i - (0.5 * Math.pow(9.81, 2) * i * i);
            if(currentHeight < maxHeight) {
                return (int) maxHeight;
            }else {
                maxHeight = currentHeight;
            }
        }

        return 0;
    }



}
