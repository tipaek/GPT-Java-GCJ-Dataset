import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int ttt = scan.nextInt();
        for (int t1 = 0; t1 < ttt; t1++) {

            int n = scan.nextInt();
            int k = scan.nextInt();
            int a[] = new int[n];
            System.out.print("Case #" + (t1+1) + ": ");
            if (k % n == 0) {
                System.out.print("POSSIBLE\n");
                int t = k / n;
                for (int i = 0; i < n; i++) {
                    if(t>n) t = 1;
                    a[i] = t;
                    t++;
                }
                for(int aq: a) System.out.print(aq+" ");
                System.out.println();
                for (int i = 0; i < n-1; i++) {

                    int position = n-1;
                    int temp = a[position];
                    for (int j = (position - 1); j >= 0; j--) {
                        a[j+1] = a[j];
                    }
                    a[0] = temp;
                    for (int aq: a) {
                        System.out.print(aq+" ");
                    }
                    System.out.println();
                }
            }
            else
            {
                System.out.print("IMPOSSIBLE");
            }
        }
    }
}
/*
Case #1: POSSIBLE
        2 3 1
        1 2 3
        3 1 2

        Case #2: IMPOSSIBLE
*/
