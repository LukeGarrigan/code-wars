public class TestingObserver {

    public static void main(String[] args) {


        int[] numbers = {1, 2, 3, 4};
        countNumbers(numbers, new Function() {
            @Override
            public void execute() {

                System.out.println("I'm selling potatoes");

            }
        });

    }

    public static void countNumbers(int[] numbers, Function function) {

        int total = 0;
        for (int i = 0; i < numbers.length; i++) {

            total += numbers[i];
            System.out.println(total);
            function.execute();

        }

    }


}

interface Function {


    void execute();


}
