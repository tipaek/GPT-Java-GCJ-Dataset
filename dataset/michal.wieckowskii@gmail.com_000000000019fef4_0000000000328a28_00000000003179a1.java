import java.util.*;
import java.io.*;
public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = Integer.parseInt(in.nextLine());  // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= t; ++i) {
            final String solution = solveCase(in);
            System.out.println("Case #" + i + ": " + solution);
        }
    }

    private static String solveCase(Scanner in) {
        boolean minusQGuard = false;
        int u = Integer.parseInt(in.nextLine());
        Set<String> lettersSet = new HashSet<>();
        Map<String, Integer> lettersPos = new HashMap<>();
        for(int i=0;i<=9999;i++) {
            String[] values = in.nextLine().split(" ");
            if(values[0].length() != values[1].length()) {
                continue;
            }
            int valueInt = Integer.parseInt(Character.toString(values[0].charAt(0)));
            if(valueInt == -1) {
                valueInt = (int) Math.pow(10,u)-1;
                minusQGuard = true;
            }
            String letter = Character.toString(values[1].charAt(0));

            Integer min = lettersPos.get(letter);
            if(min == null || min > valueInt) {
                lettersPos.put(letter,valueInt);
            }

            for(String character:values[1].split("")) {
                lettersSet.add(character);
            }

        }

        String[] answer = new String[10];

        if(!minusQGuard){
            for(String letter:lettersPos.keySet()) {
                answer[lettersPos.get(letter)] = letter;
            }
        }else{
            int i=1;
            for(String letter:lettersPos.keySet()) {
                answer[i] = letter;
                i++;
            }
        }

        lettersSet.removeAll(Arrays.asList(answer));
        answer[0]=lettersSet.iterator().next();
        StringJoiner sj = new StringJoiner("");
        Arrays.asList(answer).forEach(sj::add);
        return sj.toString();
    }
}