import java.util.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
public class Solution{
    public static void main(String[] args){
        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));;
        int t = sc.nextInt();
        for(int x=1; x<=t; x++){
            int n = sc.nextInt();
            int[] st = new int[n];
            int[] et = new int[n];
            int cmax = 0;
            int cmin = 0;
            
            int jmax = 0;
            int jmin = 0;
            String c = "C";
            String j = "J";
            List<String> output = new ArrayList<>();
            for(int i = 0 ;i<n ;i++){
                st[i] = sc.nextInt();
                et[i] = sc.nextInt();
            }
            boolean flag = true;
                for(int i = 0 ;i<n ;i++){
                if(cmax<=st[i] || et[i]<=cmin){
                    output.add(c);
                    cmax = et[i];
                    cmin = st[i];

                }else if(jmax<=st[i] || et[i]<=jmin){
                     output.add(j);
                      jmax = et[i];
                    jmin = st[i];
                }else{
flag = false;break;
                }
            }
            String res = "";
            if(flag){
                for(int i = 0;i<output.size();i++){
                    res = res + output.get(i);
                }
            }else{
                res = "IMPOSSIBLE";
            }
         
        System.out.println("Case #"+x+": "+res);
        }
    }
}