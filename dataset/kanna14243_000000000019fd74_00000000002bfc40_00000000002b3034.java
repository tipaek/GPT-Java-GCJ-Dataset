import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numTests = sc.nextInt();
        int i = 1;
        while (i <= numTests) {
            int nop = sc.nextInt();
            Result finalResult = new Result();
            boolean possible = true;
            for (int j = 0; j < nop; j++) {
                String newPattern = sc.next();
                Result parsedResult = parseResult(newPattern);
                if (!mergeResult(finalResult, parsedResult)) {
                    possible = false;
                    break;
                }
            }
            if(!possible) {
                System.out.println("Case #" + (i) + ": *");
            } else {
                StringBuilder sb = new StringBuilder();
                if (finalResult.startsWith != null) {
                    sb.append(finalResult.startsWith);
                }
                for (String str : finalResult.contains) {
                    sb.append(str);
                }
                if (finalResult.endsWith != null) {
                    sb.append(finalResult.endsWith);
                }
                System.out.println("Case #" + (i) + ": " + sb.toString());
            }
            i++;
        }
    }

    private static boolean mergeResult(Result finalResult, Result parsedResult) {
        if (finalResult.startsWith != null && parsedResult.startsWith != null) {
            if (finalResult.startsWith.length() > parsedResult.startsWith.length()) {
                if (!finalResult.startsWith.startsWith(parsedResult.startsWith)) {
                    return false;
                }
            } else {
                if(!parsedResult.startsWith.startsWith(finalResult.startsWith)) {
                    return false;
                } else {
                    finalResult.startsWith = parsedResult.startsWith;
                }
            }
        } else if (parsedResult.startsWith != null) {
            finalResult.startsWith = parsedResult.startsWith;
        }
        if (finalResult.endsWith != null && parsedResult.endsWith != null) {
            if (finalResult.endsWith.length() > parsedResult.endsWith.length()) {
                if(!finalResult.endsWith.endsWith(parsedResult.endsWith)) {
                    return false;
                }
            } else {
                if(!parsedResult.endsWith.endsWith(finalResult.endsWith)) {
                    return false;
                } else {
                    finalResult.endsWith = parsedResult.endsWith;
                }
            }
        } else if (parsedResult.endsWith != null) {
            finalResult.endsWith = parsedResult.endsWith;
        }
        finalResult.contains.addAll(parsedResult.contains);
        return true;
    }

    private static Result parseResult(String newPattern) {
        Result result = new Result();
        int currIndex = 0;
        if (!newPattern.startsWith("*")) {
            int starInd = newPattern.indexOf("*");
            if (starInd == -1) {
                result.startsWith = newPattern;
                result.endsWith = newPattern;
                return result;
            }
            result.startsWith = newPattern.substring(0, starInd);
            currIndex = starInd;
        }
        while (currIndex < newPattern.length()) {
            while (currIndex < newPattern.length() && newPattern.charAt(currIndex) == '*') {
                currIndex++;
            }
            if (currIndex == newPattern.length()) {
                return result;
            }
            int starInd = newPattern.indexOf('*', currIndex);
            if (starInd == -1) {
                result.endsWith = newPattern.substring(currIndex);
                return result;
            }
            result.contains.add(newPattern.substring(currIndex, starInd));
            currIndex = starInd;
        }
        return result;
    }

    public static class Result {
        String startsWith;
        String endsWith;
        List<String> contains = new ArrayList<>();
    }

}
