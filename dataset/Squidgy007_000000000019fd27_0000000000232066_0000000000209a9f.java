import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scn=new Scanner(System.in);
        int T=scn.nextInt();
        for(int t=1;t<=T;t++){
            String S=scn.next();
            String outputString="";
            int open=0, close=0;
            for (int i=0;i<S.length();i++){
                char ch=S.charAt(i);
                int temp=Integer.parseInt(String.valueOf(ch));
                if(temp<open){
                    while(temp!=open){
                        outputString=outputString+")";
                        open--;
                    }
                    outputString=outputString+temp;

                }
                else if(temp>open){
                    while(temp!=open){
                        outputString=outputString+"(";
                        open++;
                    }
                    outputString=outputString+temp;
                }
                else{
                    outputString=outputString+temp;
                }
            }
            while(open!=0){
                outputString=outputString+")";
                open--;
            }
            System.out.println("Case #" + t +": "+ outputString);
        }
    }
}
