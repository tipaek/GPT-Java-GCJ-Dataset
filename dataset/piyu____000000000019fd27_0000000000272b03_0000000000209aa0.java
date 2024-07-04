import java.util.*;

public class Solution{
    public static void main(String ard[]){
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        for(int tt=1;tt<=t;tt++){
            int n=sc.nextInt(),k=sc.nextInt();
            
            if(k%n==0){
                System.out.println("Case #"+tt+": POSSIBLE"); 
                String x=(k/n)+"";
                String res[][]=new String[n][n],arr[]=new String[n-1];
                for(int i=1,j=0;i<=n;i++)
                    if(i!=k/n)
                        arr[j++]=i+"";
                
                for(int i=0;i<n;i++){
                    for(int j=0;j<i;j++){
                        res[i][j]=arr[n-i+j-1];
                    }
                    for(int j=i+1;j<n;j++){
                        res[i][j]=arr[j-i-1];
                    }
                    res[i][i]=k/n+"";
                }
                for(int i=0;i<n;i++){
                    for(int j=0;j<n;j++){
                        System.out.print(res[i][j]+" ");
                    }
                    System.out.println();
                }
            }
            else
                System.out.println("Case #"+tt+": IMPOSSIBLE");
                
        }
    }
}