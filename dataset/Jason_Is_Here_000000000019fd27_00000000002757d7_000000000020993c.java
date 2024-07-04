import java.io.IOException;
import java.util.HashSet;
import java.util.Scanner;

 class Solution {
    public static void main(String[] args)throws IOException
    {
        try {
            Scanner sc = new Scanner(System.in);
            int T = sc.nextInt();
            for (int p = 1; p <= T; p++) {
                int sum = 0, c = 0, co = 0, d = 0, dp = 0;
                int n = sc.nextInt();
                int mat[][] = new int[n][n];
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < n; j++) {
                        mat[i][j] = sc.nextInt();

                        if (i == j)
                            sum += mat[i][j];
                    }
                }

                for (int i = 0; i < n; i++) {
                    HashSet<Integer> hs = new HashSet<>();
                    HashSet<Integer> bs = new HashSet<>();
                    for (int j = 0; j < mat[i].length; j++) {
                        hs.add(mat[i][j]);
                        bs.add(mat[j][i]);
                    }
                    if (hs.size() < n)
                        co++;
                    if (bs.size() < n)
                        dp++;
                }

                System.out.println("Case #" + T + ":"+" " + sum + " " + co + " " + dp);
            }
        }
        catch (Exception e){
            return;}
    }
}
