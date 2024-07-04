import java.util.Scanner;

public class Solution {
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        int T=sc.nextInt();
        for(int t=1;t<=T;t++){
            String input=sc.next(),res="";
            int count=0;
            for(int i=0;i<input.length();i++){
                while(input.charAt(i)-'0'>count){
                    res+="(";
                    count++;
                }
                while(input.charAt(i)-'0'<count){
                    res+=")";
                    count--;
                }
                res+=input.charAt(i);
            }
            while(count>0){
                res+=")";
                count--;
            }
            System.out.println("Case #"+t+": "+res);
        }
    }
}
