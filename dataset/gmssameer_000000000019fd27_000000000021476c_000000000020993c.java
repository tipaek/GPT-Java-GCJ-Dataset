import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {

        Scanner in =new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int text_case=in.nextInt();
        for(int q=1;q<=text_case;q++){
            int n = in.nextInt();
            int rr;
            int [][] m = new int [n][n];
            int dsum = 0,r=0,c=0;
            for(int i=0;i<n;i++){
                rr=1<<n;boolean f = false;
                for(int j=0;j<n;j++){
                    int k = in.nextInt();
                    m[i][j]=k;
                    if(i==j){
                        dsum+=k;
                    }
                    if(j==0) {
                        rr |= (1 << (k-1));
                    }
                    else{
                        int tt = rr & (1 << (k-1));
                        if(tt!=0){
                            f=true;
                        }
                        else {
                            rr |= (1 << (k-1));
                        }

                    }
                }
                if(f){
                    r++;
                }
            }
            for(int i=0;i<n;i++){
                rr=1<<n;boolean f = false;
                for(int j=0;j<n;j++){
                    int k = m[j][i]-1;
                    if(j==0) {
                        rr |= (1 << k);
                    }else{
                        int tt = rr & (1 << k);
                        if(tt!=0){
                            f=true;
                        }
                        else {
                            rr |= (1 << k);
                        }
                    }
                }
                if(f){
                    c++;
                }
            }
            System.out.println("Case #"+q+": "+dsum+" "+r+" "+c);


        }
    }
}
