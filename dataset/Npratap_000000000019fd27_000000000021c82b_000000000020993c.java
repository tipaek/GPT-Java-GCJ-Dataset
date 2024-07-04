import java.util.*;

public class Solution{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for(int i=1;i<=n;i++){
            int N = sc.nextInt();
            int[][] m = new int[N][N];
            for(int j=0;j<N;j++){
            String line = sc.nextLine();
            int c =0;
            for(String s : line.split(" ")){
            m[N][c] = Integer.parseInt(s);
            c +=1;
            }    
            }
            int dr =0;
            int dc =0;
            //for dup rows and cols
            for(int h=0;h<N;h++){
                Set<Integer> r = new HashSet<Integer>();
                Set<Integer> c = new HashSet<Integer>();
                
                for(int k=0;k<N;k++){
                    if(r.add(m[h][k])==false){
                        dr = dr+1;
                    }
                    if(c.add(m[k][h])==false)
                        dc= dc+1;
                }
                
            }
            
            //for trace
            int tr =0;
            for(int a=0;a<N;a++){
                for(int b=0;b<N;b++){
                    if(a==b){
                        tr = tr + m[a][b];
                    }
                }
            }
            
             
            System.out.println("Case #"+i+": "+tr +" "+dr +" "+dc +" " );
            
        }
    }
}