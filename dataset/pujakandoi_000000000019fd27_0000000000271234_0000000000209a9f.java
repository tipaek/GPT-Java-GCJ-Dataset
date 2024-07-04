import java.util.*;
public class Solution{
    public static void main(String[] args){
        Scanner s=new Scanner(System.in);
        int t=s.nextInt();
        for(int k=1;k<=t;k++){
            String str="";
            String input=s.next();
            int count=0;
            for(char ch:input.toCharArray()){
                int brac=ch-'0';
                while(count<brac){
                    str+="(";
                    count++;
                }
                while(count>brac){
                    str+=")";
                    count--;
                }
                str+=ch;
            }
            while(count>0){
                str+=")";
                count--;
            }
            System.out.println("Case #"+k+": "+str);
        }
    }
}