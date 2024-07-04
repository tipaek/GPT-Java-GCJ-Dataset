import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;
import java.util.Stack;

public class Solution {

        public static void main(String[] args) throws FileNotFoundException {
            //Scanner sc = new Scanner(System.in);
            Scanner sc = new Scanner(new FileReader("src/bracket.txt"));
            int T = Integer.parseInt(sc.next());
            String[] strings = new String[T];
            for(int t = 0; t < T; ++t) {
              strings[t] = sc.next();
                stringDashFinder(strings[t], t+1);
            }
        }

    private static void stringDashFinder(String string, int test) {
            StringBuilder stringBuilder = new StringBuilder();
            char[] chars = string.toCharArray();
        Stack<Integer> numStack = new Stack<>();
            for(int i = 0; i < chars.length; ++i) {
                numStack.push(Integer.valueOf(chars[i] - '0'));
            }
        int bracket = 0;
            while(!numStack.isEmpty()) {
                int val = numStack.pop();
                if(val > 0) {
                    while((val - bracket) > 0) {
                        stringBuilder.append(")");
                        bracket++;
                    }
                    stringBuilder.append(val);
                    int leftBracket = numStack.isEmpty()? 0 : numStack.peek();
                    while((bracket - leftBracket) > 0) {
                        stringBuilder.append("(");
                        bracket--;
                    }
                }
                else stringBuilder.append(val);
            }
        System.out.println("Case #" + test +": " + stringBuilder.reverse().toString());
    }

    }


