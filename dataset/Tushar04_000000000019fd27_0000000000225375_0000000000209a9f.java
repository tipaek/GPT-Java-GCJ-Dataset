import java.util.*;
public class Solution{
    public static void main(String[] args)throws Exception{
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int k=t;
        while(t-->0){
            String s = sc.next();
            int op=0;
            StringBuilder sb = new StringBuilder();
            for(int i=0;i<s.length();i++){
                int ch = s.charAt(i) -'0';
                if(ch == op){
                    sb.append(ch);
                }else if(ch > op){
                    while(ch != op){
                        sb.append('(');
                        op++;
                    }
                    sb.append(ch);
                }else{
                    while(ch != op){
                        sb.append(')');
                        op--;
                    }
                    sb.append(ch);
                }
            }
            while(op!=0){
                sb.append(')');
                op--;
            }
            System.out.println("Case #"+(k-t)+": "+sb.toString());
        }
    }
}

