import java.math.BigInteger;
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

        HashMap<Character, BigInteger> countLetters = new HashMap<>();

        for(int i = 0; i < size; i++) {
            String[] in = sc.nextLine().split(" ");
            int M = Integer.parseInt(in[0]);
            String R = in[1];


            for (int j = 0; j < R.length(); j++) {
                char c = R.charAt(j);
                if (!countLetters.containsKey(c)) {
                    countLetters.put(c, new BigInteger("0"));
                }

                BigInteger probAddition = new BigInteger(Integer.toString(((int) Math.pow(10d, U) /  (int) Math.pow(10d, j))));

                countLetters.put(c, countLetters.get(c).add(probAddition));
            }
        }


        LinkedList<Character> l = countLetters.entrySet().stream()
                .sorted(Comparator.comparing(entry -> entry.getValue(), (i1, i2) -> i1.compareTo(i2)))
                .map(entry -> entry.getKey())
                .collect(Collectors.toCollection(LinkedList::new));

        Character zero = l.pollFirst();
        l.addLast(zero);

        StringBuilder sb = new StringBuilder();
        l.forEach(c -> sb.append(c));

        System.out.println("Case #" + Integer.toString(caseNumber) + ": " + sb.reverse().toString());

    }
}
