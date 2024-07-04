import java.util.HashSet;
import java.util.Scanner;

class Solution1 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int t = s.nextInt();

        for (int i = 1; i <= t; i++) {
            int n = s.nextInt();
            int[][] a = new int[n][n];
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    a[j][k] = s.nextInt();
                }
            }
            int k=0,r=0,c=0;
            for (int j = 0; j < n; j++) {
                k+=a[j][j];
                HashSet<Integer> set = new HashSet<>();
                boolean rflag = false , cflag = false;
                set.add(a[j][j]);
                for (int l = j+1; l < n; l++) {
                    if(set.contains(a[j][l])){
                       c++;
                       cflag = true;
                       break;
                    }
                    set.add(a[j][l]);
                }
                for (int l = j-1; l >= 0; l--) {
                    if (cflag) break;
                    if(set.contains(a[j][l])){
                        c++;
                        break;
                    }
                    set.add(a[j][l]);
                }
                set.clear();
                set.add(a[j][j]);
                for (int l = j+1; l < n; l++) {
                    if(set.contains(a[l][j])){
                        r++;
                        rflag = true;
                        break;
                    }
                    set.add(a[l][j]);
                }
                for (int l = j-1; l >= 0; l--) {
                    if (rflag) break;
                    if(set.contains(a[l][j])){
                        r++;
                        break;
                    }
                    set.add(a[l][j]);
                }
                set.clear();
            }
            System.out.println("Case #"+i+": " + k +" "+c+" "+r);
        }
    }
}
