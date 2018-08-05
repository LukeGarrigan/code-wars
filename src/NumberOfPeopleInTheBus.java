import java.util.ArrayList;

public class NumberOfPeopleInTheBus {


    public static void main(String[] args) {


        ArrayList<int[]> list = new ArrayList<int[]>();
        list.add(new int[] {10,0});
        list.add(new int[] {3,5});
        list.add(new int[] {2,5});


        System.out.println(countPassengers(list));


    }


    public static int countPassengers(ArrayList<int[]> stops) {
        int on = 0;
        int off = 0;
        for (int[] stop : stops) {
            on += stop[0];
            off += stop[1];
        }
        return on-off;
    }
}
