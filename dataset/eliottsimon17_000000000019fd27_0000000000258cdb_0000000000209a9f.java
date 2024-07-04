import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args){
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCount = Integer.parseInt(in.next());
        in.nextLine();
        for(int i = 0 ; i < testCount ; i++){
            String s = in.nextLine();
            String brackets = getBrackets(s);
            System.out.println("Case #" + (i+1) + ": " + brackets);
        }
    }
    public static String getBrackets(String s){

        String newString = "";
        boolean flag = false;
        for(int i = 0 ; i < s.length(); i++){
            int c = Integer.parseInt(String.valueOf(s.charAt(i)));
            if(c == 1 && flag == false){
                newString += "("+ s.charAt(i);
                flag = true;
            }
            else if (c == 1 && flag == true){
                newString += s.charAt(i);
            }
            else if (c == 0 && flag == true){
                newString += ")"+s.charAt(i);
                flag = false;
            }
            else{
                newString += s.charAt(i);
            }
        }
        //Last CASE
        if(Integer.parseInt(String.valueOf(s.charAt(s.length()-1)))==1){
            newString+= ")";
        }
        return newString;
    }
}
// java JAM2 <test2.txt> out2.txt