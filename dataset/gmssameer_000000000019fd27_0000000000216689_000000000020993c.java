import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {

        Scanner in =new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int text_case=in.nextInt();
        for(int q=1;q<=text_case;q++){
            int n = in.nextInt();
            HashMap rr= new HashMap();
            int [][] m = new int [n][n];
            int dsum = 0,r=0,c=0;
            for(int i=0;i<n;i++){
                rr=new HashMap();boolean f = false;
                for(int j=0;j<n;j++){
                    int k = in.nextInt();
                    m[i][j]=k;
                    if(i==j){
                        dsum+=k;
                    }
                    if(j==0) {
                        rr.put(k,true);
                    }
                    else{
                        if(rr.containsKey(k)){
                            f=true;
                        }
                        else {
                            rr.put(k,true);
                        }

                    }
                }
                if(f){
                    r++;
                }
            }
            for(int i=0;i<n;i++){
                rr=new HashMap();boolean f = false;
                for(int j=0;j<n;j++){
                    int k = m[j][i];
                    if(j==0) {
                        rr.put(k,true);
                    }else{

                        if(rr.containsKey(k)){
                            f=true;
                        }
                        else {
                            rr.put(k,true);
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
