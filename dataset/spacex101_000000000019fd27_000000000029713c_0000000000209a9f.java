import java.util.*;
import java.io.*;

public class Solution {
    static Scanner scanner;
    static ArrayList<String> list = new ArrayList<String>();
    public static void main(String[] args) {
        scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int tests = scanner.nextInt();

        for(int j = 0; j <tests; j++){
            String numString = scanner.next();
            // System.out.println(numString);
            String prev = "";
            String current = "";
            int index = 0;
            String finalString = "";
            for(int i = 0; i< numString.length(); i++){
                prev = current;
                current = String.valueOf(numString.charAt(i));
                if((prev.equals("1"))&& current.equals("1")){
                    finalString += "1";
                    System.out.println("scraa");
                }
                else if(((prev.equals(""))|| prev.equals("0")) && current.equals("1")){
                    finalString+="(1";
                    System.out.println("oof");
                }
                else if((prev.equals(""))&& current.equals("0")){
                    finalString+="0";
                    System.out.println("zoom");
                }
                else if(( prev.equals("0"))&& current.equals("0")){
                    finalString+="0";
                    System.out.println("hmm");
                }
                else if((prev.equals("1"))&& current.equals("0")){
                    finalString+=")0";
                    System.out.println("pfft");
                }
            }
            if(current.equals("1")){
                finalString+= ")";
            }
            System.out.println("Case #" + (j+1)+": " +finalString);
        }
    }
}