import java.util.*;
public class Solution{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-->0){
            int dim = sc.nextInt();
            int tr = 0;
            int[][] mat = new int[dim][dim];
            for(int i=0;i<dim;i++){
                for(int j=0;j<dim;j++){
                    int ele = sc.nextInt();
                    mat[i][j] = ele;
                    if(i==j){
                       tr+=ele; 
                    }
                }
            }
            int r = 0;
            int c = 0;
            for(int i=0;i<dim;i++){
                Set setA = new HashSet();
                Set setB = new HashSet();
                for(int j=0;j<dim;j++){
                    setA.add(mat[i][j]);
                    setB.add(mat[j][i]);
                }
                //System.out.println(setA);
                //System.out.println(setB);
                if(setA.size()!=dim){
                    r++;
                }
                if(setB.size()!=dim){
                    c++;
                }
            }
            System.out.println(tr+" "+r+" "+c);
        }
    }
}