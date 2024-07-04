import java.util.*;
public class Solution{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int c = 1;
        while(c<=t){
            String s = sc.next();
            int open = 0;
            int length = s.length();
            String output="";
            for(int i=0;i<length;i++){
                int num = s.charAt(i)-48;
                if(num>open){
                    int diff = num-open;
                    open+=diff;
                    while(diff--!=0){
                        output+="(";
                    }
                }else if(num<open){
                    int diff = open-num;
                    open-=diff;
                    while(diff--!=0){
                        output+=")";
                    }
                }
                output+=s.charAt(i);
            }
            while(open--!=0){
                output+=")";
            }
            System.out.println("Case #"+c+": "+output);
            c++;
        }
    }
}