import java.util.*;
import java.io.*;

public class Solution {


    public static void main(String[] args) {

        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCase = sc.nextInt();
        for (int k = 1; k <= testCase; k++) {
            System.out.printf("Case #%d: ", k);

            int X = sc.nextInt();
            int Y = sc.nextInt();

            List<int[]> current = new ArrayList<>();
            List<int[]> next = new ArrayList<>();
            List<String> currentStr = new ArrayList<>();
            List<String> nextStr = new ArrayList<>();
            int[] origin = {0, 0};
            current.add(origin);
            currentStr.add("");

            int index = 1;
            int jump = (int)Math.pow(2, index - 1);

            String ans = "IMPOSSIBLE";
            boolean found = false;

            while (jump <= Math.abs(X) * 2 || jump <= Math.abs(Y) * 2) {
                for (int i = 0; i < current.size(); i++) {
                    int[] tmp = current.get(i);
                    String tmpStr = currentStr.get(i);

                    int[] N = {tmp[0], tmp[1] - jump};
                    next.add(N);
                    nextStr.add(tmpStr + "N");
                    if (N[0] == X && N[1] == Y) {
                        ans = tmpStr + "N";
                        found = true;
                        break;
                    }

                    int[] S = {tmp[0], tmp[1] + jump};
                    next.add(S);
                    nextStr.add(tmpStr + "S");
                    if (S[0] == X && S[1] == Y) {
                        ans = tmpStr + "S";
                        found = true;
                        break;
                    }

                    int[] W = {tmp[0] - jump, tmp[1]};
                    next.add(W);
                    nextStr.add(tmpStr + "W");
                    if (W[0] == X && W[1] == Y) {
                        ans = tmpStr + "W";
                        found = true;
                        break;
                    }

                    int[] E = {tmp[0] + jump, tmp[1]};
                    next.add(E);
                    nextStr.add(tmpStr + "E");
                    if (E[0] == X && E[1] == Y) {
                        ans = tmpStr + "E";
                        found = true;
                        break;
                    }
                }
                if (found) break;
                current = new ArrayList<>(next);
                currentStr = new ArrayList<>(nextStr);
                next = new ArrayList<>();
                nextStr = new ArrayList<>();
                index++;
                jump = (int)Math.pow(2, index - 1);
            }

            System.out.println(ans);
        }
        sc.close();

    }
}