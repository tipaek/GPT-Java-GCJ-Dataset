import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        nestingDepth();
    }

    public static void nestingDepth(){
        Scanner scanner = new Scanner(new BufferedInputStream(System.in));
        int t = scanner.nextInt();
        scanner.nextLine();
        ArrayList<String> outputs = new ArrayList<String>();
        for(int i = 0; i < t; i++) {
            String nextLine = scanner.nextLine();
            String output = "";
            int firstDigit = Integer.parseInt(nextLine.charAt(0) + "");
            output += giveOpenBrackets(firstDigit) + firstDigit;
            for(int j = 1; j < nextLine.length(); j++) {
                int last = Integer.parseInt(nextLine.charAt(j - 1) + "");
                int act = Integer.parseInt(nextLine.charAt(j) + "");
                int abs = last - act;
                if(abs < 0) {
                    output += giveOpenBrackets(abs * -1) + act;
                } else if(abs > 0) {
                    output += giveCloseBrackets(abs) + act;
                } else {
                    output += act;
                }
            }
            output += giveCloseBrackets(Integer.parseInt("" + nextLine.charAt(nextLine.length() - 1)));
            outputs.add(output);
        }
        for(int i = 0; i < t; i++) {
            System.out.println("Case #" + (i + 1) + ": " + outputs.get(i));
        }
    }

    private static String giveOpenBrackets(int number) {
        String brackets = "";
        for(int i = 0; i < number; i++) {
            brackets += "(";
        }
        return brackets;
    }

    private static String giveCloseBrackets(int number) {
        String brackets = "";
        for(int i = 0; i < number; i++) {
            brackets += ")";
        }
        return brackets;
    }
}