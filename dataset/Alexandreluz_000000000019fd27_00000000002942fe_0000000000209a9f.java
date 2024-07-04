import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        int numberTests;

        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){
            String line = br.readLine();
            numberTests = Integer.valueOf(line);
            for (int i = 0; i < numberTests; i++) {
                addParentesis(i+1, br.readLine());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void addParentesis(int testNumber, String s) {
        // 123
        // (1(2(3)))
        // 312
        // (((3))1)((2))
        // 41320
        // ((((4)))1((3)2))0
        Deque<Character> parentesis = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder();
        int openedP = 0;
        for (int i = 0; i < s.length(); i++) {
            int currNum = s.charAt(i) - '0';
            while (openedP < currNum) {
                parentesis.push('(');
                sb.append("(");
                openedP++;
            }
            while (openedP > currNum) {
                parentesis.pop();
                sb.append(")");
                openedP--;
            }
            sb.append(currNum);
        }

        while (!parentesis.isEmpty()) {
            sb.append(")");
            parentesis.pop();
        }
        System.out.println(sb.toString());
    }
}