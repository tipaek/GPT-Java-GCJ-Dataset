import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

/**
 *
 * @author ducbm
 */
public class Solution {

    public static void main(String[] args) {
        try {
            try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
                int T = Integer.valueOf(reader.readLine());

                for (int i = 0; i < T; i++) {
                    String line = reader.readLine();
                    char[] arr = line.toCharArray();

                    Stack<Character> stack = new Stack<>();
                    int currentLevel = 0;
                    for (char a : arr) {
                        int val = a - 48;

                        if (stack.isEmpty()) {
                            for (int j = 0; j < val; j++) {
                                stack.push('(');
                            }

                            currentLevel += val;
                        } else {
                            int newLevel = val - currentLevel;

                            if (newLevel >= 0) {
                                for (int j = 0; j < newLevel; j++) {
                                    stack.push('(');
                                }
                            } else {
                                for (int j = 0; j < -newLevel; j++) {
                                    stack.push(')');
                                }
                            }
                            currentLevel += newLevel;
                        }
                        stack.push(a);
                    }

                    for (int j = 0; j < currentLevel; j++) {
                        stack.push(')');
                    }

                    char[] ret = new char[stack.size()];
                    for (int j = 0; j < stack.size(); j++) {
                        ret[j] = stack.get(j);
                    }
                    System.out.println(String.format("Case #%d: %s", i + 1, new String(ret)));
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}