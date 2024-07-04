import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        scanner.nextLine();
        for(int i=0; i<t; i++) {
            String numStr = scanner.nextLine();
            int length = numStr.length();
            int prevNumber = 0;
            int openingBraces = 0;
            String result = "";
            for(int j=0; j<length; j++) {
                char ch = numStr.charAt(j);
                int num = Integer.parseInt(ch+"");
                int y = prevNumber - num;
                if(y==0) {
                    result += ch;
                }  else if(y<0) {
                    int temp = num - openingBraces;
                    for(int x=0; x<temp; x++) {
                        result += "(";
                    }
                    result+= ch;
                    openingBraces += temp;

                }
                else {
                    for(int x=0;x<y;x++) {
                        result += ")";
                    }
                    result += ch;
                    openingBraces -= y;
                }
                prevNumber = num;
               // System.out.println("Num: "+ num +", Opening Braces: "+ openingBraces);
            }
            for(int x=0;x<openingBraces;x++) {
                result += ")";
            }
            System.out.println("Case #"+(i+1)+": " + result);
        }
    }
}
