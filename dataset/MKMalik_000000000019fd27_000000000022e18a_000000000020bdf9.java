import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int i=0; i<t; i++) {
            int overlap = 0;
            char[] ar = {'C', 'J'};
            int w = 0;
            String res = Character.toString(ar[w]);
            int n = in.nextInt();
            int[] s = new int[n];
            int[] e = new int[n];
            for (int j=0; j<n; j++) {
                s[j] = in.nextInt();
                e[j] = in.nextInt();
            }
            for (int k=1; k<n; k++) {
                if (s[k] >= s[k-1] && e[k] < e[k-1]) {
                    if (w == 0) w = 1;
                    else w = 0;
                    res += ar[w];
                    overlap++;
                }
                else {
                    if (w == 0) w = 1;
                    else w = 0;
                    res += ar[w];
                }
            }
            if (overlap > 0) {
                System.out.println("Case #"+(i+1)+": "+"IMPOSSIBLE");
                continue;
            }
            System.out.println(res);
        }
    }
}
