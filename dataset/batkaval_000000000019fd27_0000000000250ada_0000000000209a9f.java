import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {

        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); 
        for (int num = 1; num <= t; num++) {
            String input = in.next();
            String output = "";

            int opened = 0;
            
            for(int j = 0; j< input.length(); j++) {

                int d = Integer.parseInt(String.valueOf(input.charAt(j)));
                
                for (int i = opened; i < d; i++, opened++) {
                    output += "(";
                }
                for (;opened > d; opened--) {
                    output +=")";
                }
                
                output += d;
            }

            for (;opened > 0; opened--) {
                output +=")";
            }
            
            System.out.println("Case #" + num + ": " + output);
        }
    }
}
