import java.util.*;
import java.io.*;
import java.lang.*;

public class Solution {

    public static void main(String[] args) throws Exception {
        try {
            InputStreamReader isr = new InputStreamReader(System.in);
            BufferedReader br = new BufferedReader(isr);
            
            int test = Integer.parseInt(br.readLine());
            
            for(int t=1; t<=test; t++){
                
                String str[] = br.readLine().split("");
                String ans ="";
                int cnt=0;
                for(String s : str){
                    int num = Integer.parseInt(s);
                    if(num-cnt>0){
                        for(;cnt<num;cnt++){
                            ans += "(";
                        }
                        ans += num;
                    }
                    else if(num-cnt==0){
                        ans += num;
                    }
                    else{
                        for(;cnt>num;cnt--){
                            ans +=")";
                        }
                        ans += num;
                    }
                }
                for(;cnt>0;cnt--){
                    ans+=")";
                }
                System.out.println("Case #" + t+":"+" "+ ans);
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
