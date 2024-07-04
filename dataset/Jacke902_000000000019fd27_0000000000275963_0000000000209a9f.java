import java.util.*;

public class Solution {

    public static void main (String args[]) {

        Scanner scan = new Scanner(System.in);
        int numberOfCases = scan.nextInt();
        //start each case
        int counter = 1;
        scan.nextLine();
        while ( counter <= numberOfCases) {

            String line = scan.nextLine();
            int totalParenthesisOpen = 0;
            String nestedParenthesis = "";
            for(int i=0; i< line.length(); i++) {
                String current = String.valueOf(line.charAt(i));
                int difference = Integer.parseInt(current) - totalParenthesisOpen;

                if (difference < 0) {
                    while(difference < 0) {
                        nestedParenthesis+=")";
                        totalParenthesisOpen--;
                        difference++;
                    }
                    nestedParenthesis += current;
                } else  if (difference > 0) {
                    while(difference > 0) {
                        nestedParenthesis+="(";
                        totalParenthesisOpen++;
                        difference--;
                    }
                    nestedParenthesis += current;
                } else {
                    nestedParenthesis += current;
                }
            }

            while (totalParenthesisOpen > 0) {
                nestedParenthesis+=")";
                totalParenthesisOpen--;
            }

            System.out.println("Case #"+counter+": "+nestedParenthesis);
            counter++;
        }
    }
}

