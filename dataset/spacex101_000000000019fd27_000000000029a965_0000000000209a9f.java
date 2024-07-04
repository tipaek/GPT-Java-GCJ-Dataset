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
            String next = "";
            String finalString = "";
            for(int i = 0; i< numString.length(); i++){
                prev = current;
                current = String.valueOf(numString.charAt(i));
                if(i< (numString.length()-1)){
                    next = String.valueOf(numString.charAt(i+1));
                }
                else{
                    next = "";
                }
                if(prev.equals("")){
                    for(int k = 0; k < Integer.parseInt(current);k++){
                        finalString += "(";
                    } 
                }

                else if((Integer.parseInt(current)-Integer.parseInt(prev))>0){
                    for(int k = 0;k <(Integer.parseInt(current)-Integer.parseInt(prev));k++){
                        finalString += "(";
                    }
                }
                finalString+= Integer.parseInt(current);
                if(!next.equals("")){
                    if((Integer.parseInt(current)-Integer.parseInt(next))>0){
                        for(int k = 0;k <(Integer.parseInt(current)-Integer.parseInt(next));k++){
                            finalString += ")";
                        }
                    }
                }
            }
            for(int i = 0; i< Integer.parseInt(current);i++){
                finalString +=")";
            }
            System.out.println("Case #" + (j+1)+": " +finalString);
        }
    }
}