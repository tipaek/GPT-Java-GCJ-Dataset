import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        try {
        Scanner sc = new Scanner(System.in);
        int caseNum = Integer.valueOf(sc.nextLine());
        List<char[]> nums = new ArrayList(caseNum);
        for (int i = 0; i < caseNum; i++) {
            nums.add(sc.nextLine().toCharArray());
        }
        for (int i = 0; i < caseNum; i++) {
            char[] result = addParentheses(nums.get(i));

            System.out.println("Case #" + (i + 1) + ": " + new String(result));
        }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static char[] addParentheses(char[] nums) {
        char[] result = new char[100];
        int lastNum = -1;
        int lastLength = 0;
        int lastNumIndex = 0;
        for (char c : nums) {
            int num = c - '0';
            if (lastNum == -1) {
                if (num == 0) {
                    result[lastLength++] = c;
                    lastNum = 0;
                    lastNumIndex = 0;
                    continue;
                }
                for (int i = 0; i < num; i++) {
                    result[i] = '(';
                    result[i + num + 1] = ')';
                }
                result[num] = c;
                lastLength = num * 2 + 1;
                lastNum = num;
                lastNumIndex = num;
            } else {
                if (lastNum > num) {
                    int newIndex = lastLength - num;
                    result[newIndex] = c;
                    for (int i = 0; i < num; i++) {
                        result[newIndex + 1 + i] = ')';
                    }
                    lastLength++;
                    lastNum = num;
                    lastNumIndex = newIndex;
                    continue;
                }
                if (lastNum < num) {
                    int xz = num - lastNum;
                    for (int i = 0; i < xz; i++) {
                        result[lastNumIndex + i + 1] = '(';
                    }
                    int newIndex = lastNumIndex + xz + 1;
                    result[newIndex] = c;
                    for (int i = 0; i < num; i++) {
                        result[newIndex + i + 1] = ')';
                    }
                    lastNumIndex = newIndex;
                    lastLength = newIndex + num + 1;
                    lastNum = num;
                    continue;
                }
                if (lastNum == num) {
                    int newIndex = lastNumIndex + 1;
                    result[newIndex] = c;
                    if (num != 0) {
                        result[lastLength] = ')';
                    }
                    lastNum = num;
                    lastLength = lastLength + 1;
                    lastNumIndex = newIndex;
                    continue;
                }
            }
        }
        return Arrays.copyOf(result, lastLength);
    }

    static void printCase(List<char[]> nums) {
        nums.stream().forEach(num -> {
            for (int i = 0; i < num.length; i++) {
                System.out.print(num[i] + " ");
            }
            System.out.println("");
        });
    }
}
