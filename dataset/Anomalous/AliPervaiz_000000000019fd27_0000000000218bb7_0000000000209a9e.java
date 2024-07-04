import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        StringTokenizer st = new StringTokenizer(input.readLine());
        int T = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        while (T-- > 0) {
            boolean[] bits = new boolean[B + 1];
            int[] sameIndex = new int[B / 10];
            int[] diffIndex = new int[B / 10];
            boolean[] flipSame = new boolean[B / 10];
            boolean[] flipDiff = new boolean[B / 10];
            
            Arrays.fill(sameIndex, -1);
            Arrays.fill(diffIndex, -1);

            for (int i = 1; i <= B / 2; i++) {
                out.println(i);
                out.flush();
                bits[i] = Integer.parseInt(input.readLine()) == 1;
                out.println(B - i + 1);
                out.flush();
                bits[B - i + 1] = Integer.parseInt(input.readLine()) == 1;

                if (bits[i] == bits[B - i + 1]) {
                    sameIndex[(i - 1) / 5] = i;
                } else {
                    diffIndex[(i - 1) / 5] = i;
                }
            }

            for (int i = 0; i < sameIndex.length; i++) {
                if (sameIndex[i] == -1) {
                    out.println(1);
                    out.flush();
                    input.readLine();
                    continue;
                }
                out.println(sameIndex[i]);
                out.flush();
                boolean value = Integer.parseInt(input.readLine()) == 1;
                if (bits[sameIndex[i]] != value) {
                    flipSame[i] = true;
                }
            }

            for (int i = 0; i < sameIndex.length; i++) {
                if (diffIndex[i] == -1) {
                    out.println(1);
                    out.flush();
                    input.readLine();
                    continue;
                }
                out.println(diffIndex[i]);
                out.flush();
                boolean value = Integer.parseInt(input.readLine()) == 1;
                if (bits[diffIndex[i]] != value) {
                    flipDiff[i] = true;
                }
            }

            for (int i = 0; i < sameIndex.length; i++) {
                if (sameIndex[i] == -1) continue;
                out.println(sameIndex[i]);
                out.flush();
                boolean value = Integer.parseInt(input.readLine()) == 1;
                if (bits[sameIndex[i]] != value && !flipSame[i] || bits[sameIndex[i]] == value && flipSame[i]) {
                    for (int j = 0; j < flipSame.length; j++) {
                        flipSame[j] = !flipSame[j];
                    }
                }
                break;
            }

            for (int i = 0; i < sameIndex.length; i++) {
                if (diffIndex[i] == -1) continue;
                out.println(diffIndex[i]);
                out.flush();
                boolean value = Integer.parseInt(input.readLine()) == 1;
                if (bits[diffIndex[i]] != value && !flipDiff[i] || bits[diffIndex[i]] == value && flipDiff[i]) {
                    for (int j = 0; j < flipDiff.length; j++) {
                        flipDiff[j] = !flipDiff[j];
                    }
                }
                break;
            }

            StringBuilder result = new StringBuilder();
            StringBuilder resultReversed = new StringBuilder();

            for (int i = 1; i <= B / 2; i++) {
                if (bits[i] == bits[B - i + 1] && flipSame[(i - 1) / 5] || bits[i] != bits[B - i + 1] && flipDiff[(i - 1) / 5]) {
                    result.append(bits[i] ? 0 : 1);
                    resultReversed.insert(0, bits[B - i + 1] ? 0 : 1);
                } else {
                    result.append(bits[i] ? 1 : 0);
                    resultReversed.insert(0, bits[B - i + 1] ? 1 : 0);
                }
            }

            out.println(result.toString() + resultReversed.toString());
            out.flush();

            String response = input.readLine();
            if (response.equals("N")) {
                break;
            }
        }

        out.flush();
        out.close();
    }
}