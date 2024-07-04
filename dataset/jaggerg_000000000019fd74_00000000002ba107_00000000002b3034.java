import java.util.Scanner;

public class Solution {

    /**
     * This is just a point-grab version at this point.
     */

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int numTests = Integer.parseInt(sc.nextLine());

        for(int t = 1; t <= numTests; t++){
            int n = Integer.parseInt(sc.nextLine());

            String[] inputs = new String[n];
            int maxLengthIndex = 0;
            int maxLength = -1;

            for(int i = 0; i < inputs.length; i++){
                inputs[i] = sc.nextLine();
                if(inputs[i].length() > maxLength){
                    maxLengthIndex = i;
                    maxLength = inputs[i].length();
                }
            }

            String maxString = inputs[maxLengthIndex];

            boolean bad = false;

            for(int i = 0; i < maxLength; i++){
                for(String j : inputs){
                    if(i >= j.length() - 1) continue;
                    if(j.charAt(j.length() - i - 1) != maxString.charAt(maxLength - i - 1)){
                        bad = true;
                        break;
                    }
                }
                if(bad) break;
            }

            if(bad){
                System.out.println("Case #" + t + ": *");
            } else {
                System.out.println("Case #" + t + ": " + inputs[maxLengthIndex].substring(1));
            }
        }
    }
}


