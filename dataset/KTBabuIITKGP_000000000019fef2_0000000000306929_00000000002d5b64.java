
import java.util.Arrays;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for (int t=1; t<=T; t++) {
            int R = sc.nextInt();
            int S = sc.nextInt();

            int[][] A = new int[R*S][2];

            for (int s=0; s<S; s++) {
                for (int r=0; r<R; r++) {
                    A[s*R+r][0] = r;
                    A[s*R+r][1] = s;
                }
            }
            StringBuilder stringBuilder = new StringBuilder();
            int count = 0;
            while (true) {
                int a = getA(A);
                int b = getB(A, a);
                if (a>=A.length || b>=A.length){
                    break;
                }
                count++;
                stringBuilder.append(a).append(' ').append(b-a).append('\n');
                perform(A, a, b);
            }
            System.out.println("Case #"+t+": "+count);
            System.out.print(stringBuilder);
        }
    }

    private static int getB(int[][] A, int a) {
        int b=a;
        while (b<A.length && A[b][0]!=A[a-1][0]){
            b++;
        }
        return b;
    }

    private static int getA(int[][] A) {
        int a=0;
        while (a<A.length && A[a][0]==A[0][0]) {
            a++;
        }
        int b=a;
        while (b<A.length && A[b][0]==A[a][0]) {
            b++;
        }
        return b;
    }

    public static void perform(int[][] A, int a, int b) {
        int[][] X = Arrays.copyOfRange(A, 0, a);

        for (int i=0; a+i<b; i++) {
            A[i] = A[i+a];
        }
        for (int i=0; i<a; i++) {
            A[i+b-a] = X[i];
        }
    }
}
