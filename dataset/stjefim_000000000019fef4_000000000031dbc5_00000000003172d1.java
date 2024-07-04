

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = in.nextInt();
        for (int t = 0; t < T; t++) {
            int N = in.nextInt();
            int D = in.nextInt();
            HashMap<Long, Integer> data = new HashMap<>();
            for (int n = 0; n < N; n++) {
                long tmp = in.nextLong();
                if (data.containsKey(tmp)) {
                    data.put(tmp, data.get(tmp) + 1);
                } else {
                    data.put(tmp, 1);
                }
            }
            int answer = -1;
            if (D == 2) {
                for (int i : data.values()) {
                    if (i >= 2) {
                        answer = 0;
                        break;
                    }
                }
                if (answer == -1) answer =1;
            } else {
                for (int i : data.values()) {
                    if (i >= 3) {
                        answer = 0;
                        break;
                    }
                }
                if (answer == -1) {
                    for (long key : data.keySet()) {
                        if (data.get(key) == 2) {
                            for (long key2 : data.keySet()) {
                                if (key2 > key) answer = 1;
                            }
                        }
                    }
                }
                if (answer == -1) {
                    for (long key : data.keySet()) {
                        if (data.get(key) == 1) {
                            for (long key2 : data.keySet()) {
                                if (key2 == key * 2) answer = 1;
                            }
                        }
                    }
                }
                if (answer == -1) answer = 2;
            }
            out.write(String.format("Case #%d: %d\n", t + 1, answer));
            out.flush();
        }

        out.close();
        in.close();
    }

}
