import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {

    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int numberInstances = Integer.parseInt(br.readLine());
            for (int i = 1; i <= numberInstances; ++i) {
                if (processInstance(br, i)) {
                    System.out.println("Case #" + i + ": *");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static boolean processInstance(BufferedReader br, int caseNumber) throws IOException {
        StringBuilder sb = new StringBuilder();
        StringBuilder tailOfString = new StringBuilder();
        String[] arguments = br.readLine().split(" ");
        int number = Integer.parseInt(arguments[0]);
        char[][] allPatterns = new char[number][];
        int[] currentLeft = new int[number];
        int[] currentRight = new int[number];

        for (int j = 0; j < number; j++) {
            allPatterns[j] = br.readLine().toCharArray();
            currentRight[j] = allPatterns[j].length - 1;
        }

        if (!processPatterns(allPatterns, currentLeft, sb, true) || 
            !processPatterns(allPatterns, currentRight, tailOfString, false)) {
            return true;
        }

        appendMiddleParts(allPatterns, currentLeft, currentRight, sb);
        System.out.println("Case #" + caseNumber + ": " + sb.toString() + tailOfString.toString());
        return false;
    }

    private static boolean processPatterns(char[][] allPatterns, int[] currentIndices, StringBuilder sb, boolean isLeft) {
        boolean done = false;
        while (!done) {
            done = true;
            for (int j = 0; j < allPatterns.length; j++) {
                if (allPatterns[j][currentIndices[j]] != '*') {
                    done = false;
                    char added = allPatterns[j][currentIndices[j]];
                    if (isLeft) {
                        sb.append(added);
                    } else {
                        sb.insert(0, added);
                    }
                    if (!updateIndices(allPatterns, currentIndices, added)) {
                        return false;
                    }
                    break;
                }
            }
        }
        return true;
    }

    private static boolean updateIndices(char[][] allPatterns, int[] currentIndices, char added) {
        for (int k = 0; k < allPatterns.length; k++) {
            if (allPatterns[k][currentIndices[k]] != '*' && allPatterns[k][currentIndices[k]] != added) {
                return false;
            }
            if (allPatterns[k][currentIndices[k]] != '*') {
                currentIndices[k] += currentIndices == currentIndices ? 1 : -1;
            }
        }
        return true;
    }

    private static void appendMiddleParts(char[][] allPatterns, int[] currentLeft, int[] currentRight, StringBuilder sb) {
        for (int j = 0; j < allPatterns.length; j++) {
            while (currentLeft[j] != currentRight[j]) {
                if (allPatterns[j][currentLeft[j]] == '*') {
                    currentLeft[j]++;
                } else {
                    sb.append(allPatterns[j][currentLeft[j]]);
                    currentLeft[j]++;
                }
            }
        }
    }
}