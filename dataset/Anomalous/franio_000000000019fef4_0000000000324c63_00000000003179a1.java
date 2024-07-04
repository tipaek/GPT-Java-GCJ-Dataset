import java.util.*;
import java.util.stream.Collectors;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        for (int i = 0; i < t; i++) {
            int U = scanner.nextInt();
            int max = Integer.parseInt(String.join("", Collections.nCopies(U, "9")));
            DString dString = new DString();
            for (int j = 0; j < 10000; j++) {
                int Q = scanner.nextInt();
                String R = scanner.next();
                if (Q == -1) {
                    dString.add(R, max);
                }
                dString.add(R, Q);
            }
            String s = dString.hasAll();
            printResult(i, s);
        }
        scanner.close();
    }

    private static void printResult(int caseNumber, String result) {
        System.out.println("Case #" + (caseNumber + 1) + ": " + result);
    }
}

class DString {
    private final Map<Integer, MyChar> possibilities = new HashMap<>();
    private final Set<Character> allChars = new HashSet<>();

    DString() {
        for (int i = 0; i <= 9; i++) {
            possibilities.put(i, new MyChar());
        }
    }

    public String hasAll() {
        char[] resultArray = new char[10];
        while (!allChars.isEmpty()) {
            for (int i = 0; i < 10; i++) {
                MyChar myChar = possibilities.get(i);
                if (myChar.canBe.size() + 1 == allChars.size()) {
                    char foundChar = 0;
                    for (char c : allChars) {
                        if (!myChar.canBe.containsKey(c)) {
                            resultArray[i] = c;
                            foundChar = c;
                            break;
                        }
                    }
                    if (foundChar != 0) {
                        allChars.remove(foundChar);
                    }
                }
            }
        }
        return new String(resultArray);
    }

    public void add(String R, int Q) {
        String qString = Integer.toString(Q);
        boolean isFirstChar = true;
        for (char c : R.toCharArray()) {
            if (allChars.size() < 10) {
                allChars.add(c);
            }
            if (isFirstChar) {
                possibilities.get(0).canBe.put(c, false);
                isFirstChar = false;
                if (R.length() == qString.length()) {
                    int startIndex = Integer.parseInt(String.valueOf(qString.charAt(0))) + 1;
                    for (int i = startIndex; i <= 9; i++) {
                        possibilities.get(i).canBe.put(c, false);
                    }
                }
            }
        }
    }
}

class MyChar {
    Map<Character, Boolean> canBe = new HashMap<>();
}