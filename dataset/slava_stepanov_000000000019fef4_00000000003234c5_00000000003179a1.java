import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

public class Solution {

    public static void main(String[] args) throws Exception {

        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int caseNum = in.nextInt();

        for (int caseIndex = 1; caseIndex <= caseNum; caseIndex++) {
            int base = in.nextInt();

            Map<Character, List<Integer>> map = new HashMap<>();
            Set<Character> allChars = new HashSet<>();

            for (int inputIndex = 1; inputIndex <= 10000; inputIndex++) {
                long request = in.nextLong();
                String answer = in.next();

                for (int i = 0; i < answer.length(); i++) {
                    allChars.add(answer.charAt(i));
                }

                if (!map.containsKey(answer.charAt(0))) {
                    ArrayList<Integer> list = new ArrayList<>();
                    for (int j = 0; j < 10; j++) {
                        list.add(0);
                    }
                    map.put(answer.charAt(0), list);
                }
                List<Integer> arr = map.get(answer.charAt(0));
                arr.set(0, arr.get(0) + 1);
            }

            final int digit = 0;
            String str = map.entrySet().stream()
                    .sorted((o1, o2) -> Integer.compare(o2.getValue().get(digit), o1.getValue().get(digit)))
                    .map(x -> "" + x.getKey())
                    .collect(Collectors.joining());

            allChars.removeAll(map.keySet());
            String result = allChars.iterator().next() + str;


            System.out.println(String.format("Case #%s: %s", caseIndex, result));
        }
    }

}