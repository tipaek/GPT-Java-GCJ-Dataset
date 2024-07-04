import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int numCases = Integer.parseInt(sc.nextLine());

        for (int index = 0; index < numCases; index++) {
            long[] qs = new long[10000];
            String[] strings = new String[10000];

            sc.nextLine(); // Read and discard the line

            for (int i = 0; i < 10000; i++) {
                String[] line = sc.nextLine().split(" ");
                qs[i] = Long.parseLong(line[0]);
                strings[i] = line[1];
            }

            boolean sadness = (qs[0] == -1);

            if (!sadness) {
                System.out.println("Case #" + (index + 1) + ": " + solve(qs, strings));
            } else {
                System.out.println("Case #" + (index + 1) + ": " + solveSadly(strings));
            }
        }
        sc.close();
    }

    private static String solve(long[] qs, String[] strings) {
        List<Integer> reference = new ArrayList<>(Collections.nCopies(10, 0));
        for (int i = 0; i < 10; i++) {
            reference.set(i, i);
        }

        Map<Character, Set<Integer>> chars = new HashMap<>();
        for (int i = 0; i < 10000; i++) {
            String s = strings[i];
            for (int j = 0; j < s.length(); j++) {
                chars.putIfAbsent(s.charAt(j), new HashSet<>(reference));
                if (chars.size() == 10) break;
            }
        }

        for (int i = 0; i < 10000; i++) {
            long m = qs[i];
            String s = strings[i];

            char c = s.charAt(0);
            Set<Integer> set = chars.get(c);
            set.remove(0);

            if (Long.toString(m).length() == s.length()) {
                for (int j = getMostSigDig(m) + 1; j < 10; j++) {
                    set.remove(j);
                }
            }
        }

        char[] ret = new char[10];
        for (Character c : chars.keySet()) {
            Set<Integer> s = chars.get(c);
            if (s.contains(0)) {
                ret[0] = c;
            } else {
                for (int i = 9; i > 0; i--) {
                    if (s.contains(i)) {
                        ret[i] = c;
                        break;
                    }
                }
            }
        }
        return new String(ret);
    }

    private static String solveSadly(String[] strings) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < 10000; i++) {
            String s = strings[i];
            for (int j = 0; j < s.length(); j++) {
                map.putIfAbsent(s.charAt(j), 0);
                if (map.size() == 10) break;
            }
        }

        for (int i = 0; i < 10000; i++) {
            String s = strings[i];
            if (s.length() == 16) {
                map.put(s.charAt(0), map.get(s.charAt(0)) + 1);
            }
        }

        List<Map.Entry<Character, Integer>> l = new ArrayList<>(map.entrySet());
        l.sort(new EntryComparator());

        char[] ret = new char[10];
        for (int i = 0; i < 10; i++) {
            ret[i] = l.get(i).getKey();
        }

        return new String(ret);
    }

    private static int getMostSigDig(long x) {
        while (x >= 10) {
            x /= 10;
        }
        return (int) x;
    }

    private static class EntryComparator implements Comparator<Map.Entry<Character, Integer>> {
        @Override
        public int compare(Map.Entry<Character, Integer> o1, Map.Entry<Character, Integer> o2) {
            return o1.getValue() - o2.getValue();
        }
    }
}