import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        for (int i = 0; i < t; i++) {
            int U = scanner.nextInt();
            DString dString = new DString();
            for (int j = 0; j < 10000; j++) {
                int Q = scanner.nextInt();
                String R = scanner.next();
                if (Q == -1) {
                    continue;
                }
                dString.add(R, Q);
            }
            String result = dString.computeResult();
            printResult(i, result);
        }
        scanner.close();
    }

    private static void printResult(int caseNumber, String result) {
        System.out.println("Case #" + (caseNumber + 1) + ": " + result);
    }
}

class DString {
    private final Map<Integer, CharPossibilities> possibilities;
    private final Set<Character> allChars;

    DString() {
        possibilities = new HashMap<>();
        allChars = new HashSet<>();
        for (int i = 0; i <= 9; i++) {
            possibilities.put(i, new CharPossibilities());
        }
    }

    public String computeResult() {
        char[] result = new char[10];
        while (!allChars.isEmpty()) {
            for (int i = 0; i < 10; i++) {
                CharPossibilities charPossibilities = possibilities.get(i);
                if (charPossibilities.canBe.size() + 1 == allChars.size()) {
                    char uniqueChar = 0;
                    for (char c : allChars) {
                        if (!charPossibilities.canBe.containsKey(c)) {
                            result[i] = c;
                            uniqueChar = c;
                        }
                    }
                    if (uniqueChar != 0) {
                        allChars.remove(uniqueChar);
                    }
                }
            }
        }
        return new String(result);
    }

    public void add(String R, int Q) {
        String qString = Integer.toString(Q);
        boolean isFirst = true;
        for (char c : R.toCharArray()) {
            if (allChars.size() < 10) {
                allChars.add(c);
            }
            if (isFirst) {
                possibilities.get(0).canBe.put(c, false);
                isFirst = false;
                if (R.length() == qString.length()) {
                    int firstDigit = Integer.parseInt(String.valueOf(qString.charAt(0)));
                    for (int i = firstDigit + 1; i <= 9; i++) {
                        possibilities.get(i).canBe.put(c, false);
                    }
                }
            }
        }
    }
}

class CharPossibilities {
    Map<Character, Boolean> canBe = new HashMap<>();
}