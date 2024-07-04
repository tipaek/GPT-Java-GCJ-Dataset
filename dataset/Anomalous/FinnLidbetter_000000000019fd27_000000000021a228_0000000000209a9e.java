import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String[] input = br.readLine().split(" ");
        int nTests = Integer.parseInt(input[0]);
        int n = Integer.parseInt(input[1]);

        for (int test = 0; test < nTests; test++) {
            int[] arr = new int[n];
            Arrays.fill(arr, -1);
            int numC = 0, numR = 0, cIndex = -1, rIndex = -1, known = 0, qIndex = 0;

            while (known < n) {
                if (qIndex > 1 && qIndex % 10 == 0) {
                    if (cIndex >= 0) {
                        System.out.println(cIndex + 1);
                        System.out.flush();
                        int read = Integer.parseInt(br.readLine());
                        int expect = arr[cIndex];
                        if (numR % 2 == 1) expect = arr[n - cIndex - 1];
                        if (numC % 2 == 1) expect = 1 - expect;
                        if (read != expect) numC++;
                    } else {
                        System.out.println(1);
                        System.out.flush();
                        br.readLine();
                    }
                } else if (qIndex > 1 && qIndex % 10 == 1) {
                    if (rIndex >= 0) {
                        System.out.println(rIndex + 1);
                        System.out.flush();
                        int read = Integer.parseInt(br.readLine());
                        int expect = arr[rIndex];
                        if (numR % 2 == 1) expect = arr[n - rIndex - 1];
                        if (numC % 2 == 1) expect = 1 - expect;
                        if (read != expect) numR++;
                    } else {
                        System.out.println(1);
                        System.out.flush();
                        br.readLine();
                    }
                } else {
                    if (qIndex % 2 == 0) {
                        System.out.println((known / 2) + 1);
                        System.out.flush();
                        int val = Integer.parseInt(br.readLine());
                        if (numC % 2 == 1) val = 1 - val;
                        if (numR % 2 == 0) {
                            arr[known / 2] = val;
                        } else {
                            arr[n - (known / 2) - 1] = val;
                        }
                    } else {
                        System.out.println(n - (known / 2));
                        System.out.flush();
                        int val = Integer.parseInt(br.readLine());
                        if (numC % 2 == 1) val = 1 - val;
                        if (numR % 2 == 0) {
                            arr[n - (known / 2) - 1] = val;
                        } else {
                            arr[known / 2] = val;
                        }
                        if (cIndex == -1 && arr[n - (known / 2) - 1] == arr[known / 2]) {
                            cIndex = known / 2;
                        }
                        if (rIndex == -1 && arr[n - (known / 2) - 1] != arr[known / 2]) {
                            rIndex = known / 2;
                        }
                    }
                    known++;
                }
                qIndex++;
            }

            sb.setLength(0);
            for (int i = 0; i < n; i++) {
                int index = (numR % 2 == 1) ? n - i - 1 : i;
                int val = arr[index];
                if (numC % 2 == 1) val = 1 - val;
                sb.append(val);
            }

            System.out.println(sb.toString());
            System.out.flush();
            br.readLine();
        }
    }
}