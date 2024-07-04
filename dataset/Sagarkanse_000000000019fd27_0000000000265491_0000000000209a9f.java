import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {
    private static String getString(String str){
        StringBuilder result = new StringBuilder(str);
        int offset = 0;
        for (int i =0;i<str.length()-1;i++){
            int a=0,b=0,c=0;
            a = Integer.parseInt(String.valueOf(result.charAt(offset+i)));
            b = Integer.parseInt(String.valueOf(result.charAt(offset+i+1)));
            
            c=a-b;
            if(c>0){
                for(int j =0;j<c;j++){
                    result.insert(offset+i+1,")");
                    offset++;
                }
            }else if(c<0){
                for(int j =0;j<(c*-1);j++){
                    result.insert(offset+i+1,"(");
                    offset++;
                }
            }
        }
        int start=Integer.parseInt(String.valueOf(result.charAt(0)));
        for (int j=0;j<start;j++){
           result.insert(0,"(");
        }
        int size = result.length();
        for (int j=0;j<Integer.parseInt(String.valueOf(result.charAt(size-1)));j++){
           result.insert(size,")");
        }
         return new String(result);
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        String t = in.nextLine();
        for (int index = 1; index <= Long.parseLong(t); ++index) {
            String str = in.next();
         System.out.println("Case #" + index + ": " +getString(str));
        }
    }
    
}
