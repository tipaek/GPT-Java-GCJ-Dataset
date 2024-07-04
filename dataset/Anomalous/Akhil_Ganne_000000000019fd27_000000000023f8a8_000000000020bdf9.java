import java.io.*;
import java.util.*;

class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int t = Integer.parseInt(br.readLine());

        for (int x = 1; x <= t; x++) {
            bw.write("Case #" + x + ": ");
            int n = Integer.parseInt(br.readLine());
            int[] c = new int[24 * 60 + 1];
            int[] j = new int[24 * 60 + 1];
            StringBuilder str = new StringBuilder();
            boolean possible = true;

            for (int k = 0; k < n; k++) {
                String[] input = br.readLine().split(" ");
                int start = Integer.parseInt(input[0]);
                int end = Integer.parseInt(input[1]);
                boolean canAssignToC = true;

                for (int i = start; i < end; i++) {
                    if (c[i] != 0) {
                        canAssignToC = false;
                        break;
                    }
                }

                if (canAssignToC) {
                    str.append("C");
                    for (int i = start; i < end; i++) {
                        c[i] = 1;
                    }
                } else {
                    boolean canAssignToJ = true;
                    for (int i = start; i < end; i++) {
                        if (j[i] != 0) {
                            canAssignToJ = false;
                            break;
                        }
                    }

                    if (canAssignToJ) {
                        str.append("J");
                        for (int i = start; i < end; i++) {
                            j[i] = 1;
                        }
                    } else {
                        possible = false;
                    }
                }
            }

            if (possible) {
                bw.write(str.toString() + "\n");
            } else {
                bw.write("IMPOSSIBLE\n");
            }
        }
        bw.flush();
    }
}