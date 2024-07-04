import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.io.*;
public class Solution {
  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
    for (int i = 1; i <= t; i++) {//i
        String S=in.next();//string inputted
        String temp=S;
        boolean end=false;
        int num=0;
        int iter=0;
        while(end!=true){
            //System.out.println("iter="+iter+"char="+(temp.charAt(iter))+"temp:"+temp);
            int n1=Integer.parseInt(""+temp.charAt(iter));
            //System.out.println("n1="+n1);
            for(int j=1;j<=n1;j++){
                String fron=temp.substring(0,iter);
                String back=temp.substring(iter);
                temp=fron+"("+back;
                iter++;
            }
            //System.out.println("iter:"+iter+" temp:"+temp);
            iter++;
            for(int j=1;j<=n1;j++){
                String fron=temp.substring(0,iter);
                String back=temp.substring(iter);
                //System.out.println("fron="+fron+" back="+back+" temp:"+temp+" iter="+(iter+1));
                temp=fron+")"+back;
                iter++;
            }
            num++;
            if(num==S.length()){
                end=true;
            }
        }//temp is now bracketed string
        boolean done=false;
        String rep=")(";
        while(done!=true){
            // System.out.println("flag");
            String t1=temp;
            // //String rep = Pattern.quote(")(");
            // String regex = "\\)\\(";
            // temp.replaceAll(regex,"");
            // System.out.println("temp:"+temp);
            // if(t1==temp){
            //     done=true;
            // }
            for(int j=0;j<temp.length()-1;j++){
                if(temp.charAt(j)==')'&&temp.charAt(j+1)=='('){
                    String fron=temp.substring(0,j);
                    String back=temp.substring(j+2);
                    temp=fron+back;
                }
            }
            if(temp==t1){
                done=true;
            }
        }
        //System.out.println(""+temp);
        System.out.println("Case #" + i + ": " + temp);
    }
  }
}