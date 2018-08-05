public class MontyHall {


    public static void main(String[] args) {


        System.out.println(montyHallCase(1, new int[]{3,3,2,3,3,2,2,3,2,2,1,1,1,1}));

    }


    public static int montyHallCase(int correctDoorNumber, int[] participantGuesses) {
        double countOfPeopleWhoWillSwitchFromCorrectDoor =0;
        for (int i = 0; i < participantGuesses.length ; i++) {
            if(participantGuesses[i] == correctDoorNumber) {
                countOfPeopleWhoWillSwitchFromCorrectDoor++;
            }else {
                participantGuesses[i] = correctDoorNumber;
            }
        }
        return (int) Math.round((100-((countOfPeopleWhoWillSwitchFromCorrectDoor/ participantGuesses.length)*100)));
    }
}
