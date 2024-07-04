
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = Integer.parseInt(in.nextLine());
        for (int tc = 1; tc <= t; tc++)
        {
            StringBuilder output = new StringBuilder();
            String input = in.nextLine();
            String[] arr = input.split("");

            List<Character> mainStack = new ArrayList<>();
            List<Character> openBracketStack = new ArrayList<>();


            for (String indexValue : arr)
            {
                int intValue = Integer.parseInt(indexValue);
                int alreadyOpenBracket = openBracketStack.size();
                if (alreadyOpenBracket == 0) {
                    for (int i = 1; i <= intValue; i++) {
                        mainStack.add('(');
                        openBracketStack.add('(');
                    }
                } else if (alreadyOpenBracket > intValue) {
                    for (int i = 1; i <= alreadyOpenBracket - intValue; i++) {
                        mainStack.add(')');
                        openBracketStack.remove(openBracketStack.size() - 1);
                    }
                } else if (alreadyOpenBracket < intValue) {
                    for (int i = 1; i <= intValue - alreadyOpenBracket; i++) {
                        mainStack.add('(');
                        openBracketStack.add('(');
                    }
                }
                mainStack.add(indexValue.charAt(0));
            }
            if (openBracketStack.size() > 0) {
                for (Character c : openBracketStack)
                    mainStack.add(')');
            }

            for (Character c : mainStack) {
                output.append(c);
            }
            System.out.println("Case #" + tc + ": " + output);
        }

    }
}