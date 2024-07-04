import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numCases = scanner.nextInt();
        scanner.nextLine();
        for(int i = 0; i < numCases; i++) {
            String input = scanner.nextLine();
            char[] inputArray = input.toCharArray();
            ArrayList<ArrayList<Character>> strings = new ArrayList<>();
            ArrayList<Character> sequence = new ArrayList<>();
            char lastChar = inputArray[0];
            sequence.add(lastChar);
            sequence.add(' ');
            for(int index = 1; index < inputArray.length; index++) {
                int currentNum = Integer.parseInt(String.valueOf(inputArray[index]));
                if(currentNum >= Integer.parseInt(String.valueOf(lastChar))) {
                    sequence.add(inputArray[index]);
                    sequence.add(' ');
                    lastChar = inputArray[index];
                } else {
                    lastChar = inputArray[index];
                    strings.add(sequence);
                    sequence = new ArrayList<>();
                    sequence.add(lastChar);
                    sequence.add(' ');
                }
            }
            sequence.remove(sequence.size() - 1);
            strings.add(sequence);

            String sans = "";
            for(ArrayList<Character> c : strings) {
                StringBuilder builder = new StringBuilder(c.size());
                for(Character ch: c) {
                    builder.append(ch);
                }
                String passString = builder.toString();
                sans += addParentheses(passString);
            }

            System.out.println("Case #" + (i + 1) + ": " + sans);
        }
    }

    public static String addParentheses(String string) {
        String[] stringArray = string.split(" ");
        ArrayList<String> array = new ArrayList<String>(Arrays.asList(stringArray));
        ArrayList<String> resultArray = new ArrayList<>(array);
        int numAddedParentheses = 0;
        for(int index = 0; index < array.size(); index++) {
            int number = Integer.parseInt(array.get(index));
            for(int p = 0; p < number - numAddedParentheses; p++) {
                resultArray.add(index + numAddedParentheses, "(");
                resultArray.add(")");
            }
            numAddedParentheses += (number - numAddedParentheses);
        }
        String result = "";
        for(String s : resultArray) {
            result += s;
        }
        return result;
    }
}
