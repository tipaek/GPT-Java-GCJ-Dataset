import java.util.*;
import java.io.*;
public class Solution {
  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int t = in.nextInt();
    in.nextLine();
    for (int numCase = 1; numCase <= t; numCase++) {
        String input = in.nextLine();
        StringBuilder sb = new StringBuilder();
        int lastDigit = 0;
        for(int i = 0; i < input.length(); i++){
            int digit = input.charAt(i) - '0';
            int diff = digit - lastDigit;
            if(diff > 0){
                while(diff > 0){
                    sb.append("(");
                    diff--;
                }
            }else if(diff < 0){
                while(diff < 0){
                    sb.append(")");
                    diff++;
                }
            }
            sb.append(input.charAt(i));
            lastDigit = digit;
        }
        while(lastDigit > 0){
            sb.append(")");
            lastDigit--;
        }
        
        System.out.println("Case #" + numCase + ": " + sb.toString());
    }
  }
}