import java.util.Scanner;

class Solution {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        for (int k = 1; k <= t; k++) {
            String input=sc.next();
            int lengthOfBraces=0,diff=0;
            StringBuilder result=new StringBuilder(10000);
            lengthOfBraces=input.charAt(0)-'0';
            while(lengthOfBraces-->0)
            result.append("(");
            result.append(input.charAt(0));
            for (int i = 1; i < input.length(); i++) {
                diff=(input.charAt(i)-'0')-(input.charAt(i-1)-'0');
                if(diff<0){
                    diff=-(diff);
                    while(diff-->0)
                    result.append(")");
                    result.append(input.charAt(i));
                }
                else if(diff>0){
                    while(diff-->0)
                    result.append("(");
                    result.append(input.charAt(i));
                }
                else
                result.append(input.charAt(i));
            }

            lengthOfBraces=input.charAt(input.length()-1)-'0';
            while(lengthOfBraces-->0)
            result.append(")");
            System.out.println("Case #"+k+": "+ result.toString());
        }
    }
}