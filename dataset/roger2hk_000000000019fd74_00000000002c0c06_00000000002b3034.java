public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.

        for (int i = 1; i <= t; ++i) {
            int numOfPatterns = in.nextInt();

            Map<String, Integer> names = new HashMap<>();
            for (int j = 0; j < numOfPatterns; j++) {
                names.put(new StringBuilder(in.next()).reverse().toString(), 0);
            }

            StringBuilder sb = new StringBuilder();
            while (!names.isEmpty()) {
                Character targetC = null;
                for (Map.Entry<String, Integer> entry : names.entrySet()) {
                    Character currentC = entry.getKey().charAt(entry.getValue());
                    if (currentC == '*') {
                        continue;
                    }

                    if (targetC == null) {
                        targetC = currentC;
                    } else if (targetC != currentC) {
                        sb = new StringBuilder().append("*");
                        break;
                    }
                }

                if (targetC != null) {
                    sb.append(targetC);

                    for (Map.Entry<String, Integer> entry : names.entrySet()) {
                        int max = entry.getKey().length() - 1;

                        if (entry.getValue() < max) {
                            if (entry.getKey().charAt(entry.getValue()) == '*') {
                                if (entry.getKey().charAt(entry.getValue() + 1) == targetC) {
                                    entry.setValue(entry.getValue() + 1);
                                }
                            }

                            entry.setValue(entry.getValue() + 1);
                        }
                    }
                } else {
                    break;
                }

                if (isEnd(names)) {
                    break;
                }
            }

            System.out.println("Case #" + i + ": " + sb.reverse().toString());
        }
    }

    private static boolean isEnd(Map<String, Integer> names) {
        for (Map.Entry<String, Integer> entry : names.entrySet()) {
            if (entry.getKey().length() != entry.getValue()) {
                return false;
            }
        }

        return true;
    }
}