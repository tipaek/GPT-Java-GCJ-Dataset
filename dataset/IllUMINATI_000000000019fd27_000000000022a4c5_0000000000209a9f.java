import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = Integer.parseInt(in.nextLine());
        for (int i = 1; i <= t; i++) {
            String input = in.nextLine();
            String s = nestingDepth(input);
            System.out.printf("Case #%d: %s\n", i, s);
        }
    }

    private static String nestingDepth(String input) {
        Map<String, String> lookUp = getConstantMap();
        int[] numbers = Arrays.stream(input.split(""))
                .mapToInt(Integer::parseInt)
                .toArray();
        StringBuilder output = new StringBuilder();
        int prev = 0;
        for (int i = 0; i < numbers.length; i++) {
            int curr = numbers[i];
            int diff = Math.abs(curr - prev);
            if (curr > prev) {
                output.append(lookUp.get(diff + "("));
            } else {
                output.append(lookUp.get(diff + ")"));
            }
            output.append(curr);
            prev = curr;
        }
        output.append(lookUp.get(prev + ")"));
        return output.toString();
    }

    private static Map<String, String> getConstantMap() {
        Map<String, String> hasMap = new HashMap<>();
        hasMap.put("0)", "");
        hasMap.put("1)", ")");
        hasMap.put("2)", "))");
        hasMap.put("3)", ")))");
        hasMap.put("4)", "))))");
        hasMap.put("5)", ")))))");
        hasMap.put("6)", "))))))");
        hasMap.put("7)", ")))))))");
        hasMap.put("8)", "))))))))");
        hasMap.put("9)", ")))))))))");
        hasMap.put("0(", "");
        hasMap.put("1(", "(");
        hasMap.put("2(", "((");
        hasMap.put("3(", "(((");
        hasMap.put("4(", "((((");
        hasMap.put("5(", "(((((");
        hasMap.put("6(", "((((((");
        hasMap.put("7(", "(((((((");
        hasMap.put("8(", "((((((((");
        hasMap.put("9(", "(((((((((");
        return hasMap;
    }

}
