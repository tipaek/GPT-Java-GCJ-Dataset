import java.util.*;
import java.io.*;

public class Solution {
    static Scanner scanner;
    public static void main(String[] args) {
        scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int tests = scanner.nextInt();

        for(int j = 0; j <tests; j++){
            String numString = scanner.next();
            String prev = "";
            String current = "";
            String finalString = "";
            for(int i = 0; i< numString.length(); i++){
                prev = current;
                current = String.valueOf(numString.charAt(i));
                if((prev.equals("1"))&& current.equals("1")){
                    finalString += "1";
                }
                else if(((prev.equals(""))|| prev.equals("0")) && current.equals("1")){
                    finalString+="(1";
                }
                else if((prev.equals(""))&& current.equals("0")){
                    finalString+="0";
                }
                else if(( prev.equals("0"))&& current.equals("0")){
                    finalString+="0";
                }
                else if((prev.equals("1"))&& current.equals("0")){
                    finalString+=")0";
                }
            }
            if(current.equals("1")){
                finalString+= ")";
            }
            System.out.println("Case #" + (j+1)+": " +finalString);
        }
    }
}