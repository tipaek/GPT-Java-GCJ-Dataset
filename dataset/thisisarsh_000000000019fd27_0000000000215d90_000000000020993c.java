import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scan = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int test = scan.nextInt();
        int m,trace=0,sum=0,rsum=0,csum=0,rcount=0,ccount=0;
        
        for(int t=1; t<=test; t++){
            m=scan.nextInt();
            for(int s=1;s<=m;s++){
                sum = sum + s;
            }
            int matrix[][] = new int[m][m];
            for(int j=0;j<m;j++){
                for (int k=0; k<m; k++){
                    matrix[j][k]=scan.nextInt();
                    if(k==j){
                        trace+=matrix[j][k];
                    }
                    rsum= rsum + matrix[j][k];
                    
                }
                if(rsum!=sum){
                        rcount++;
                  }
                  rsum=0;
            }
            int k=0;
            for(int i=0;i<m;){
                if(k==m){
                    break;
                }
                csum= csum+ matrix[i][k];
                i++;
                if(i==m&&k<m){
                    i=0;
                    k++;
                    if(csum!=sum){
                        ccount++;
                    }
                    csum=0;
                }
                
            }
            System.out.println("Case #"+t+": "+trace+" "+rcount+" "+ccount);
            trace=0;
        }
    }
}
