import java.util.*;
import java.io.*;
public class Solution{
    public static void main(String[] args){
        Scanner scan = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t =scan.nextInt();
        scan.nextLine();
        for(int f=1;f<=t;f++){
            Stack<String> stack = new Stack<String>();
            StringBuilder sb= new StringBuilder();
            String s = scan.nextLine();
            String[] s1=s.split("");
            //System.out.println(s1.length);
            for(int k=0;k<s1.length;k++){
                int a=Integer.parseInt(s1[k]);
                if(a>=stack.size()){
                    for(int i=0;i<a-stack.size();i++){
                        stack.push("(");
                        sb.append("(");
                    }
                    sb.append(a);
                }else{
                    for(int i=0;i<stack.size()-a;i++){
                        stack.pop();
                        sb.append(")");
                    }
                    sb.append(a);
                }
            
            }
            while(stack.size()>0){stack.pop();sb.append(")");}
            
            System.out.println("Case #"+f+": "+sb.toString());
        }
    }
}