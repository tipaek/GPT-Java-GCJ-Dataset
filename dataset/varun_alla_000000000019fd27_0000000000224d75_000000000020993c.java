import java.util.*;
class Solution{
    public static void main(String args[]){
        Scanner s = new Scanner(System.in);
        int t = s.nextInt();
        int count =1;
        while(t-->0){
            int n = s.nextInt();
            int m[][] = new int[n][n];
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    m[i][j]=s.nextInt();
                }
            }
            int k = trace(m,n);
            int r = row(m,n);
            int c = col(m,n);
            System.out.println("Case #"+count+++": "+k+" "+r+" "+c);
        }
    }
    static int trace(int[][] m,int n){
        int sum =0;
        for(int i=0;i<n;i++){
            sum+=m[i][i];
        }
        return sum;
    }
    static int row(int[][] m,int n){
        int re =0;
        for(int i=0;i<n;i++){
            int count[] = new int[n+1];
            for(int j=0;j<n;j++){
                if(count[m[i][j]]==1){
                    re++;
                    break;
                }
                count[m[i][j]]++;
            }
        }
        return re;
    }
    static int col(int[][] m,int n){
        int re =0;
        for(int i=0;i<n;i++){
            int count[] = new int[n+1];
            for(int j=0;j<n;j++){
                if(count[m[j][i]]==1){
                    re++;
                    break;
                }else{
                count[m[j][i]]++;
                }
            }
        }
        return re;
    }
}