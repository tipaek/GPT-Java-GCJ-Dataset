import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

class Solution {
 public static void main(String[] args) throws IOException {
         Scanner scan = new Scanner(System.in);

        int a=scan.nextInt();
        for(int i=0;i<a;i++){
            String numbers=scan.next();
            StringBuilder finalstring=new StringBuilder("");
            for(int j=0;j<Integer.parseInt(numbers.charAt(0)+"");j++){
                finalstring.append('(');
            }
            for(int j=0;j+1<numbers.length();j++){
                finalstring.append(numbers.charAt(j));
                if(Integer.parseInt(numbers.charAt(j+1)+"")-Integer.parseInt(numbers.charAt(j)+"")>=0){
                    int difference=Integer.parseInt(numbers.charAt(j+1)+"")-Integer.parseInt(numbers.charAt(j)+"");
                    for(int z=0;z<difference;z++)
                        finalstring.append('(');
                }
                else {
                    int difference=Integer.parseInt(numbers.charAt(j)+"")-Integer.parseInt(numbers.charAt(j+1)+"");
                    for(int z=0;z<difference;z++)
                        finalstring.append(')');
                }
            }
            finalstring.append(numbers.charAt(numbers.length()-1)+"");
            for(int j=0;j<Integer.parseInt(numbers.charAt(numbers.length()-1)+"");j++)
                finalstring.append(')');
            System.out.println("Case #"+(i+1)+": "+finalstring);
        }
        
    }
}