public class MakeTimeReadable {


    public static void main(String[] args) {


        System.out.println(makeReadable(5));

    }

    public static String makeReadable(int seconds) {

        // 60 seconds in a minute
        // 3600 seconds in an hour

        double inSeconds = (double) seconds;
        double timeInHours = inSeconds / 3600;
        double timeInMinutes = (inSeconds / 60) % 60;
        double timeInSeconds = seconds % 60;

        StringBuilder humanReadable = new StringBuilder();

        humanReadable.append((int) timeInHours < 10 ? "0" + (int) timeInHours : (int) timeInHours);
        humanReadable.append(":");
        humanReadable.append((int) timeInMinutes < 10 ? "0" + (int) timeInMinutes : (int) timeInMinutes);
        humanReadable.append(":");
        humanReadable.append((int) timeInSeconds < 10 ? "0" + (int) timeInSeconds : (int) timeInSeconds);
        return humanReadable.toString();
    }
}
