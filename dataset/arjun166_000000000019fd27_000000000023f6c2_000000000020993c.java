import java.util.Scanner;

/**
 *
 * @author arjun
 */
public class Codejam1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int t;
        Scanner s=new Scanner(System.in);
        t=s.nextInt();
        int x,n,k = 0,r = 0,c = 0;
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
                for(int j=1;j<n;j++){
                    if(a[i][j-1]==a[i][j]){
                        r = r+1;
                        break;
                    }
                }
            }
            for(int i=0;i<n;i++){
                for(int j=1;j<n;j++){
                    if(a[j-1][i]==a[j][i]){
                        c++;
                        break;
                    }
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
