import java.util.Scanner;
public class Solution{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int T=sc.nextInt();
        int p=0;
        while(T-- >0){
            int N=sc.nextInt();
            int[][] a=new int[100][100];
            int r=0,c=0,k;
            for(int i=0;i<N;i++){
                for(int j=0;j<N;j++){
                    a[i][j]=sc.nextInt();
                }
            }
            for(int i=0;i<N;i++){
                for(int j=0;j<N;j++){
                    for(int u=i;u<j;u++){
                        if(a[i][j]==a[u][j])
                            r++;
                        if(a[i][j]==a[i][u])
                            c++;
                    }
                }
            }
            k=r+c;
            System.out.println("Case #" + ++p + ": " + k + " " + r + " " + c);
        }
        sc.close();
    }
}