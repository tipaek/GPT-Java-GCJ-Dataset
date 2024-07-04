import java.util.*;

public class Solution{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int testcases = sc.nextInt();
        // Testcases loop
        for(int i = 0; i < testcases; i++){
            int testcase = i + 1;
            String output = sc.next();
            String retString = new String();

            int open = (int) output.charAt(0) - 49;
            for(int j = 0; j < open + 1; j++){
                retString += "(";
            }

            // Add loop for different parenthesis
            if(output.length()>1) {
                for (int j = 0; j < output.length()-1; j++) {
                    int diff = ((int) output.charAt(j+1)) - ((int) output.charAt(j));
                    retString+=output.charAt(j);
                    if(diff > 0){
                        for(int k = 0; k < diff; k++) {
                            retString += "(";
                        }
                    } else if(diff < 0){
                        for(int k = 0; k < Math.abs(diff); k++){
                            retString += ")";
                        }
                    }
                }
                retString+=output.charAt(output.length()-1);
            } else {
                retString+=output;
            }

            // Add closing parentheses
            int close = (int) output.charAt(output.length()-1) - 49;
            for(int j = 0; j < close + 1; j++){
                retString+=")";
            }


            // output the line
            System.out.println("Case #" + testcase + ": " + retString);

        }


    }
}