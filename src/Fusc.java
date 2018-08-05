public class Fusc {

    public static void main(String[] args) {


        System.out.println(fusc(21));
    }


    //todo
    public static int fusc(int n) {

        if(n == 0) {
            return 0;
        }else if(n == 1) {
            return 1;
        }

        return fusc(2*n);



    }

}
