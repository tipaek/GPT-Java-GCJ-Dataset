import java.util.*;
import java.io.*;
import java.util.stream.Collectors;

public class Solution {
    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        solve(in);
    }

    public static void solve(Scanner sc) throws Exception {
        int t = Integer.parseInt(sc.nextLine());
        for (int i = 1; i <= t; ++i) {
            doCase(sc, i);
        }
    }

    private static void doCase(Scanner sc, int caseNumber) throws Exception {
        int U = Integer.parseInt(sc.nextLine());
        int size = 10000;

        HashMap<Character, Double> countLetters = new HashMap<>();

        for(int i = 0; i < size; i++) {
            String[] in = sc.nextLine().split(" ");
            int M = Integer.parseInt(in[0]);
            String R = in[1];


            for (int j = 0; j < R.length(); j++) {
                char c = R.charAt(j);
                if (!countLetters.containsKey(c)) {
                    countLetters.put(c, 0d);
                }

                double probAddition = Math.pow(10d, U) /  Math.pow(10d, j);

                countLetters.put(c, countLetters.get(c) + probAddition);
            }
        }


        LinkedList<Character> l = countLetters.entrySet().stream()
                .sorted(Comparator.comparingDouble(entry -> entry.getValue()))
                .map(entry -> entry.getKey())
                .collect(Collectors.toCollection(LinkedList::new));

        Character zero = l.pollFirst();
        l.addLast(zero);

        StringBuilder sb = new StringBuilder();
        l.forEach(c -> sb.append(c));

        System.out.println("Case #" + Integer.toString(caseNumber) + ": " + sb.reverse().toString());

    }
}
