
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int testCases = input.nextInt();

        for(int i = 0; i < testCases; i++){
            String s = input.next();
            StringBuilder sPrime = new StringBuilder();
            int depth = 0;

            for(int j = 0; j < s.length(); j++){
                int current = Character.getNumericValue(s.charAt(j));
                int difference = current - depth;
                if(difference > 0){
                    for(int k = 0; k < difference; k++){
                        sPrime.append("(");
                        depth++;
                    }
                }
                else if(difference < 0){
                    for(int k = 0; k < -difference; k++){
                        sPrime.append(")");
                        depth--;
                    }
                }
                sPrime.append(current);
            }
            for(int j = 0; j < depth; j++){
                sPrime.append(")");
            }


            System.out.printf("Case #%d: %s\n", i+1, sPrime.toString());
        }
    }

}
