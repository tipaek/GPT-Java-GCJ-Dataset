import java.util.*;

public class Solution{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);


        int T = sc.nextInt();

        for(int i=1; i<=T; i++){
            int n = sc.nextInt();
            int[][] mtrx = new int[n][n];

            for (int j = 0; j < n; j++) {
                for (int j2 = 0; j2 < n; j2++) {
                    mtrx[j][j2] = sc.nextInt();
                }
            }

            int digSum = 0;
            int dupRow = 0;
            int dupCol = 0;

            for (int k1 = 0; k1 < n; k1++) {
                Set<Integer> colSet = new HashSet<Integer>();
                digSum += mtrx[k1][k1];

                for (int k2 = 0; k2 < mtrx.length; k2++) {
                    if(!colSet.add(mtrx[k1][k2])){
                        dupCol ++;
                        break;
                    }
                }
                colSet.clear();
            }


            for (int k1 = 0; k1 < n; k1++) {
                Set<Integer> rowSet = new HashSet<Integer>();
                for (int k2 = 0; k2 < mtrx.length; k2++) {
                    if(!rowSet.add(mtrx[k2][k1])){
                        dupRow ++;
                        break;
                    }
                }
                rowSet.clear();
            }

            System.out.println("Case #" + i +": " + digSum + " " + dupCol + " " + dupRow);
        }

        sc.close();

    }
}