import java.util.*;
import java.lang.*;

public class Solution {
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        int numberofcase=input.nextInt();
        
        for (int i=1;i<=numberofcase;i++){
            String str=input.next();
            System.out.println(handle(str));
        }
    }
    
    public static String handle(String str){
        StringBuilder sb=new StringBuilder();
        int current=0;
        
        for (int i=0;i<str.length();i++){
            while (current<str.charAt(i)-'0'){
                sb.append('(');
                current++;
            }
            while (current>str.charAt(i)-'0'){
                sb.append(')');
                current--;
            }
            sb.append(str.charAt(i));
        }
        while (current-->0){
            sb.append(')');
        }
        return sb.toString();
    }
}
