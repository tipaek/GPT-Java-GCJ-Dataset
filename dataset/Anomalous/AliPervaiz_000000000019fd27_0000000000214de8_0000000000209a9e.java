import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        StringTokenizer st = new StringTokenizer(input.readLine());
        int T = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        while (T-- > 0) {
            int[] ar = new int[B + 1];
            int sameIndex = -1;
            int changedIndex = -1;

            for (int i = 1; i <= B / 2; i++) {
                out.println(i);
                out.flush();
                ar[i] = Integer.parseInt(input.readLine());

                out.println(B - i + 1);
                out.flush();
                ar[B - i + 1] = Integer.parseInt(input.readLine());

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
                int value = Integer.parseInt(input.readLine());
                if (ar[sameIndex] != value) {
                    flipSames = true;
                }
            }

            if (changedIndex != -1) {
                out.println(changedIndex);
                out.flush();
                int value = Integer.parseInt(input.readLine());
                if (ar[changedIndex] != value) {
                    flipChanges = true;
                }
            }

            for (int i = 1; i <= B; i++) {
                if ((ar[i] == ar[B - i + 1] && flipSames) || (ar[i] != ar[B - i + 1] && flipChanges)) {
                    out.print(1 - ar[i]);
                } else {
                    out.print(ar[i]);
                }
            }

            out.println();
            out.flush();
            input.readLine(); // Read the judge's response
        }

        out.flush();
        out.close();
    }
}