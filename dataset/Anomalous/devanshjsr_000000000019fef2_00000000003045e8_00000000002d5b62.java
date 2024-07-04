import java.util.ArrayList;
import java.util.Scanner;

public class Solution {
    // DO NOT MODIFY THE ARGUMENTS WITH "final" PREFIX. IT IS READ ONLY

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        int caseNumber = 1;

        while (t > 0) {
            long x = sc.nextLong();
            long y = sc.nextLong();

            long absX = Math.abs(x);
            long absY = Math.abs(y);

            long max = Math.max(2 * absX, 2 * absY);

            ArrayList<Long> a1 = new ArrayList<>();
            ArrayList<Long> a2 = new ArrayList<>();
            ArrayList<Long> a3 = new ArrayList<>();

            for (long i = 0; Math.pow(2, i) <= max; i++) {
                long value = (long) Math.pow(2, i);
                a2.add(value);
                a1.add(value + 1);
                a3.add(2 * value - 1);
            }

            if ((!a2.contains(absX) && !a2.contains(absY)) || absX == 0 || absY == 0) {
                handleImpossibleCases(caseNumber, absX, absY, x, y, a3);
            } else {
                handlePossibleCases(caseNumber, absX, absY, x, y, a1, a2, a3);
            }

            t--;
            caseNumber++;
        }
    }

    private static void handleImpossibleCases(int caseNumber, long absX, long absY, long x, long y, ArrayList<Long> a3) {
        StringBuilder s = new StringBuilder();
        if (absX == 0 && !a3.contains(absY)) {
            System.out.println("Case #" + caseNumber + ": IMPOSSIBLE");
        } else if (absY != 0) {
            if (y < 0) {
                int index = a3.indexOf(absY);
                for (int i = 0; i <= index; i++) {
                    s.append("S");
                }
                System.out.println("Case #" + caseNumber + ": " + s);
            } else {
                int index = a3.indexOf(absY);
                for (int i = 0; i <= index; i++) {
                    s.append("N");
                }
                System.out.println("Case #" + caseNumber + ": " + s);
            }
        }

        if (absY == 0 && !a3.contains(absX)) {
            System.out.println("Case #" + caseNumber + ": IMPOSSIBLE");
        } else if (absX != 0) {
            if (x < 0) {
                int index = a3.indexOf(absX);
                for (int i = 0; i <= index; i++) {
                    s.append("W");
                }
                System.out.println("Case #" + caseNumber + ": " + s);
            } else {
                int index = a3.indexOf(absX);
                for (int i = 0; i <= index; i++) {
                    s.append("E");
                }
                System.out.println("Case #" + caseNumber + ": " + s);
            }
        }
    }

    private static void handlePossibleCases(int caseNumber, long absX, long absY, long x, long y, ArrayList<Long> a1, ArrayList<Long> a2, ArrayList<Long> a3) {
        StringBuilder s = new StringBuilder();
        if (a2.contains(absX)) {
            int index = a2.indexOf(absX);
            if (absY == a1.get(index)) {
                if (y < 0) {
                    for (int i = 0; i < index; i++) {
                        s.append("N");
                    }
                    s.append(x < 0 ? "WS" : "ES");
                    System.out.println("Case #" + caseNumber + ": " + s);
                } else {
                    for (int i = 0; i < index; i++) {
                        s.append("S");
                    }
                    s.append(x < 0 ? "WN" : "EN");
                    System.out.println("Case #" + caseNumber + ": " + s);
                }
            } else {
                handleAlternativeCases(caseNumber, absX, absY, x, y, a3, index, s);
            }
        } else if (a2.contains(absY)) {
            int index = a2.indexOf(absY);
            if (absX == a1.get(index)) {
                if (x < 0) {
                    for (int i = 0; i < index; i++) {
                        s.append("E");
                    }
                    s.append(y < 0 ? "SW" : "NW");
                    System.out.println("Case #" + caseNumber + ": " + s);
                } else {
                    for (int i = 0; i < index; i++) {
                        s.append("W");
                    }
                    s.append(y < 0 ? "SE" : "NE");
                    System.out.println("Case #" + caseNumber + ": " + s);
                }
            } else {
                handleAlternativeCases(caseNumber, absX, absY, x, y, a3, index, s);
            }
        } else {
            System.out.println("Case #" + caseNumber + ": IMPOSSIBLE");
        }
    }

    private static void handleAlternativeCases(int caseNumber, long absX, long absY, long x, long y, ArrayList<Long> a3, int index, StringBuilder s) {
        if (index - 1 > 0) {
            if (absY == a3.get(index - 1)) {
                if (y < 0) {
                    for (int i = 0; i <= index; i++) {
                        s.append("S");
                    }
                    s.append(x < 0 ? "W" : "E");
                    System.out.println("Case #" + caseNumber + ": " + s);
                } else {
                    for (int i = 0; i <= index; i++) {
                        s.append("N");
                    }
                    s.append(x < 0 ? "W" : "E");
                    System.out.println("Case #" + caseNumber + ": " + s);
                }
            }
        } else {
            System.out.println("Case #" + caseNumber + ": IMPOSSIBLE");
        }
    }
}