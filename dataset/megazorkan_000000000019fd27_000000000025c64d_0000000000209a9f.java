import java.util.*;
import java.io.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.
        in.nextLine();
        for (int i = 1; i <= t; ++i) {

            String str = in.nextLine();

            List<String> divided = new ArrayList<>();

            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < str.length(); j++) {

                if (str.charAt(j) == '0') {
                    if (sb.length() > 0) {
                        divided.add(sb.toString());
                        sb.setLength(0);
                    }
                    divided.add("0");
                }
                else {
                    sb.append(str.charAt(j));
                }
            }

            if(sb.length() > 0) {
                divided.add(sb.toString());
            }

            StringBuilder sol = new StringBuilder();

            for (String s: divided) {
                if (s.equals("0")) {
                    sol.append("0");
                }
                else {
                    int minVal = Integer.MAX_VALUE;
                    int maxVal = Integer.MIN_VALUE;

                    for (Character c : s.toCharArray()) {
                        minVal = Math.min(minVal, Character.getNumericValue(c));
                        maxVal = Math.max(maxVal, Character.getNumericValue(c));
                    }

                    sol.append(IntStream.range(0, minVal).mapToObj(x -> "(").collect( Collectors.joining("")));
                    for (Character c : s.toCharArray()) {
                        int num = Character.getNumericValue(c);

                        sol.append(IntStream.range(0, num-minVal).mapToObj(x -> "(").collect( Collectors.joining("")));
                        sol.append(num);
                        sol.append(IntStream.range(0, num-minVal).mapToObj(x -> ")").collect( Collectors.joining("")));
                    }

                    sol.append(IntStream.range(0, minVal).mapToObj(x -> ")").collect( Collectors.joining("")));
                }
            }


            System.out.println("Case #" + i + ": " + sol.toString());
        }
    }
}
