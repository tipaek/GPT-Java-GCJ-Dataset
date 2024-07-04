import java.util.Scanner;

public class Solution {

    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int T=Integer.parseInt(sc.nextLine());
        int x=1;
        while(T>0){
            String input=sc.nextLine();
            String output="";
            int openBracketCount=0;
            int len=input.length();
            for(int i=0;i<len;i++){
                if(input.charAt(i)=='0'){
                    while(openBracketCount>0){
                        output+=")";
                        openBracketCount--;
                    }
                    output+=input.charAt(i);
                }
                else if(i>0 && input.charAt(i-1)==input.charAt(i)){
                    output+=input.charAt(i);
                }
                else{
                    output+="("+input.charAt(i);
                    openBracketCount++;
                }
            }
            while(openBracketCount>0){
                output+=")";
                openBracketCount--;
            }

            System.out.println("Case #"+x+": "+output);
            T--;
            x++;
        }
    }
}