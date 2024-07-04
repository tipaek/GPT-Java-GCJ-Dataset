import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
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

            Map<Character, Integer> map = new HashMap<>();
            Set<Character> allChars = new HashSet<>();

            for (int inputIndex = 1; inputIndex <= 10000; inputIndex++) {
                int request = in.nextInt();
                String reqStr = String.valueOf(request);
                String answer = in.next();

                char firstChar = answer.charAt(0);
                allChars.add(firstChar);
                allChars.add(answer.charAt(answer.length() - 1));

                if (answer.length() == reqStr.length()) {
                    int firstDigit = Integer.parseInt(String.valueOf(reqStr.charAt(0)));
                    if (!map.containsKey(firstChar)) {
                        map.put(firstChar, firstDigit);
                    } else if (map.get(firstChar) > firstDigit) {
                        map.put(firstChar, firstDigit);
                    }
                }
            }

            List<Character> chars = new ArrayList<>(10);
            for (int i = 0; i < 10; i++) {
                chars.add(' ');
            }

            for (Character c : map.keySet()) {
                Integer index = map.get(c);
                allChars.remove(c);
                chars.set(index, c);
            }
            chars.set(0, allChars.iterator().next());

            String result = chars.stream().map(x -> x + "").collect(Collectors.joining());
            System.out.println(String.format("Case #%s: %s", caseIndex, result));
        }
    }


}