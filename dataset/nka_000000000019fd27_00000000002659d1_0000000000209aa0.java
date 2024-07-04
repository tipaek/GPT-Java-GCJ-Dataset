import java.util.Scanner;

public class Solution {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int T=sc.nextInt();
        int x=1;
        while(T>0){
            int n=sc.nextInt();
            int k=sc.nextInt();
            if(k>n*n || k<n || k%n!=0){
                System.out.println("Case #" + x + ": " + "IMPOSSIBLE");
            }
            else {
                int[][] latinSquare = new int[n + 1][n + 1];
                for (int i = 1; i < n + 1; i++) {
                    int p = i;
                    for (int j = 1; j < n + 1; j++) {
                        if (p == n + 1) {
                            p = 1;
                        }
                        latinSquare[i][j] = p++;
                        //System.out.print(latinSquare[i][j]);
                    }
                    //System.out.println();
                }
                boolean visited[] = new boolean[n + 1];
                int[] list=new int[n+1];
                int sum = k;
                boolean flag = getLatinSquareForGivenTrace(latinSquare, visited, list, k, n, 0);
                if (flag) {
                    System.out.println("Case #" + x + ": " + "POSSIBLE");
                    for (int i=1;i<=n;i++) {
                        for (int j = 1; j <= n; j++) {
                            System.out.print(latinSquare[list[i]][j] + " ");
                        }
                        System.out.println();
                    }
                } else {
                    System.out.println("Case #" + x + ": " + "IMPOSSIBLE");
                }
            }
            T--;
            x++;
        }
    }

    public static boolean getLatinSquareForGivenTrace(int[][] latinSquare,boolean[] visited,int[] list,int sum,int n,int times){
        if(times==n && sum!=0){
            return false;
        }
        if(sum==0 && times==n){
            return true;
        }
        if(sum==0 && times!=n){
            return false;
        }
        times++;
        for(int i=n;i>0;i--){
            boolean flag=false;
            if(!visited[i]){
                visited[i]=true;
                sum-=latinSquare[i][times];
                Integer num=i;
                list[times]=i;
                flag=getLatinSquareForGivenTrace(latinSquare,visited,list,sum,n,times);
                if(flag){
                    return flag;
                }
                sum+=latinSquare[i][times];
                visited[i]=false;
            }


        }
        times--;
        return false;
    }
}
