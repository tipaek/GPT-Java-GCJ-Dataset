import java.util.*;
class Solution{
    public static void main(String args[]){
        Scanner s=new Scanner(System.in);
        int t=s.nextInt();
        int cas=1;
        while(t-->0){
            int n=s.nextInt();
            int a[][]=new int[n][n];
           
            int trace=0;
            int row=0;
            int col=0;
            for(int i=0;i<n;i++){
                 
                for(int j=0;j<n;j++){
                    a[i][j]=s.nextInt();
                    if(i==j){
                        trace+=a[i][j];
                    }
                   
                }
            }
            for(int i=0;i<n;i++){
                 int hash[]=new int[n+1];
                for(int j=0;j<n;j++){
                    hash[a[i][j]]+=1;
                    if(hash[a[i][j]]>1){
                        row+=1;
                        break;
                    }
                }
            }
            for(int i=0;i<n;i++){
                 int hash[]=new int[n+1];
                for(int j=0;j<n;j++){
                     hash[a[j][i]]+=1;
                    if(hash[a[j][i]]>1){
                        col+=1;
                        break;
                    }
                }
            }
            System.out.println("Case #"+cas+": "+trace+" "+row+" "+col);
            cas++;
        }
    }
}