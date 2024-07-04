import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

class Solution {

        public static void main(String[] args) {
                Scanner sc= new Scanner(System.in);
                int test_cases = sc.nextInt();
                
                for(int t=0;t<test_cases;t++) {
                        int N = sc.nextInt();
                        
                        int[][] mat = new int[N][N];
                        
                        for(int x= 0;x<N;x++) {
                                for(int y=0;y<N;y++) {
                                        mat[x][y]=sc.nextInt();                                
                                        }
                        
                        }
                        
                        int k=0,c=0,r=0;
                        Set<Integer> set;
                        
                        for(int i=0;i<N;i++) {
                                k+=mat[i][i];
                        }
                        
                        for(int i=0;i<N;i++) {
                                 set= new HashSet<Integer>();
                                for(int j=0;j<N;j++) {
                                        set.add(mat[i][j]);
                                }
                                if(set.size()<N) r++;
                        }
                        
                        for(int i=0;i<N;i++) {
                                 set= new HashSet<Integer>();
                                for(int j=0;j<N;j++) {
                                        set.add(mat[j][i]);
                                }
                                if(set.size()<N) c++;
                        }
                        System.out.println("Case #" + test_cases+1 + ": "+k+" "+r+" "+c);                        
                }
        }
}