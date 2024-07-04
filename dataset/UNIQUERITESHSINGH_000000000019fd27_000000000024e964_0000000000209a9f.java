
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
            List<Character> stack = new ArrayList<>();
            for (String indexValue : arr)
            {
                if (indexValue.equals("1"))
                {
                    stack.add('1');
                }
                else
                {
                    StringBuilder stackData = new StringBuilder();
                    for (Character c : stack)
                    {
                        stackData.append(c);
                    }
                    stack.clear();
                    if(stackData.length()!=0)
                    output.append("(").append(stackData).append(")");
                    output.append(indexValue);
                }
            }
            if(stack.size()>0)
            {
                StringBuilder stackData = new StringBuilder();
                for (Character c : stack)
                {
                    stackData.append(c);
                }
                stack.clear();
                output.append("(").append(stackData).append(")");
            }
            System.out.println("Case #" + tc + ": " + output);
        }
    }
}
