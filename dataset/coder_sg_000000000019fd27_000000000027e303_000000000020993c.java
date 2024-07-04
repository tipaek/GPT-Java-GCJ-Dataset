import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

class Solution {

        public static void main( String[] args) {
            Scanner sc = new Scanner(System.in);

            int t = sc.nextInt();

            for (int tC = 1; tC <= t; tC++) {
                int n = sc.nextInt();

                int[][] m = new int[n][n];

                for (int i = 0; i < n; i++)
                    for (int j = 0; j < n; j++)
                        m[i][j] = sc.nextInt();

                int k = 0;

                for (int i = 0; i < n; i++)
                    k += m[i][i];

                int r = 0;

                for (int i = 0; i < n; i++) {
                    Set<Integer> set = new HashSet<>();
                    for (int j = 0; j < n; j++) {
                        if (set.contains(m[i][j])) {
                            r++;
                            break;
                        }
                        set.add(m[i][j]);
                    }
                }

                int c = 0;

                for (int i = 0; i < n; i++) {
                    Set<Integer> set = new HashSet<>();
                    for(int j = 0; j < n; j++) {
                        if(set.contains(m[j][i])) {
                            c++;
                            break;
                        }
                        set.add(m[j][i]);
                    }
                }

                System.out.println("Case #"+tC+": "+k+" "+r+" "+c);
            }
            sc.close();
    } 
}