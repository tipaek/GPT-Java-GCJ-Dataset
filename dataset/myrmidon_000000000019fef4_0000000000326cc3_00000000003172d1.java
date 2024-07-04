import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * @author dbatchunag
 */

public class Solution {

    public static void main(String[] args) throws IOException {
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input;
        String[] inputArray;

        input = br.readLine();
        final int T = Integer.parseInt(input);
        for (int t=1; t<=T; t++) {
            input = br.readLine();
            inputArray = input.split(" ");
            final int N = Integer.parseInt(inputArray[0]);
            final int D = Integer.parseInt(inputArray[1]);
            input = br.readLine();
            inputArray = input.split(" ");
            final long[] a = new long[N];
            for (int i=0; i<N; i++) {
                a[i] = Long.parseLong(inputArray[i]);
            }
            Arrays.sort(a);
            int ans = -1;
            if (D==2) {
                boolean equal = false;
                for (int i=1; i<N; i++) {
                    if (a[i] == a[i-1]) {
                        equal = true;
                        break;
                    }
                }
                ans = equal? 0 : 1;
            } else if (D==3){
                //3 equals
                boolean zerocut = false;
                for (int i = 2; i < N; i++) {
                    if (a[i] == a[i - 1] && a[i] == a[i - 2]) {
                        zerocut = true;
                        break;
                    }
                }

                boolean onecut = false;
                for (int i = 1; i < N; i++) {
                    if (a[i] == a[i - 1] && i < N - 1) {
                        onecut = true;
                        break;
                    }
                }

                for (int i = 0; i < N - 1; i++) {
                    for (int j = i + 1; j < N; j++) {
                        if (a[j] == 2 * a[i]) {
                            onecut = true;
                            break;
                        }
                    }
                }

                if (zerocut) {
                    ans = 0;
                } else if (onecut) {
                    ans = 1;
                } else {
                    ans = 2;
                }
            } else {
                ans = 0;
            }

            System.out.println(String.format("Case #%d: %s", t, ans));
        }
    }
}



