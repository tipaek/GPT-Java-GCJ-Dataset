import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < t; i++){
            String line = scanner.nextLine();

            int counter = 0;
            String output = "";

            for (int k = 0; k < line.length() ; k ++) {
                String nextChar = String.valueOf(line.charAt(k));
                int nextNum = Integer.parseInt(nextChar);
                nextNum = nextNum - counter;
                //nextNum represents now the difference between the number of parentheses we need to have,
                //compared to the current number of "(" or ")"
                if (nextNum > 0) {
                    for (int j = 0; j < nextNum; j++){
                        output = output.concat("(");
                    }
                    counter += nextNum;
                } else if (nextNum < 0) {
                    for (int j = 0; j < - nextNum; j++){
                        output = output.concat(")");
                    }
                    counter += nextNum;
                }
                output = output.concat(nextChar);
            }
            while (counter > 0){
                output = output.concat(")");
                counter --;
            }

            int caseNum = i+1;
            System.out.println("Case #" + (caseNum) + ": " + output);
        }
    }

}
