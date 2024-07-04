import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Solution {

    public static void main(String[] args) throws Exception {
        // write your code here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            String s = br.readLine();
            String ans=null;
            int ob =0;int cb=0;
            for(int k  =0;k<s.length();k++){
                int cval=Integer.parseInt(String.valueOf(s.charAt(k)));
                if(ans==null){
                    if(cval==0){
                        ans="0";
                        continue;
                    } else{
                        ans = inital(cval);
                        ob = cval;
                        cb=cval-1;
                        continue;
                    }
                }

                int pval = Integer.parseInt(String.valueOf(s.charAt(k-1)));

                if(cval==pval){
                 String prefix = ans.substring(0,ans.length()-cb-1);

                    prefix+=cval;
                 String suffix=ans.substring(ans.length()-cb-1,ans.length());

                 ans=prefix+suffix;

                } else if(cval<pval){
                   String prefix =ans.substring(0,ans.length()-cval);
                   String suffix = ans.substring(ans.length()-cval,ans.length());
                   ans= prefix+cval+suffix;
                   ob= ob-(cval+1);
                }else{
                    String prefix= ans.substring(0,ans.length()-cb-1);
                    String suffix="(";
                   int req =cval-(pval+1);
                   for(int z=0;z<req;z++){
                       suffix+="(";
                   }
                   suffix+=cval+")";
                   for(int z=0;z<(cval-1);z++){
                       suffix+=")";
                   }
                   ans = prefix+suffix;
                   ob=cval;
                   cb=cval-1;
                }



            }
            System.out.println("Case #"+(i+1)+":"+ans);
        }
    }

    static String inital(int val){
        String result = "(";
        for(int i =1;i<=2*val;i++){
            if(i<val){
                result+="(";
            }else if(i==val){
                result+=val;
            }else{
                result+=")";
            }

        }
        return result;

    }
}