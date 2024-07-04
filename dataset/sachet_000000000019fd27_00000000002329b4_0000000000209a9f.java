
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {
    public static void main(String ar[]) throws IOException {

//        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
//        int numOfTest = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int numOfTest = Integer.valueOf(reader.readLine());

        for(int i = 1 ; i <= numOfTest ; i++) {
            String casE = reader.readLine();
            System.out.println("Case #" + i + ": "+ getAnswer(casE));
        }
    }

    public static String getAnswer(String input) {
        String ans = "";
        int numOfOpen= 0;
        int startIndex = 0;
        for(int i = 0 ; i < input.length(); i++) {
            char curr = input.charAt(i);
            int currNumber = curr-48;
            //System.out.println(currNumber);
            if(currNumber == 0) {

                for(int x = 0 ; x < numOfOpen; x++) {
                    ans = ans + ")";
                }
                numOfOpen = 0;
                ans = ans + curr;
                startIndex = ans.length()-1;
                continue;
            }
            if(currNumber == numOfOpen) {
                ans = ans + currNumber;
            }
            if(currNumber > numOfOpen) {
                String substr = "";
                int cnt = 0;
                for(int l = 0 ; l < (currNumber-numOfOpen); l++) {
                    substr =  substr + '(';
                    cnt++;
                }
                numOfOpen = numOfOpen + cnt;
                //System.out.println(startIndex + "   "  + substr + "   " + numOfOpen);
//                if(startIndex == 0) {
//                   ans = ans + substr;
//                } else {
//                    ans = ans.substring(0, startIndex + 1) + substr + ans.substring(startIndex + 1);
//                }
                ans =ans + substr;
                ans = ans + curr;
            }
            if(currNumber < numOfOpen) {
                int cnt = 0;
                for(int l = 0 ; l < (numOfOpen-currNumber); l++) {
                    ans = ans + ")";
                    cnt++;
                }
                numOfOpen = numOfOpen - cnt;
                ans = ans + curr;
            }
        }
        for(int x = 0 ; x < numOfOpen; x++) {
            ans = ans + ")";
        }
        return ans;
    }



}
