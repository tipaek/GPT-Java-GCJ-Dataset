import java.util.*;

public class Solution {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        
        for(int i=0;i < T;i++) {
            int x = i+1; int k = 0; int r = 0; int c = 0;
            int N = sc.nextInt();
            
            int[][] mat = new int[N][N];
            
            for(int p=0;p < N;p++) {
                List<Integer> lst = new ArrayList<Integer>(N);
                boolean repeated = false;
                for(int q=0;q < N;q++) {
                    mat[p][q] = sc.nextInt();
                    if(!repeated && lst.contains(mat[p][q])) {
                        repeated = true;
                        r++;
                    } else if(!repeated) {
                        lst.add(mat[p][q]);
                    }
                    if(p == q) {
                        k += mat[p][q];
                    }
                }
            }
            
            for(int p=0;p < N;p++) {
                List<Integer> lst = new ArrayList<Integer>(N);
                boolean repeated = false;
                for(int q=0;q < N;q++) {
                    if(!repeated && lst.contains(mat[q][p])) {
                        repeated = true;
                        c++;
                        break;
                    }
                    lst.add(mat[q][p]);
                }
            }
            
            System.out.println("Case #" + x + ": " + k + " " + r + " " + c);
        }
    }
    
}