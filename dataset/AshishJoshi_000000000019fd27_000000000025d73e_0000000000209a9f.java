import java.io.*;
import java.util.*;

public class Solution{
    public static void main(String args[]){
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        scan.nextLine();
        for(int i=1; i<=t; i++){
            String str = scan.nextLine();
            int temp = 0, prevChar = 0;
            boolean first = true;
            StringBuilder finalStr = new StringBuilder();
            for (int j=0; j<str.length(); j++) {
                temp = Integer.parseInt(str.charAt(j)+"");
                if (first) {
                    while (temp!=0) {
                        finalStr.append("(");
                        temp--;
                    }
                    finalStr.append(str.charAt(j));
                    first = false;
                } else {
                    prevChar = Integer.parseInt(str.charAt(j-1)+"");
                    temp = Integer.parseInt(str.charAt(j)+"");
                    if (prevChar == temp) {
                        finalStr.append(str.charAt(j));
                    } else if (prevChar>temp) {
                        int diff = prevChar - temp;
                        while (diff!=0){
                            finalStr.append(")");
                            diff--;
                        }
                        finalStr.append(str.charAt(j));
                    } else {
                        int diff = temp - prevChar;
                        while (diff != 0) {
                            finalStr.append("(");
                            diff--;
                        }
                        finalStr.append(str.charAt(j));
                    }
                }
            }
            int lastChar = Integer.parseInt(str.charAt(str.length()-1)+"");
            if (lastChar>0) {
                while (lastChar != 0) {
                    finalStr.append(")");
                    lastChar--;
                }
            }
            System.out.println("Case #"+i+": "+finalStr.toString());
        }
    }
}