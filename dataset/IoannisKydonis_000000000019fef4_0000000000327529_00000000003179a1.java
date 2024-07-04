import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();
        for (int i = 1; i <= t; i++) {
            int u = in.nextInt();

            Map<Integer, Set<Character>> map = new HashMap<>();
            for (int j = 0; j < 10; j++) {
                Set<Character> set = new HashSet<>();
                for (char c = 'A'; c <= 'Z'; c++) {
                    set.add(c);
                }
                map.put(j, set);
            }
            Set<Character> usedChars = new HashSet<>();

            List<Entry> list = new ArrayList<>(10000);

            for (int j = 0; j < 10000; j++) {
                long m = in.nextLong();
                String r = in.nextLine().trim();
                list.add(new Entry(m, r));
                handleZeroIndex(r, map);
                handleMSingleDigit(r, m, map);
                addUsedChars(r, usedChars);
                if (usedChars.size() == 10) {
                    keepUsedChars(usedChars, map);
                }
                handleFinalizedValue(map);
            }
            keepUsedChars(usedChars, map);

            while (!checkIfFinalized(map)) {
                for (Entry e : list) {
                    long m = e.m;
                    String r = e.r;
                    handleZeroIndex(r, map);
                    handleMSingleDigit(r, m, map);
                    addUsedChars(r, usedChars);
                    if (usedChars.size() == 10) {
                        keepUsedChars(usedChars, map);
                    }
                    handleFinalizedValue(map);
                }
                keepUsedChars(usedChars, map);
            }

            System.out.println("Case #" + i + ": " + getResult(map));
        }
    }

    private static void keepUsedChars(Set<Character> used, Map<Integer, Set<Character>> map) {
        for (int i = 0; i < 10; i++) {
            map.get(i).retainAll(used);
        }
    }

    private static void addUsedChars(String r, Set<Character> set) {
        for (char c : r.toCharArray()) {
            set.add(c);
        }
    }

    private static void handleMSingleDigit(String r, long m, Map<Integer, Set<Character>> map) {
        if (m / 10 == 0) {
            int mVal = (int) m;
            for (int i = mVal + 1; i <= 9; i++) {
                map.get(i).remove(r.charAt(0));
            }

            int index = -1;
            for (int i = 1; i <= mVal; i++) {
                if (map.get(i).size() != 1) {
                    if (index == -1) {
                        index = i;
                    } else {
                        index = -1;
                        break;
                    }
                }
            }
            if (index != -1) {
                Set<Character> newSet = new HashSet<>();
                newSet.add(r.charAt(0));
                map.remove(index);
                map.put(index, newSet);
            }
        }
    }

    private static void handleZeroIndex(String r, Map<Integer, Set<Character>> map) {
        Set<Character> set = map.get(0);
        set.remove(r.charAt(0));
        if (set.size() == 1)
            handleFinalizedValue(map);
    }

    private static void handleFinalizedValue(Map<Integer, Set<Character>> map) {
        boolean flag;
        do {
            flag = false;
            for (int i = 0; i < 10; i++) {
                Set<Character> set = map.get(i);
                if (set.size() == 1) {
                    Character c = set.iterator().next();
                    for (int j = 0; j < 10; j++) {
                        if (i == j) continue;
                        if (map.get(j).contains(c)) {
                            map.get(j).remove(c);
                            if (map.get(j).size() == 1)
                                flag = true;
                        }
                    }
                }
            }
        } while (flag);
    }

    private static boolean checkIfFinalized(Map<Integer, Set<Character>> map) {
        return map.values().stream().allMatch(set -> set.size() == 1);
    }

    private static String getResult(Map<Integer, Set<Character>> map) {
        StringBuilder sb = new StringBuilder(10);
        for (int i = 0; i < 10; i++) {
            sb.append(map.get(i).iterator().next());
        }
        return sb.toString();
    }

    private static class Entry {
        long m;
        String r;

        Entry(long m, String r) {
            this.m = m;
            this.r = r;
        }
    }
}
