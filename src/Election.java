import java.util.ArrayList;
import java.util.Scanner;
import java.util.Collections;

// Creating a public class
public class Election {
    public static ArrayList<Integer> indexes = new ArrayList<>();

    public static int count(ArrayList<Integer> list, int element) {
        int count = 0;

        // creating a for loop

        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) == element) {
                indexes.add(i);
                count++;
            }
        }
        return count;
    }



    //Creating a main method
    public static void main(String[]args){
        Scanner scanner = new Scanner(System.in);
        String userInput;
        boolean keepGoing = true;
        ArrayList<String> candidateslist = new ArrayList<>();
        ArrayList<Integer> votelist = new ArrayList<>();
        System.out.println("-------------------------------------------------");
        System.out.println("| Start voting by entering the candidate names. |");
        System.out.println("|    Press any number or leave blank to exit.   |");
        System.out.println("-------------------------------------------------");
        // creating do....while loop
        do {
            userInput = scanner.nextLine();
            try {
                Integer.parseInt(userInput);
                keepGoing = false;
                break;
            } catch (Exception e) {
            }
            // creating if-else statement inside do..while loop to check statement
            if (userInput.trim().isEmpty()){
                keepGoing = false;
                break;
            }
            if (!(candidateslist.indexOf(userInput) >= 0)) {
                candidateslist.add(userInput);
                votelist.add(1);
            } else {
                int index = candidateslist.indexOf(userInput);
                votelist.set (index, (votelist.get(index) + 1));
            }
        }while (keepGoing);
        // creating a for loop
        for (int i = 0; i < candidateslist.size(); i++) {
            System.out.println(candidateslist.get(i) + " received " + votelist.get(i) + " votes. ");
        }
        System.out.println("..................................");
        // creating a for loop
        if (count(votelist, Collections.max(votelist)) > 1) {
            System.out.println( " Election concluded with a draw between: ");
            // creating a for loop
            for (int i = 0; i < indexes.size(); i++) {
                System.out.println(candidateslist.get(indexes.get(i)));
                System.out.println(" ");
                System.out.println( " \n" );
            }
        }else {
            int index = votelist.indexOf(Collections.max(votelist));
            System.out.println(" The winner is " + candidateslist.get(index) + " with " + votelist.get(index) + " votes.");
        }

    }

}


