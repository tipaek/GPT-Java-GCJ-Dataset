import java.util.*;
public class Solution {
    public static void main(String[] args){
        int T;
        int num=0;
        Scanner in=new Scanner(System.in);
        T=in.nextInt();
        while (T>0){
            T--;
            num++;
            int N;
            N=in.nextInt();
            int[][] matrix=new int[N][N];
            int r=0;
            int c=0;
            int k=0;
            HashSet<Integer> set=new HashSet<>();
            for(int i=0;i<N;i++){
                for(int j=0;j<N;j++){
                    matrix[i][j]=in.nextInt();
                    if(i==j)
                        k=k+matrix[i][j];
                }
            }
            for(int i=0;i<N;i++){
                for(int j=0;j<N;j++){
                    if(set.contains(matrix[i][j])) {
                        set.clear();
                        r++;
                        break;
                    }
                    set.add(matrix[i][j]);
                }
                set.clear();
            }
            for(int i=0;i<N;i++){
                for(int j=0;j<N;j++){
                    if(set.contains(matrix[j][i])) {
                        set.clear();
                        c++;
                        break;
                    }
                    set.add(matrix[j][i]);
                }
                set.clear();
            }
            System.out.println("Case #"+num+": "+k+" "+r+" "+c);
        }
    }
}