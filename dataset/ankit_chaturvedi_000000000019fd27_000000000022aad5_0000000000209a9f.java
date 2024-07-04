import java.util.*;
import java.lang.*;
import java.io.*;
class Solution{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        int count = 1;
        StringBuffer sbuf = new StringBuffer();
        while(t-->0){
            String  value = br.readLine();
            int open=0,closed=0;
            List<Character> list = new ArrayList<>();
            
            for(int i=0;i<value.length();i++){
                int digit = Character. getNumericValue(value.charAt(i));
                
                if(digit==0){
                    
                    for(int k=open;k>0;k--)
                    list.add(')');
                    list.add(value.charAt(i));
                    open = 0;
                }
                
                
                else if(digit>open){
                    for(int k=open;k<digit;k++){
                        list.add('(');
                    }
                    list.add(value.charAt(i));
                    open = digit;
                }
                else if(digit<open){
                    
                    list.add(')');
                    list.add(value.charAt(i));
                    open--;
                }
                else if(digit==open){
                    list.add(value.charAt(i));

                }
                 
                
                
            }
            
            if(open!=0){
                for(int k=open;k>0;k--)
                list.add(')');
            }
            
             sbuf.append("Case #"+count+": ");
            
             for(int i=0;i<list.size();i++)
             sbuf.append(list.get(i));
             
             sbuf.append("\n");
            count++;
        }
        System.out.println(sbuf);

    }
}