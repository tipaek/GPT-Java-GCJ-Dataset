import java.io.PrintWriter;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        PrintWriter pw = new PrintWriter(System.out);

        int[][] pass = new int[110][110];
        pass[1][1] = 1;
        for (int i = 2; i < 100; i++) {
            for (int j = 1; j <= i; j++) {
                pass[i][j] = pass[i-1][j-1] + pass[i-1][j];
            }
        }
        int tests = sc.nextInt();
        for (int test = 0; test < tests; test++) {
            pw.printf("Case #%d:\n",test+1);
            int N = sc.nextInt();
            if (N>2000)continue;
            if (N >= 1)pw.println("1 1");
            if (N >= 2)pw.println("2 2");
            if (N>2){
                N -= 2;
                int posFil = 3;
                int posCol = 2;
                while (N>=pass[posFil][posCol]){
                    pw.println(posFil+" "+posCol);
                    posFil++;
                    N -= pass[posFil][posCol];
                }
                if (N > 0){
                    posCol -=1;
                    posFil -=1;
                }
                while (N>0){
                    pw.println(posFil+" "+posCol);
                    N--;
                    posFil++;
                }
            }
        }
        pw.flush();
    }
}
