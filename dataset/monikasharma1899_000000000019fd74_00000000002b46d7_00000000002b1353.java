import java.util.*;

class Solution{
    public static List<Integer[]> findPath(int n, int mat[][],List<Integer[]> path){
        
    }
    
    public static void main(String args[]){
        Scanner sc= new Scanner(System.in);
        int T= sc.nextInt();
        for(int t=1;t<=T;t++){
            int n=sc.nextInt();
            int pascal[][]=new int[n+1][n+1];
            for(int i=1;i<=n;i++){
                for(int j=1;j<=i;j++){
                    if(i>2 && j>1 && j<n){
                        pascal[i][j]=pascal[i-1][j-1]+pascal[i-1][j];
                    }
                    else{
                        pascal[i][j]=1;
                    }
                }
            }
            List<Integer[]> path = new ArrayList<>();
            int first[]={1,1};
            path.add(first);
            System.out.println(path);
        }
    }
}