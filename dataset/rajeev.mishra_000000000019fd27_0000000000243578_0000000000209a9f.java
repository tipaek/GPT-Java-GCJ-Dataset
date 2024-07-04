
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.Stack;
import java.util.stream.Collectors;

public class Solution {
    public static void insertMatchingBraces(Stack<String> stack, int braces, int value) {
        int opening = braces;
        int closing = braces;
        while (opening>0) {
            stack.push("(");
            --opening;
        }

        stack.push(value+"");

        while (closing>0) {
            stack.push(")");
            --closing;
        }
    }

    public static void insertClosingBraces(Stack<String> stack, int braces, int value) {
        int closing = braces;
        stack.push(value+"");

        while (closing>0) {
            stack.push(")");
            --closing;
        }
    }

    public static void main(String[] args) {
        Scanner in = null;
        try {
            in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

            int noTestCases = in.nextInt();
            in.nextLine();
            for (int i = 0; i < noTestCases; i++) {
                String input = in.nextLine();
                Stack<String> stack = new Stack<>();
                int lastStackNum = 0;
                for (int j = 0; j < input.length() ; j++) {
                    String str = input.charAt(j)+"";
                    int num = Integer.parseInt(str);
                    if(stack.empty()) {
                        if(num !=0) {
                            insertMatchingBraces(stack, num, num);
                        } else{
                            stack.push(num+"");
                        }
                        lastStackNum = num;
                    } else {
                        if(num == 0) {
                            stack.push(num+"");
                            lastStackNum = num;
                            continue;
                        }

                        if(num < lastStackNum) {
                            int tempNum = num;
                            while (tempNum > 0) {
                                stack.pop();
                                --tempNum;
                            }

                            insertClosingBraces(stack, num, num);

                            lastStackNum = num;
                            continue;
                        }

                        int diff = Math.abs(lastStackNum - num);

                        int tempLastStackNum = lastStackNum;

                        while (tempLastStackNum > 0) {
                            stack.pop();
                            --tempLastStackNum;
                        }

                        insertMatchingBraces(stack, diff, num);

                        while (lastStackNum > 0) {
                            stack.push(")");
                            --lastStackNum;
                        }

                        lastStackNum = num;
                    }
                }
                String output = stack.stream().collect(Collectors.joining(""));

                System.out.println("Case #"+(i+1)+": "+output);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            in.close();
        }
    }
}
