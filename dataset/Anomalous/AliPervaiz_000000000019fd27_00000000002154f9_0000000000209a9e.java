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
            boolean[] ar = new boolean[B + 1];
            int sameIndex = -1;
            int changedIndex = -1;

            for (int i = 1; i <= B / 2; i++) {
                out.println(i);
                out.flush();
                ar[i] = Integer.parseInt(input.readLine()) == 1;

                out.println(B - i + 1);
                out.flush();
                ar[B - i + 1] = Integer.parseInt(input.readLine()) == 1;

                if (ar[i] == ar[B - i + 1]) {
                    sameIndex = i;
                } else {
                    changedIndex = i;
                }
            }

            boolean flipSames = false;
            boolean flipChanges = false;

            if (sameIndex != -1) {
                out.println(sameIndex);
                out.flush();
                boolean value = Integer.parseInt(input.readLine()) == 1;
                if (ar[sameIndex] != value) {
                    flipSames = true;
                }
            }

            if (changedIndex != -1) {
                out.println(changedIndex);
                out.flush();
                boolean value = Integer.parseInt(input.readLine()) == 1;
                if (ar[changedIndex] != value) {
                    flipChanges = true;
                }
            }

            for (int i = 1; i <= B; i++) {
                if ((ar[i] == ar[B - i + 1] && flipSames) || (ar[i] != ar[B - i + 1] && flipChanges)) {
                    out.print(ar[i] ? 0 : 1);
                } else {
                    out.print(ar[i] ? 1 : 0);
                }
            }

            out.println();
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