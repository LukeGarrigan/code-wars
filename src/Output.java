import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Scanner;

public class Output {
    public static void main(String[] args) throws IOException {
        int numberOfRows = 250;
        String[] MakeANDModel = new String[numberOfRows];
        String[] CARID = new String[numberOfRows];
        String[] Year = new String[numberOfRows];
        String[] bodytype = new String[numberOfRows];
        String[] kilometers = new String[numberOfRows];
        String[] enginesize = new String[numberOfRows];
        String[] avaliable = new String[numberOfRows];
        System.out.println("CREATING A NEW FILE");
        System.out.println("Enter the path or location");
        Scanner input = new Scanner(System.in);
        String path = input.nextLine();
        File f = new File(path + "\\" + "Car_Store_DVS_File.csv");

        if (f.createNewFile()) {
            System.out.println("FILE IS CREATED");
        } else {
            System.out.println("file is not created =( ");
        }

        File infile = new File("Car_Store_DSV_file.txt");

        Scanner filereader = new Scanner(infile);

        filereader.useDelimiter("\"");
        int count = 0;

        while (filereader.hasNext()) {

            MakeANDModel[count] = filereader.next();
            System.out.println(MakeANDModel[count]);
            filereader.next();
            Year[count] = filereader.next();
            System.out.println(Year[count]);
            filereader.next();
            System.out.println(bodytype[count]);
            bodytype[count] = filereader.next();
            filereader.next();
            kilometers[count] = filereader.next();
            System.out.println(kilometers[count]);
            filereader.next();
            enginesize[count] = filereader.next();
            filereader.next();
            System.out.println(enginesize[count]);

            count++;
        }


        File outFile = new File("Car_Store_DVS_File.csv");

        PrintStream writeFile = new PrintStream(outFile);
        int index = 0;
        while (index <= CARID.length) //Check if the condition true
        {
            writeFile.println('"' + MakeANDModel[index] + '"' + ","
                    + '"' + Year[index] + '"' + "," + '"' + bodytype[index]
                    + '"' + "," + '"' + kilometers[index] + '"' + ","
                    + '"' + enginesize[index] + "," + '"');

            index++;  //Increment the count
        }

        System.out.println("---------------------------");
        //To spearte the file name that the user want to create
        System.out.println("!! YOUR FILE " +
                " IS CREATED !!");
        //Print message to confirm the file created with the name that
        //the user gave
        System.out.println("Have A Nice Day");
    }


}
