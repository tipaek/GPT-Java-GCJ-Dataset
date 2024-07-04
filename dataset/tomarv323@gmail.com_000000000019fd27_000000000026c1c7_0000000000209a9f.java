import java.io.*;
import java.util.*;

public class Solution{
    public static void main(String [] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        
        for(int p=1; p<=t; p++){
            String str = br.readLine();
            
            StringBuffer ans = new StringBuffer();
            Stack<Character> stack = new Stack<>();
            for(int i=0; i<str.length(); i++){
                int num = str.charAt(i)-'0';
                if(num==0){
                    while(!stack.isEmpty()){
                        ans.append(")");
                        stack.pop();
                    }
                    
                }else if(num < stack.size()){
                    int d = stack.size()- num;
                    while(d-- >0){
                        ans.append(")");
                        stack.pop();
                    }
                }else{
                    int d = num - stack.size();
                    while(d-- >0){
                        ans.append("(");
                        stack.push('(');
                    }
                }
                
                ans.append(Integer.toString(num));
            }
            
            while(!stack.isEmpty()){
                        ans.append(")");
                        stack.pop();
            }
            
            System.out.println("Case #"+ p+": "+ ans);
            
        }
    }
}