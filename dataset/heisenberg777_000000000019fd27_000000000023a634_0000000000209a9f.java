import java.util.ArrayList;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int maxCases = sc.nextInt();
        sc.nextLine();
        ArrayList<ArrayList<String>> inStringSet = new ArrayList<>();

        for (int caseNumber = 1; caseNumber <= maxCases; caseNumber++) {
            String s = sc.nextLine().trim();
            ArrayList<String> stringToList = new ArrayList<>();
            for (int i = 0; i < s.length(); i++) {
                stringToList.add(Character.toString(s.charAt(i)));
            }
            inStringSet.add(stringToList);
        }

        ArrayList<ArrayList<String>> results = new ArrayList<>();
        for (int caseNumber = 1; caseNumber <= maxCases; caseNumber++) {
            results.add(answerMaker(inStringSet.get(caseNumber - 1), 0, inStringSet.get(caseNumber - 1).size() - 1, 0));
        }

        for (int caseNumber = 1; caseNumber <= maxCases; caseNumber++) {
            String s = "";
            for (int i = 0; i < results.get(caseNumber - 1).size(); i++) {
                s += results.get(caseNumber - 1).get(i);
            }
            System.out.println("Case #" + caseNumber + ": " + s);
        }
    }

    public static ArrayList<String> answerMaker(ArrayList<String> currentString, int startIndex, int endIndex, int depth) {
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
        ArrayList<String> halfArray = answerMaker(currentString, newStartIndex, newEndIndex, depth + 1);
        returnArrayList.addAll(halfArray);
        returnArrayList.add(")");
        if (breakZeroPosition >= 0) {
            returnArrayList.add(currentString.get(breakZeroPosition));
            halfArray = answerMaker(currentString, breakZeroPosition + 1, endIndex, depth);
            returnArrayList.addAll(halfArray);
        }

        return returnArrayList;
    }
}