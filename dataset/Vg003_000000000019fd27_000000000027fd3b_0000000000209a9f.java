import java.util.*;
import java.io.*;
class Solution{
    static String ogen(int x){
        String s="";
        for(int i=0;i<x;i++){
            s+='(';
        }
        return s;
    }
    
    static String cgen(int x){
        String s="";
        for(int i=0;i<x;i++){
            s+=')';
        }
        return s;
    }
    public static void main(String[] args) throws IOException{
        BufferedReader b  = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(b.readLine());
        int k=0;
        
        while(t--!=0){
            
            String s = b.readLine();
            
            String ans = "";
            int prev=0;
            int tC=0;
            for(int i=0;i<s.length();i++){
                
                int curr = s.charAt(i)-48;
                if(curr==prev){
                    ans+=curr+"";
                }
                else if(curr>prev){
                    ans+=ogen(curr-prev)+curr+"";
                    tC+= (curr-prev);
                }
                else{
                    ans+=cgen(prev-curr)+curr+"";
                    tC -= (prev-curr); 
                }
                prev = curr;
            }
            ans+= cgen(tC);
            
            System.out.println("Case #"+ (++k)+": "+ans);
            
        }
    }
}