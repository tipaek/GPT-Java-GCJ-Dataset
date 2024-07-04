import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;


public class Solution{

    
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String str = "";
        str = sc.nextLine();
        int i=0;
        String finalStr = "";
        for(char c:str.toCharArray()){
            String tmp = String.valueOf(c);
            int num = Character.getNumericValue(c);
            for(i=0;i<num;i++)
                tmp = "(" + tmp + ")";
            finalStr += tmp;
        }
        while(finalStr.contains(")(")){
            finalStr = finalStr.replace(")(","");
        }
        System.out.println(finalStr);
        
    }

}