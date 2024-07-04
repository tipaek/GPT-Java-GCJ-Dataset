import java.util.Scanner;
import java.io.*;

public class Solution{
    
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine();
        
        for(int i = 1; i <= t; i ++){
            String s = sc.nextLine();
            String s1 = new String();
            int opened = 0;
            
            for(int j = 0; j < s.length(); j ++){
                int num = Character.getNumericValue(s.charAt(j));
                while(num > opened){
                    s1 = s1 + '(';
                    opened ++;
                }
                while(num < opened){
                    s1 = s1 + ')';
                    opened --;
                }
                s1 = s1 + s.charAt(j);
            }
            
            while(opened > 0){
                s1 = s1 + ')';
                opened --;
            }
            
            System.out.println("Case #" + i + ": " + s1);
        }
        
        sc.close();
    }
}