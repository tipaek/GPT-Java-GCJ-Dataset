import java.util.*;
import java.io.*;
public class Solution{

     public static void main(String []args){
        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = sc.nextInt();
        int count = 1;
        while(t-->0){
            String s = sc.next();
            StringBuilder sb = new StringBuilder();
            for(int i=0; i<s.length(); i++){
                int a = Character.getNumericValue(s.charAt(i));
                for(int j=0; j<a; j++){
                    sb.append('(');
                }
                sb.append(s.charAt(i));
                for(int j=0; j<a; j++){
                    sb.append(')');
                }
            }
            String string = sb.toString();
            String[] arrOfStr = string.split("\\)\\(");
            StringBuilder str = new StringBuilder();
            for(String b: arrOfStr){
                str.append(b);
            }
            System.out.println("Case #"+count+":"+" "+str);
            count++;
        }
     }
}