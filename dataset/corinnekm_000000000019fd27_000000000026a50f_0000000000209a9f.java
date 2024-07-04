import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) throws FileNotFoundException {
        Map<String, String> digitLetter = new HashMap<>();
        digitLetter.put("1", "A");
        digitLetter.put("2", "B");
        digitLetter.put("3", "C");
        digitLetter.put("4", "D");
        digitLetter.put("5", "E");
        digitLetter.put("6", "F");
        digitLetter.put("7", "G");
        digitLetter.put("8", "H");
        digitLetter.put("9", "I");
        digitLetter.put("A", "1");
        digitLetter.put("B", "2");
        digitLetter.put("C", "3");
        digitLetter.put("D", "4");
        digitLetter.put("E", "5");
        digitLetter.put("F", "6");
        digitLetter.put("G", "7");
        digitLetter.put("H", "8");
        digitLetter.put("I", "9");


        //Scanner sc = new Scanner(new File("resources/input1.txt"));
        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        String line;
        /****************************************************************************/
        int T = Integer.parseInt(sc.nextLine());

        for (int t = 0; t < T; t++) {

            line = sc.nextLine();
            String result = line;

            int l = line.length();
            for (int digit = 1; digit <= 9; digit++) {
                String strDigit = Integer.toString(digit);
                for (int i = l - 1; l >= 0; l--) {
                    String current = generateString(l + 1, strDigit);
                    result = result.replace(current, generateString(digit, "(") + generateString(l + 1, digitLetter.get(strDigit)) + generateString(digit, ")"));
                }
                l = line.length();
            }

            System.out.println("Case #" + t + ": " + result
                    .replace("A", "1")
                    .replace("B", "2")
                    .replace("C", "3")
                    .replace("D", "4")
                    .replace("E", "5")
                    .replace("F", "6")
                    .replace("G", "7")
                    .replace("H", "8")
                    .replace("I", "9"));

        }
    }

    private static String generateString(int l, String s) {
        StringBuilder strB = new StringBuilder();
        for (int i = 0; i < l; i++) {
            strB.append(s);
        }
        return strB.toString();
    }
}
