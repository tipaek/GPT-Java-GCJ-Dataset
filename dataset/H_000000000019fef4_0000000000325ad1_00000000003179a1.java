import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        HashMap<Character, boolean[]> digitRange = new HashMap<>(10);

        int tests = sc.nextInt();

        for (int t = 1; t <= tests; t++) {
            int u = sc.nextInt();
            sc.nextLine();

            for (int q = 1; q <= 10000; q++) {
                long m = sc.nextLong();
                String r = sc.next();
                sc.nextLine();

                /* Discover characters */
                for (int i = 0; digitRange.size() < 10 && i < r.length(); i++) {
                    if (!digitRange.containsKey(r.charAt(i))) {
                        boolean[] range = new boolean[10];
                        Arrays.fill(range, true);

                        digitRange.put(r.charAt(i), range);
                    }
                }

                if (m == -1) continue;

                String mStr = Long.toString(m);
                if (mStr.length() != r.length()) continue;

                /* Exclude ranges of most significant digit's range */
                boolean[] msdRange = digitRange.get(r.charAt(0));

                msdRange[0] = false;
                for (int i = (mStr.charAt(0) - '0') + 1; i <= 9; i++) {
                    msdRange[i] = false;
                }
            }

            HashMap<Integer, Character> mapIC = new HashMap<>(10);
            HashMap<Character, Integer> mapCI = new HashMap<>(10);

            boolean change;
            do {
                change = false;

                for (Map.Entry<Character, boolean[]> range : digitRange.entrySet()) {
                    if (mapCI.containsKey(range.getKey())) continue;

                    int trueCounter = 0;
                    int trueDigit = -1;
                    for (int i = 0; i < range.getValue().length; i++) {
                        if (mapIC.containsKey(i)) {
                            if (range.getValue()[i]) {
                                range.getValue()[i] = false;
                                change = true;
                            }
                        }

                        if (range.getValue()[i]) {
                            trueCounter++;
                            trueDigit = i;
                        }
                    }

                    if (trueCounter == 1) {// Deduced a digit
                        mapCI.put(range.getKey(), trueDigit);
                        mapIC.put(trueDigit, range.getKey());
                        change = true;
                    }
                }
            } while (change);


            System.out.print("Case #" + t + ": ");
            if (mapIC.size() < 10) {
                System.out.print("IMPOSSIBLE");
            } else {
                for (int i = 0; i <= 9; i++) {
                    System.out.print(mapIC.get(i));
                }
            }
            System.out.println();
        }
    }

}
