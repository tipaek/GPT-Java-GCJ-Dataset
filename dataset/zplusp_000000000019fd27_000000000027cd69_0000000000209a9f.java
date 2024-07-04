import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder output = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            Queue<Integer> queue = new LinkedList<>();
            String input = br.readLine();
            for (int i = 0; i < input.length(); i++) {
                queue.add(Integer.parseInt(String.valueOf(input.charAt(i))));
            }

            StringBuilder reqStr = new StringBuilder();
            int pCount = 0;

            while (!queue.isEmpty()) {
                int top = queue.poll();

                if (pCount > top) {
                    while (pCount != top) {
                        reqStr.append(")");
                        pCount--;
                    }

                } else if (pCount < top) {
                    while (pCount != top) {
                        reqStr.append("(");
                        pCount++;
                    }
                }

                reqStr.append(top);
            }

            while (pCount > 0) {
                reqStr.append(")");
                pCount--;
            }

            output.append("Case #").append(t).append(": ").append(reqStr).append("\n");
        }

        System.out.print(output);
    }
}