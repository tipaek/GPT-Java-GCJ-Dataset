import java.util.*;
class vestigum{

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int x=1;
        while(t-- >0){
            // int m = sc.nextInt();
            int n = sc.nextInt();
            int Trace = 0;
            int[][] arr = new int[n][n];
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    arr[i][j] = sc.nextInt();
                    if(i==j){
                        Trace+=arr[i][j];
                    }
                }
            }
            int c=0,r=0;
            for(int i=0;i<n;i++){
                boolean vis[] = new boolean[n+1];
                for(int j=0;j<n;j++){
                    if(vis[arr[i][j]]){
                        c++;
                        break;
                    }
                    else{
                        vis[arr[i][j]]=true;
                    }
                }
            }

            for(int i=0;i<n;i++){
                boolean vis[] = new boolean[n+1];
               
                for(int j=0;j<n;j++){
                    if(vis[arr[j][i]]) {r++; break;}
                    else vis[arr[j][i]]=true;
                }
            }
            
            System.out.println("Case #"+x+": "+Trace+" "+c+" "+r);
            x++;
        }
    }
}