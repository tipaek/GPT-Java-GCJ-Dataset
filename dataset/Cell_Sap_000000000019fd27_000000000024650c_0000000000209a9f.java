import java.util.*;
import java.io.*;
public class Solution{
    public static void main(String args[]) throws Exception{
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for(int m = 1;m <= t;m++){
            String s = sc.next();
            String res = "";
            for(int i = 0;i<s.length();i++){
                int ch = s.charAt(i);
                int z = Integer.parseInt("" + s.charAt(i));
                if(z==0){
                    res = res + z;
                    continue;
                }
                if(i == 0){
                    String arr[] = addBrackets(z);
                    res = arr[0] + z + arr[1];
                    continue;
                }
                int ch1 = s.charAt(i-1);
                int z1 = Integer.parseInt("" + s.charAt(i-1));
                int k = res.length() - 1;
                if(z1 == 0){
                    String arr[] = addBrackets(z);
                    res = res + arr[0] + z + arr[1];
                }
                else if(ch == ch1){
                    res = res.substring(0,res.lastIndexOf(ch1)+1) + z +res.substring(res.lastIndexOf(ch1)+1); 
                }
                else if(ch > ch1){
                    String arr[] = addBrackets(z - z1);
                    res = res.substring(0,res.lastIndexOf(ch1)+1) + arr[0] + z + arr[1] + 
                    res.substring(res.lastIndexOf(ch1)+1); 
                }
                else if (ch < ch1){
                     res = res.substring(0,res.length() - z) + z + res.substring(res.length() - z);
                }
            }
            System.out.println("Case #" + m +": " + res);
        }
    }
    
    public static String[] addBrackets(int p){
        String arr[] = new String[2];
        if(p==0)
            return arr;
        arr[0] = "(";
        arr[1] = ")";
        for(int i = 2;i<=p;i++){
            arr[0] += "(";
            arr[1] += ")";
        }
        return arr;
    }
}