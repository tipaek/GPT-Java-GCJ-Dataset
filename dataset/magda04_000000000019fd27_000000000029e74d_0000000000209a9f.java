import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

        int numOfTestCases = Integer.parseInt(scanner.nextLine());
        List<NumWithParenthesis> numbers = new ArrayList<>();

        for (int i = 0; i < numOfTestCases; i++) {
            numbers.add(new NumWithParenthesis(scanner.nextLine()));
        }

        for (int i = 0; i < numOfTestCases; i++) {
            System.out.printf("Case #%d: %s\n", i + 1, numbers.get(i).findParenthesis());
        }
    }

    private static class NumWithParenthesis {
        String originalNum;

        NumWithParenthesis(String originalNum) {
            this.originalNum = originalNum;
        }

        String findParenthesis() {
            char[] chars = this.originalNum.toCharArray();
            int[] nums = new int[chars.length];
            for (int i = 0; i < chars.length; i++) {
                nums[i] = Integer.parseInt(String.valueOf(chars[i]));
            }

            Map<Integer, Map<String, Integer>> parenthesisCounter = new HashMap<>();
            for (int i = 1; i < 10; i++) {
                parenthesisCounter.put(1, new HashMap<String, Integer>() {
                    {
                        put("left", 0);
                        put("right", 0);
                    }
                });
            }


            StringBuilder builder = new StringBuilder();

            for (int i = 1; i < nums.length; i++) {
                if (nums[i - 1] == 0) {
                    builder.append(chars[i - 1]);
                } else {
                    int currentCounterLeft = parenthesisCounter.get(nums[i - 1]).get("left");
                    if (currentCounterLeft != nums[i - 1]) {
                            builder.append("(");
                            parenthesisCounter.get(nums[i - 1]).put("left", currentCounterLeft+1);
                    }
                    builder.append(nums[i - 1]);

                    if (nums[i - 1] != nums[i]) {
                        builder.append(")");
                        int currentCounterRight = parenthesisCounter.get(nums[i - 1]).get("right");
                        parenthesisCounter.get(nums[i - 1]).put("right", currentCounterRight+1);

                        // are parenthesis closed? If so, then make them zero
                        if (parenthesisCounter.get(nums[i - 1]).get("right")
                                == parenthesisCounter.get(nums[i - 1]).get("left")) {
                            parenthesisCounter.get(nums[i - 1]).put("left", 0);
                            parenthesisCounter.get(nums[i - 1]).put("right", 0);
                        }
                    }
                }
            }

            int lastNumber = nums[nums.length - 1];
            if (lastNumber != 0) {
                int currentCounterLeft = parenthesisCounter.get(lastNumber).get("left");
                if (currentCounterLeft < lastNumber) {
                    builder.append("(");
                    currentCounterLeft++;
                }

                builder.append(lastNumber);

                int currentCounterRight = parenthesisCounter.get(lastNumber).get("right");
                if (currentCounterRight < currentCounterLeft) {
                    for (int i = 0; i < currentCounterLeft - currentCounterRight; i++) {
                        builder.append(")");
                    }
                }
            } else {
                builder.append(lastNumber);
            }

            return builder.toString();
        }
    }
}