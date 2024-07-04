import java.util.*;
public class Solution{
    public static String getstr(String s){
        String res="";
        Stack<String>stk=new Stack<>();
        int n=s.length();
        for(int i=0;i<n;i++)
        {
            char c=s.charAt(i);
            int cur=(int)(c-48);
            while(stk.size()<cur)
            {
                stk.push("(");
                res=res+"(";
            }
            while(stk.size()>cur)
            {
                stk.pop();
                res=res+")";
            }
            if(stk.size()==cur)
                res=res+c;
        }
        while(!stk.isEmpty()){
            res=res+")";
            stk.pop();
        }
        return res;
    }
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        for(int i=1;i<=t;i++)
            System.out.println("Case #"+i+": "+getstr(sc.next()));
    }
}