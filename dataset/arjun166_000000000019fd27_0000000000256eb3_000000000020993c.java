package codejam1;
import java.util.Scanner;
public class Solution {

    public static void main(String[] args) {
        int t;
        Scanner s=new Scanner(System.in);
        t=s.nextInt();
        int x,n,k = 0,r = 0,c = 0,p = 0,q = 0;
        x=1;
        while(x != t+1){
            r=0;
            k=0;
            c=0;
            n=s.nextInt();
            int[][]a = new int[n][n];
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++)
                    a[i][j]=s.nextInt();
            }
            for(int i=0;i<n;i++){
                p=0;
                for(int j=0;j<n;j++){
                    for(int l=j+1;l<n;l++){
                    if(a[i][j]==a[i][l]){
                         p++;
                        break;
                    }
                }
            }
           if(p>0){
               r++;
           }
        }
            for(int i=0;i<n;i++){
                q=0;
                for(int j=1;j<n;j++){
                    for(int l=j+1;l<n;l++){
                        if(a[j][i]==a[l][i]){
                            q++;
                            break;
                    }
                    }
                }
                if(q>0){
                   c++; 
                }
            }
            for(int i=0;i<n;i++){
                k=k+a[i][i];
            }
            System.out.println("Case #"+x+":"+k+" "+r+" "+c );
            x++;
            
        }
        
        
    }
    
}
