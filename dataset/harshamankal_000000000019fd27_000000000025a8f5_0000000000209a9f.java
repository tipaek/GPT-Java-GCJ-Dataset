import java.util.*;
import java.io.*;

class Solution{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        while(T>0){
            String ip = br.readLine();
            String res = compute(ip);
            System.out.println(res);
            T--;
        }
    }
    
    public static String compute(String ip){
        StringBuffer res = new StringBuffer("");
        int i=0;
        int temp1 =0;
        int temp2 =0;
        int ops=0;
        int cps=0;
        while(i<ip.length()){
            temp2 = Integer.parseInt(Character.toString(ip.charAt(i)));
            int temp3 = temp2 - temp1;
            if(temp3>0){
                for(int j=0;j<temp3;j++){
                    res.append("(");
                    ops++;
                }
                res.append(temp2);
            }
            else{
                for(int j=0;j<(-temp3);j++){
                    res.append(")");
                    cps++;
                }
                res.append(temp2);
            }
            temp1 = temp2;
            i++;
        }
        for(int j=0;j<ops-cps;j++){
            res.append(")");
        }
        return String.valueOf(res);
    }
}