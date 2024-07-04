import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {

    static String calculate(String string) throws IOException {
        char[] characterArray = string.toCharArray();
        int currentStack = 0;
        String answer = "";

        for (char currentChar: characterArray) {
            int currentInt = Character.getNumericValue(currentChar);
            if (currentInt > currentStack) {
                while (currentInt > currentStack) {
                    answer += "(";
                    currentStack++;
                }
                answer += Integer.toString(currentInt);
            } else if (currentInt == currentStack) {
                answer += currentInt;
            } else if (currentInt < currentStack) {
                while (currentInt < currentStack) {
                    answer += ")";
                    currentStack--;
                }
                answer += Integer.toString(currentInt);
            }
        }

        while (currentStack > 0) {
            answer += ")";
            currentStack--;
        }

        return answer;
    }

    public static void main (String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        int T = t;

        while (t-- > 0) {
            String string = br.readLine();
            System.out.println("Case #" + (T-t) + ": " + calculate(string));
        }
    }
}