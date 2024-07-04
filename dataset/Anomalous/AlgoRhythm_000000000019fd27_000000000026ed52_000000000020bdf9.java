import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

class ParentingPartneringReturns {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        
        for (int l = 0; l < t; l++) {
            int n = Integer.parseInt(br.readLine());
            int[][] jamie = new int[n][2];
            int[][] cameron = new int[n][2];
            int j = 0, c = 0;
            StringBuilder str = new StringBuilder();
            boolean flag = true;

            for (int i = 0; i < n; i++) {
                Scanner sc = new Scanner(br.readLine());
                int s = sc.nextInt();
                int e = sc.nextInt();

                if (flag) {
                    if (isAvailable(jamie, s, e, j)) {
                        str.append("J");
                        jamie[j][0] = s;
                        jamie[j++][1] = e;
                    } else if (isAvailable(cameron, s, e, c)) {
                        str.append("C");
                        cameron[c][0] = s;
                        cameron[c++][1] = e;
                    } else {
                        str = new StringBuilder("IMPOSSIBLE");
                        flag = false;
                    }
                }
            }
            System.out.println("Case #" + (l + 1) + ": " + str);
        }
    }

    static boolean isAvailable(int[][] arr, int s, int e, int n) {
        for (int i = 0; i < n; i++) {
            if ((s < arr[i][1] && e > arr[i][0])) {
                return false;
            }
        }
        return true;
    }
}