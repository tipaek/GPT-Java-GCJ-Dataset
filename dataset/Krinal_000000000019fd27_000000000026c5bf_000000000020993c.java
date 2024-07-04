import java.util.*;
import static java.lang.System.out;
class App{
    public static void main(String args[])
    {
        Scanner in=new Scanner(System.in);
        int t=in.nextInt();
        for(int i=0;i<t;i++){
            int n=in.nextInt();
            int a[][]=new int[n][n];
            int trace=0;
        int row=0;
            for(int j=0;j<n;j++){
                int r[]=new int[n+1];
                boolean flag=false;
                for(int k=0;k<n;k++){
                    a[j][k]=in.nextInt();
                if(j==k)trace+=a[j][k];
                  r[a[j][k]]++;
                  if(r[a[j][k]]>1 && !flag){ row++; 
                    flag=true;
                      }
            } }
            int col=0;
            for(int k=0;k<n;k++){
                int r[]=new int[n+1];
                boolean flag=false;
                for(int j=0;j<n;j++){
                 r[a[j][k]]++;
                 if(r[a[j][k]]>1 && !flag){
                     col++; 
                     flag=true;
                     break;
                 }
                    
                }            
            }
            
            System.out.printf("Case #%d: %d %d %d\n",(i+1),trace,row,col);
            
        }
    }
}