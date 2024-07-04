import java.util.*;
import java.io.*;

public class Solution {
    
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = Integer.parseInt(in.nextLine());
        for (int i = 1; i <= testCases; i++) {
            ArrayList<ArrayList<Integer>> digits = new ArrayList<>();
            String line = in.nextLine();
            int lastDigit = Character.getNumericValue(line.charAt(0));
            ArrayList<Integer> tmp = new ArrayList<>();
            tmp.add(lastDigit);
            digits.add(tmp);
            for (int j = 1; j < line.length(); j++) {
                int digit = Character.getNumericValue(line.charAt(j));
                if (digit == lastDigit) {
                    digits.get(digits.size()-1).add(digit);
                } else {
                    ArrayList<Integer> l = new ArrayList<>();
                    l.add(digit);
                    digits.add(l);
                }
                lastDigit = digit;
            }
            String output = "";
            for (int j = 0; j < digits.size(); j++) {
                int digit = digits.get(j).get(0);
                for (int x = 1; x <= digit; x++) {
                    output += "(";
                }
                for (int x = 0; x < digits.get(j).size(); x++) {
                    output += digit;
                }
                for (int x = 0; x < digit; x++) {
                    output += ")";
                }
            }
            System.out.println("Case #" + i + ": " + output);
        }
    }
}