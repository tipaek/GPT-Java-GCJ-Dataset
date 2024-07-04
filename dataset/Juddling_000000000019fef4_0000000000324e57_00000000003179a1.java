import java.io.*;
import java.util.*;

public class Solution {
    private static Scanner in;

    public static void main(String[] args) {
        Solution.in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();
        for (int caseNumber = 1; caseNumber <= t; caseNumber++) {
            int c = in.nextInt();
            StringBuilder key = new StringBuilder("%%%%%%%%%%");
            String[] codes = new String[10000];
            List<Set<Character>> possibleKeys = new ArrayList<>(10);
            possibleKeys.add(0, new HashSet<>());
            possibleKeys.add(1, new HashSet<>());
            possibleKeys.add(2, new HashSet<>());
            possibleKeys.add(3, new HashSet<>());
            possibleKeys.add(4, new HashSet<>());
            possibleKeys.add(5, new HashSet<>());
            possibleKeys.add(6, new HashSet<>());
            possibleKeys.add(7, new HashSet<>());
            possibleKeys.add(8, new HashSet<>());
            possibleKeys.add(9, new HashSet<>());

            for (int i = 0; i < 10000; i++) {
                String line = in.nextLine();
                if (line.length() <= 1) {
                    continue;
                }

                if (line.charAt(1) == ' ') {
//                    System.out.println(line);
                    String[] split = line.split(" ");
                    possibleKeys.get(Integer.parseInt(split[0])).add(split[1].charAt(0));
                }

                if (line.startsWith("10 ") && line.length() == 5) {
                    key.setCharAt(0, line.charAt(4));
//                    System.out.println(line);
                }

                codes[i] = line;
            }

//            for (char a : possibleKeys.get(3)) {
//                System.out.println(a);
//            }

            for (int i = 0; i <= 9; i++) {
                if (possibleKeys.get(i).size() == 1) {
                    Character[] answer = new Character[1];
                    possibleKeys.get(i).toArray(answer);
                    key.setCharAt(i, answer[0]);

                    for (Set<Character> poss : possibleKeys) {
                        poss.remove(answer[0]);
                    }
                }
            }

//            System.out.println(possibleKeys.get(3).size());
//            System.out.println(possibleKeys.get(4).size());
//            System.out.println(possibleKeys.get(5).size());

            System.out.println("Case #" + caseNumber + ": " + key.toString());
        }
    }
}
