import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int caseAmount = scanner.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        scanner.nextLine();
        for (int caseNumber = 1; caseNumber <= caseAmount; caseNumber++) {
            HashMap<Integer, List<Character>> map = new HashMap<>();
            List<String> chars = new ArrayList<>();
            for (int i = 1; i <= 10; i++) map.put(i, new ArrayList<>());
            int u = scanner.nextInt();
            for (int i = 1; i <= 10000; i++) {
//                System.out.println(i);
                int x = scanner.nextInt();
                String s = scanner.next();
                if (x <= 10) {
                    if (!chars.contains(s)) chars.add(s);
                    for (char c : s.toCharArray()) {
                        if (!map.get(x).contains(c))
                            map.get(x).add(c);
                    }
                }
            }
            for (int i = 1; i <= 10; i++) {
                for (int j = i + 1; j <= 10; j++) {
//                    System.out.println("i: " + i + " j: " + j);
                    map.get(j).remove(map.get(i).get(0));
                }
            }
            String out = "";
            for (int i = 1; i <= 10; i++) {
//                System.out.println(i);
                out += map.get(i).get(0);
            }
            System.out.println("Case #" + caseNumber + ": " + out);
        }

    }

}
