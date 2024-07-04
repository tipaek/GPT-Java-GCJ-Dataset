import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();
        for (int i = 1; i <= t; i++) {
            int n = in.nextInt();
            System.out.println("Case #" + i + ": ");
            if(n<=350){
                for(int j = 1; j<=n; j++){
                    System.out.println(j+" 1");
                }
            }else{
                int m = n-300;
                int d = 300;
                int k = 1;
                int r = 1;
                for(int j = 0; j<=31; j++){
                    r = j+1;
                    if(((1<<j)&m)>0){
                        if(k == 1){
                            for(int l = 1; l<=r; l++){
                                System.out.println(r+" "+l);
                            }
                            k = r;
                        }else{
                            for(int l = r; l>=1; l--){
                                System.out.println(r+" "+l);
                            }
                            k = 1;
                        }
                    }else{
                        d--;
                        if(k==1){
                            System.out.println(r+" 1");
                        }else{
                            System.out.println(r+" "+r);
                        }
                    }
                }
                for(int j=r+1; j<r+1+d; j++){
                    if(k==1){
                        System.out.println(r+" 1");
                    }else{
                        System.out.println(r+" "+r);
                    }
                }
            }
        }
    }
}

/*

3
1
4
19
 */
