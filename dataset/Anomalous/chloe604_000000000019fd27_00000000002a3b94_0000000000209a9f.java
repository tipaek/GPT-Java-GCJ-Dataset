package googlecodejam;

import java.util.ArrayList;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> inputList = new ArrayList<>();
        ArrayList<String> outputList = new ArrayList<>();
        StringBuilder stringBuilder = new StringBuilder("testing");
        int testCaseCount = scanner.nextInt();

        for (int i = 0; i < testCaseCount; i++) {
            inputList.add(scanner.next());
        }

        for (int i = 0; i < inputList.size(); i++) {
            String currentString = inputList.get(i);
            if (currentString.charAt(0) == '0' && allCharactersSame(currentString)) {
                outputList.add(currentString);
            } else {
                for (int j = 0; j < currentString.length(); j++) {
                    if (currentString.charAt(j) == '1') {
                        stringBuilder = new StringBuilder(currentString);
                        stringBuilder.insert(j, "(");
                        if (j != currentString.length() - 1 && currentString.charAt(j) != currentString.charAt(j + 1)) {
                            stringBuilder.insert(j + 2, ")");
                        } else if (j == currentString.length() - 1) {
                            stringBuilder.insert(j + 2, ")");
                        }
                    }
                }
                outputList.add(stringBuilder.toString());
            }
        }

        for (int i = 0; i < outputList.size(); i++) {
            System.out.println("Case #" + (i + 1) + ": " + outputList.get(i));
        }
    }

    private static boolean allCharactersSame(String s) {
        char firstChar = s.charAt(0);
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) != firstChar) {
                return false;
            }
        }
        return true;
    }
}