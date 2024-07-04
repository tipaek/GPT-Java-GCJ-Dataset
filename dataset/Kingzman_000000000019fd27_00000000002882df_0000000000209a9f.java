import java.io.*;
import java.util.*;
class Solution{
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        int cas = 0;
        while(++cas<=t){
            String s = br.readLine();
            System.out.print("Case #"+cas+": ");
            int open = 0;
            for(int i=0; i<s.length(); i++){
                if(s.charAt(i)-48>open){
                    while(open!=s.charAt(i)-48){
                        System.out.print("(");
                        open++;
                    }
                        
                }
                else if(s.charAt(i)-48<open){
                    while(open!=s.charAt(i)-48){
                        System.out.print(")");
                        open--;
                    }
                        
                }
                else if(s.charAt(i)-48==0){
                    while(open!=0){
                        System.out.print(")");
                        open--;
                    }
                }
                System.out.print(s.charAt(i));
            }
            while(open!=0){
                System.out.print(")");
                open--;
            }
            System.out.println();
        }
    }
}