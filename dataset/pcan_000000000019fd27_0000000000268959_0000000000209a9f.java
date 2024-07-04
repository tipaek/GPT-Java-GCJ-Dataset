import java.util.*;
import java.io.*;
import java.util.stream.*;

public class Solution {

    private static Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

    public static void main(String[] args) {
        int t = in.nextInt();
        in.nextLine();
        for (int i = 1; i <= t; ++i) {
            String line = in.nextLine();
            solveCase(i, line);
        }
    }
    
    private static void solveCase(int caseNumber, String line) {
        StringBuilder S = new StringBuilder();
        int openParantheses = 0;
        for(char c : line.toCharArray()) {
            int toOpenParantheses = Integer.parseInt(String.valueOf(c)) - openParantheses;
            if(toOpenParantheses > 0) {
                S.append(addParantheses(toOpenParantheses, "("));
            } else if(toOpenParantheses < 0) {
               S.append(addParantheses(Math.abs(toOpenParantheses), ")"));
            } 
            openParantheses += toOpenParantheses;
            S.append(c);
        }
        S.append(addParantheses(openParantheses, ")"));
        System.out.println("Case #" + caseNumber + ": " + S.toString());
    }
    
    private static String addParantheses(int toOpenParantheses, String type) {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < toOpenParantheses; i++)
            sb.append(type);
        return sb.toString();
    }
}