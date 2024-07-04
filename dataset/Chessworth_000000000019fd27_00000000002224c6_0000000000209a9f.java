import java.util.*;
import java.io.*;
class Solution {
    public static int countLeftBrackets(String s){
        int leftCount = 0, fromIndex = 0,rightCount=0;
        while ((fromIndex = s.indexOf('(', fromIndex)) != -1 ){
            leftCount++;
            fromIndex++;
        }
        fromIndex = 0;
        while ((fromIndex = s.indexOf(')', fromIndex)) != -1 ){
            rightCount++;
            fromIndex++;
        }
        return leftCount-rightCount;
    }
    public static StringBuilder newString(int add){
        StringBuilder output = new StringBuilder(10);
        if(add <0){
            output.append(")".repeat(-add));
        }
        else{
            output.append("(".repeat(add));
        }
        return output;
    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int t = input.nextInt();
        for (int i = 1; i <= t; ++i) {
            String s = input.next();
            char[] sArr = s.toCharArray();
            StringBuilder curString = new StringBuilder(300);
            for(int j=0; j<s.length();j++){
                int value = Integer.parseInt(Character.toString(sArr[j]));
                int leftBracks = countLeftBrackets(curString.toString());
                curString.append(newString(value - leftBracks));
                curString.append(value);
            }
            curString.append(newString(- Integer.parseInt(Character.toString(sArr[s.length() - 1]))));
            System.out.println("Case #" + i + ": " + curString );
        }
    }
}
