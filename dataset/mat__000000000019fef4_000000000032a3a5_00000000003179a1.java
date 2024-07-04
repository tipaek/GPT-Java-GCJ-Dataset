import java.util.*;

public class Solution {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int i = 1; i <= t; i++) {

            List<Long> list = new ArrayList<>();
            Map<Long, Set<String>> map = new HashMap<>();

            int u = in.nextInt();
            for (int j = 0; j < 10000; j++) {

                long m = in.nextLong();
                String r = in.next();
                list.add(m);

                if (map.get(m) != null) {
                    Set<String> set = map.get(m);
                    set.add(r);
                    map.put(m, set);
                } else {
                    Set<String> set = new HashSet<>();
                    set.add(r);
                    map.put(m, set);
                }
            }


            String output = findRandom(list, map);

            System.out.println("Case #" + i + ": " + output);

        }
    }

    static String findRandom(List<Long> list, Map<Long, Set<String>> map) {

        Collections.sort(list);
        Map<Integer, Character> solution = new HashMap<>();
        Map<Character, Set<Integer>> options = new HashMap<>();
        Set<Character> globalSet = new HashSet<>();
        int nextNumber = 0;

        for (long l : list) {

            Set<String> set = map.get(l);
            for (String s : set) {

                for (int k = 0; k < s.length(); k++) {
                    globalSet.add(s.charAt(k));
                }

                if (s.length() == String.valueOf(l).length()) {
//                    for (int i = 0; i < s.length(); i++) {
                    int i = 0;
                    int number = String.valueOf(l).charAt(i) - 48;
                    Character character = s.charAt(i);

                    if (options.get(character) != null) {
                        Set<Integer> tmpSet = options.get(character);

                        for (int j = number + 1; j < 10; j++) {
                            tmpSet.remove(j);
                        }
                        if (s.length() > 1) {
                            tmpSet.remove(0);
                        }

                        options.put(character, tmpSet);

                        if (tmpSet.size() == 1) {
                            solution.put(tmpSet.iterator().next(), character);
                            options.remove(character);
                            updateOptions(options, solution, globalSet);
                        }
                    } else {
                        Set<Integer> optionsSet = new HashSet<>();
                        for (int j = 0; j <= number; j++) {
                            optionsSet.add(j);
                        }
                        options.put(character, optionsSet);

                        if (optionsSet.size() == 1) {
                            solution.put(optionsSet.iterator().next(), character);
                            options.remove(character);
                            updateOptions(options, solution, globalSet);
                        }
                    }
//                    }
                }
            }
        }

        // check if there are single numbers

//        options.forEach((k, v) -> System.out.println(k + " " + v));
//
//        solution.forEach((k, v) -> System.out.println(k + " " + v));

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < 10; i++) {
            sb.append(solution.get(i));
        }

        return sb.toString();

    }

    static void updateOptions(Map<Character, Set<Integer>> options, Map<Integer, Character> solution, Set<Character> globalSet) {

        List<Integer> list = new ArrayList<>();

        solution.forEach((k, v) -> list.add(k));

        boolean change = true;

        while (change) {

            change = false;

            for (Character k : options.keySet()) {

                Set<Integer> set = options.get(k);
                if (set.size() > 1) {
                    for (int i : list) {
                        set.remove(i);
                    }

                    if (set.size() == 1) {
                        change = true;
                        list.add(set.iterator().next());
                        solution.put(set.iterator().next(), k);
                    }
                }
            }


            if (solution.size() == 9) {
                solution.forEach((k, v) -> globalSet.remove(v));

                for (int i = 0; i < 10; i++) {
                    if (solution.get(i) == null) {
                        solution.put(i, globalSet.iterator().next());
                    }
                }
            }

        }
    }


}

