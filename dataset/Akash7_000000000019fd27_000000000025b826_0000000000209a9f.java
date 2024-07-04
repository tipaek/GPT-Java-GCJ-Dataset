import java.io.*;
import java.util.*;
class Solution{

    static void makeNest(String s, int testNo){
        String sDash = new String();
        if(s.length()==1){
            for(int i=0;i<(int)s.charAt(0)-48;i++)
                sDash=sDash+"(";
            sDash=sDash+s.charAt(0);
             for(int i=0;i<(int)s.charAt(0)-48;i++)
                sDash=sDash+")";   
        }
        else{
        for(int i=0;i<s.length()-1;i++){
            int c = (int)s.charAt(i) - 48;
            int next = (int)s.charAt(i+1) - 48;
            if(i==0){
                for(int j=0;j<c;j++)
                   sDash=sDash+"(";
                sDash=sDash+s.charAt(i);
                if(c>next){//3cases here   
                  for(int j=0;j<(c-next);j++)
                   sDash=sDash+")";
                }
                else if(c<next){
                  for(int j=0;j<(next-c);j++)
                   sDash=sDash+"(";
                }
                sDash=sDash+s.charAt(i+1);   
            }
            else if(i!=0){

                if(c>next){//3cases here   
                  for(int j=0;j<(c-next);j++)
                   sDash=sDash+")";
                }
                else if(c<next){
                  for(int j=0;j<(next-c);j++)
                   sDash=sDash+"(";
                }
                sDash=sDash+s.charAt(i+1);  

            }                         
        }
        for(int j=0;j<(int)s.charAt(s.length()-1)-48;j++)
             sDash=sDash+")";
        }
        
        PrintWriter writer = new PrintWriter(System.out);    
        writer.write("Case #"+testNo+": "+sDash+"\n");
        writer.flush();
        
    }

    public static void main(String args[])throws IOException{

        InputStreamReader ir = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(ir);
        int t = Integer.parseInt(br.readLine());
        for(int k=1;k<=t;k++){
            String inp = br.readLine();
            makeNest(inp,k);
        }
    }
}

