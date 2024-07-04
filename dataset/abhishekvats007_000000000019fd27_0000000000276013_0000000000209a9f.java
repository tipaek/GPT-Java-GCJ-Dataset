

import java.util.Scanner;

public class Solution {

    public static void startBracket(StringBuilder newString, int times){
        for (int i = 0; i < times; i++) {
            newString.append("(");
        }
    }

    public static void closeBracket(StringBuilder newString, int times){
        for (int i = 0; i < times; i++) {
            newString.append(")");
        }
    }



    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        byte totalTestCases = scanner.nextByte();
        scanner.nextLine();

        for (byte i = 0; i < totalTestCases; i++) {
            String oldString = scanner.nextLine();

            StringBuilder newString = new StringBuilder();
            int totalOpenedBracket = 0;
            for (int j = 0; j < oldString.length() ; j++) {
                int currentOpenBracket = oldString.charAt(j) - '0';

                startBracket(newString, currentOpenBracket - totalOpenedBracket);
                newString.append(oldString.charAt(j));
                int closeBracket;
                if(j + 1 >= oldString.length()){
                    closeBracket = currentOpenBracket;
                }else{
                    int nextOldString = oldString.charAt(j+1) - '0';

                   if(nextOldString - currentOpenBracket > 0){
                       closeBracket = currentOpenBracket;
                   }else {
                       closeBracket = currentOpenBracket - nextOldString;
                   }
                }
                totalOpenedBracket = currentOpenBracket - closeBracket;
                closeBracket(newString,closeBracket);

            }
            System.out.printf("Case #%d: %s %n",i+1,newString);
        }
    }
}
