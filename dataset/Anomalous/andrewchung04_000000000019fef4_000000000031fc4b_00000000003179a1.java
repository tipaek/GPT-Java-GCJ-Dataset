import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();

        for (int i = 0; i < t; i++) {
            int u = scanner.nextInt();
            boolean[][] ar = new boolean[10][10];
            Map<Character, Integer> map = new HashMap<>();
            Map<Integer, Character> reverse = new HashMap<>();
            String[] lonerFinder = new String[10000];
            int index = 0;

            for (int j = 0; j < 10000; j++) {
                String num = scanner.next();
                String str = scanner.next();
                lonerFinder[j] = str;

                if (num.length() == str.length()) {
                    map.computeIfAbsent(str.charAt(0), k -> {
                        reverse.put(index, k);
                        return index++;
                    });
                    int work = map.get(str.charAt(0));
                    for (int k = (num.charAt(0) - '0') + 1; k < 10; k++) {
                        ar[work][k] = true;
                    }
                }
            }

            Character loner = findLoner(map, lonerFinder);

            char[] ans = new char[10];
            List<Character>[] possible = initializePossibleList();

            populatePossibleList(ar, reverse, possible);

            int count = 0;

            while (count != 8) {
                List<Character> recent = new ArrayList<>();
                for (int j = 0; j < possible.length; j++) {
                    if (possible[j].size() == 1) {
                        count++;
                        recent.add(possible[j].get(0));
                        ans[j] = possible[j].get(0);
                    }
                }

                removeRecentFromPossible(possible, recent);
            }

            finalizeAnswer(possible, ans, loner);

            String result = new String(ans);
            System.out.println("Case #" + (i + 1) + ": " + result);
        }
    }

    private static Character findLoner(Map<Character, Integer> map, String[] lonerFinder) {
        for (String cur : lonerFinder) {
            for (int k = 0; k < cur.length(); k++) {
                if (!map.containsKey(cur.charAt(k))) {
                    return cur.charAt(k);
                }
            }
        }
        return '1';
    }

    private static List<Character>[] initializePossibleList() {
        List<Character>[] possible = new ArrayList[10];
        for (int j = 0; j < possible.length; j++) {
            possible[j] = new ArrayList<>();
        }
        return possible;
    }

    private static void populatePossibleList(boolean[][] ar, Map<Integer, Character> reverse, List<Character>[] possible) {
        for (int j = 0; j < 10; j++) {
            for (int k = 0; k < 10; k++) {
                if (!ar[j][k] && reverse.get(j) != null) {
                    possible[k].add(reverse.get(j));
                }
            }
        }
    }

    private static void removeRecentFromPossible(List<Character>[] possible, List<Character> recent) {
        for (List<Character> characters : possible) {
            characters.removeIf(recent::contains);
        }
    }

    private static void finalizeAnswer(List<Character>[] possible, char[] ans, Character loner) {
        for (int j = possible.length - 1; j >= 0; j--) {
            if (possible[j].size() == 1) {
                ans[j] = possible[j].get(0);
                possible[j].clear();
                break;
            }
        }

        for (int j = 0; j < possible.length; j++) {
            if (possible[j].size() == 1) {
                ans[j] = loner;
            }
        }
    }
}