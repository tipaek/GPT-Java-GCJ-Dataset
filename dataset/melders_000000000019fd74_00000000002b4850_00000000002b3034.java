import java.io.*;
import java.util.*;

public class Solution {
    private static final boolean INTERACTIVE_PROBLEM = false;
    private static final String FILE_NAME = null;
    private static int B;

    private static String solve(Scanner in) {
        List<Character> startLetters = new ArrayList<>();
        List<Character> endLetters = new ArrayList<>();
        List<Character> middleLetters = new ArrayList<>();
        boolean isPossible = true;

        int N = in.nextInt();

        for (int i = 0; i < N; i++) {
            String patternI = in.next();
            int firstAsteriskIndex = 0;
            int lastAsteriskIndex = patternI.length() - 1;

            for (int j = 0; j < patternI.length() && isPossible && patternI.charAt(j) != '*'; j++) {
                firstAsteriskIndex++;
                if (j < startLetters.size()) {
                    if (startLetters.get(j).charValue() != patternI.charAt(j)) {
                        isPossible = false;
                    }
                } else {
                    startLetters.add(patternI.charAt(j));
                }
            }
            for (int j = 0; j < patternI.length() && isPossible && patternI.charAt(patternI.length() - 1 - j) != '*'; j++) {
                lastAsteriskIndex--;
                if (j < endLetters.size()) {
                    if (endLetters.get(j).charValue() != patternI.charAt(patternI.length() - 1 - j)) {
                        isPossible = false;
                    }
                } else {
                    endLetters.add(patternI.charAt(patternI.length() - 1 - j));
                }
            }
            for (int j = firstAsteriskIndex + 1; j < lastAsteriskIndex && isPossible; j++) {
                if (patternI.charAt(j) != '*') {
                    middleLetters.add(patternI.charAt(j));
                }
            }
        }

        StringBuilder finalString = new StringBuilder();

        if (isPossible) {
            for (int i = 0; i < startLetters.size(); i++) {
                finalString.append(startLetters.get(i));
            }
            for (int i = 0; i < middleLetters.size(); i++) {
                finalString.append(middleLetters.get(i));
            }
            for (int i = endLetters.size() - 1; i >= 0; i--) {
                finalString.append(endLetters.get(i));
            }
        } else {
            finalString.append('*');
        }

        return finalString.toString();
    }

    private static void run() {
        try {
            Scanner in = new Scanner(new BufferedReader(FILE_NAME == null ? new InputStreamReader(System.in)
                    : new FileReader(new File(FILE_NAME + ".in"))));

            long tc = in.nextLong();
            if (INTERACTIVE_PROBLEM) {
                B = in.nextInt();
            }
            for (long t = 1; t <= tc; t++) {
                final String solution = solve(in);
                if (INTERACTIVE_PROBLEM) {
                    System.out.println(solution);
                    if (in.next().equals("N")) {
                        break;
                    }
                } else {
                    System.out.println("Case #" + t + ": " + solution);
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        run();
    }
}
