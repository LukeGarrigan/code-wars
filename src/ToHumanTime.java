

public class ToHumanTime {


    public static void main(String[] args) {


        System.out.println(toHumanTime("12:45 pm"));
    }

    private static final String[] oneToThirtyNames = {"", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten", "eleven", "twelve", "thirteen", "fourteen",
            "quarter", "sixteen", "seventeen", "eighteen", "nineteen", "twenty", "twenty-one", "twenty-two", "twenty-three", "twenty-four",
            "twenty-five", "twenty-six", "twenty-seven", "twenty-eight", "twenty-nine", "half"
    };


    public static String toHumanTime(String time) {
        String hours = time.substring(0, 2);
        String minutes = time.substring(3, 5);

        int hoursAsNumber = Integer.parseInt(hours);
        if(hoursAsNumber > 12){
            hours = String.valueOf(hoursAsNumber-12);
        }

        boolean toTheHour = isToTheHour(minutes);
        String minutesInEnglish = getMinutesAsEnglish(minutes, toTheHour);
        String hoursInEnglish = getHoursAsEnglish(hours, toTheHour);


        if (minutesInEnglish.equals(" o'clock")) {
            return hoursInEnglish + minutesInEnglish;
        }
        return minutesInEnglish + hoursInEnglish;
    }

    private static boolean isToTheHour(String minutes) {
        return Integer.parseInt(minutes) > 30;
    }

    private static String getHoursAsEnglish(String hours, boolean toTheHour) {
        String hoursAsEnglish = toTheHour ? oneToThirtyNames[Integer.parseInt(hours) + 1] : oneToThirtyNames[Integer.parseInt(hours)];
        if (hoursAsEnglish.isEmpty()) {
            return "twelve";
        } else if(toTheHour && (Integer.parseInt(hours)+1) > 12){
            return oneToThirtyNames[Integer.parseInt(hours)-11];
        }else {
            return hoursAsEnglish;
        }
    }

    private static String getMinutesAsEnglish(String minutes, boolean toTheHour) {
        int minutesAsNumber = Integer.parseInt(minutes);
        if (minutesAsNumber == 0) {
            return " o'clock";
        }
        String connector = toTheHour ? " to " : " past ";
        if (connector.equals(" to ")) {
            minutesAsNumber = 60 - minutesAsNumber;
        }
        String minutesInEnglish = oneToThirtyNames[minutesAsNumber];
        if (minutesAsNumber != 15 && minutesAsNumber != 30) {
            return minutesInEnglish + (minutesAsNumber != 1 ? " minutes" : " minute") + connector;
        } else {
            return minutesInEnglish + connector;
        }

    }


}
