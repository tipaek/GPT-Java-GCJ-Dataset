import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution{
    
    void fillChar(StringBuilder str, String ch,int times){
        for(int i=0;i<times;i++)
            str.append(ch);
    }
    
    void run(){
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        int cnt=0;
        while(cnt<t){
            cnt++;
            String str=sc.next();
            StringBuilder ans=new StringBuilder();
            int prev=-1,open=0;
            for(int i=0;i<str.length();i++){
                int no=str.charAt(i)-48;
                if(prev==-1){
                    fillChar(ans,"(",no);
                    ans.append(str.charAt(i));
                    open=no;
                    prev=no;
                    continue;
                }
                //System.out.println(no+" "+open+" "+prev+" "+ans);
                int diff=open-no;
                if(diff<0){
                    diff=no-open;
                    //fillChar(ans,")",open);
                    //fillChar(ans,"(",no);
                    fillChar(ans,"(",diff);
                    ans.append(str.charAt(i));
                    open=open+diff;
                    prev=no;
                    continue;
                }
                fillChar(ans,")",diff);
                ans.append(str.charAt(i));
                prev=no;
                open-=diff;
            }
            fillChar(ans,")",open);
            System.out.println("Case #"+cnt+": "+ans);
        }
    }
    
    public static void main(String args[]) throws IOException{
        new Solution().run();
    }
}