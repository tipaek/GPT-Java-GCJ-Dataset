import java.util.ArrayList;
import java.util.Scanner;

// Solution to CodeJam 2020 Question number 2 Qualification Round
public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numberOfCases = sc.nextInt();
        sc.nextLine();
        ArrayList<ArrayList<String>> inputStrings = new ArrayList<>();

        //Takes input
        for (int caseId = 1; caseId <= numberOfCases; caseId++) {
            String s = sc.nextLine().trim();
            ArrayList<String> stringToList = new ArrayList<>();
            for (int i = 0; i < s.length(); i++) {
                stringToList.add(Character.toString(s.charAt(i)));
            }
            inputStrings.add(stringToList);
        }

        // Solves the problem
        ArrayList<ArrayList<String>> results = new ArrayList<>();
        for (int caseId = 1; caseId <= numberOfCases; caseId++) {
            results.add(ParanStringBuilder(inputStrings.get(caseId - 1), 0, inputStrings.get(caseId - 1).size() - 1, 0));
        }

        // Prints the answer
        for (int caseId = 1; caseId <= numberOfCases; caseId++) {
            String s = "";
            for (int i = 0; i < results.get(caseId - 1).size(); i++) {
                s += results.get(caseId - 1).get(i);
            }
            System.out.println("Case #" + caseId + ": " + s);
        }
    }

    // Builds the result
    public static ArrayList<String> ParanStringBuilder(ArrayList<String> currentString, int startIndex, int endIndex, int depth) {
        int breakZeroPosition = -1;
        ArrayList<String> returnArrayList = new ArrayList<>();

        if (startIndex == endIndex) {
            int effectiveValue = Integer.parseInt(currentString.get(startIndex)) - depth;
            for (int i = 0; i < effectiveValue; i++) {
                returnArrayList.add("(");
            }
            returnArrayList.add(currentString.get(startIndex));
            for (int i = 0; i < effectiveValue; i++) {
                returnArrayList.add(")");
            }
            return returnArrayList;
        }

        int newStartIndex = endIndex + 1;
        for (int i = startIndex; i <= endIndex; i++) {
            if (Integer.parseInt(currentString.get(i)) - depth != 0) {
                newStartIndex = i;
                break;
            }
        }
        if (newStartIndex < 0) {
            return new ArrayList<>();
        }

        if (newStartIndex > endIndex) {
            // All zero
            for (int i = startIndex; i <= endIndex; i++) {
                returnArrayList.add(currentString.get(i));
            }
            return returnArrayList;
        } else {
            for (int i = startIndex; i < newStartIndex; i++) {
                returnArrayList.add(currentString.get(i));
            }
        }

        returnArrayList.add("(");

        for (int i = newStartIndex; i <= endIndex; i++) {
            int value = Integer.parseInt(currentString.get(i)) - depth;
            if (value == 0) {
                breakZeroPosition = i;
                break;
            }
        }

        int newEndIndex = endIndex;
        if (breakZeroPosition >= 0) {
            newEndIndex = breakZeroPosition - 1;
        }
        ArrayList<String> halfArray = ParanStringBuilder(currentString, newStartIndex, newEndIndex, depth + 1); // First Upper
        returnArrayList.addAll(halfArray);
        returnArrayList.add(")");
        if (breakZeroPosition >= 0) {
            returnArrayList.add(currentString.get(breakZeroPosition));
            halfArray = ParanStringBuilder(currentString, breakZeroPosition + 1, endIndex, depth); // Next lower
            returnArrayList.addAll(halfArray);
        }

        return returnArrayList;
    }
}