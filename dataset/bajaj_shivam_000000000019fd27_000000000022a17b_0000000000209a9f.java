import java.util.Scanner;
import java.util.Stack;

public class Solution {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        for(int tt=1;tt<=t;tt++){
            String s=sc.next();
            StringBuilder ans=new StringBuilder("");
            int opening=0;
            for(int i=0;i<s.length();i++){
                int next=Integer.parseInt(s.charAt(i)+"");
                if(opening==next){
                    ans.append(next);
                }else if(opening>next){
                    while (opening>next){
                        ans.append(")");
                        opening--;
                    }
                    ans.append(next);
                }else{
                    while (opening<next){
                        ans.append("(");
                        opening++;
                    }
                    ans.append(next);
                }
            }
            while (opening>0){
                ans.append(")");
                opening--;
            }

            System.out.println("Case #"+tt+": "+ans);
        }
    }
}
