import java.util.*;
import java.io.*;
class Solution{
    public static void main(String[] args) throws IOException{
        BufferedReader b  = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(b.readLine());
        int k=0;
        while(t--!=0){
            
            String s = b.readLine();
            
            String ans = "";
            
            for(int i=0;i<s.length();){
                if(s.charAt(i)=='0'){
                    ans+= '0';
                    i++;
                }
                else{
                    ans+='(';
                    while(i<s.length() && s.charAt(i)=='1'){
                        ans+='1';
                        i++;
                    }
                    ans+=')';
                }
            }
            
            
            
            
            
            System.out.println("Case #"+ (++k)+": "+ans);
            
        }
    }
}