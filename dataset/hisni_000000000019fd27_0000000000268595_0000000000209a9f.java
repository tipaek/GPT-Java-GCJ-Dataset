import java.util.*;
import java.io.*;

public class Solution {    
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();
        String dummy = in.nextLine();

        for (int i = 1; i <= t; ++i) {
            String line = in.nextLine();

            int op = 0;
            String result = "";

            for(int j=0; j<line.length(); j++){
                int temp = j;
                while( temp<line.length()-1 && line.charAt(temp) == line.charAt(temp+1) ) temp++;
                int c = Character.getNumericValue(line.charAt(j));

                if( c>op ){
                    
                    int re = c-op;
                    for(int m=0; m<re;m++){
                        result+= "(";
                        op++;
                    }
                    result += line.charAt(j);
                }else{
                    result += line.charAt(j);
                }

                if( j!=temp ){
                    j++;
                    while( j<=temp ) {
                        result += line.charAt(j);
                        j++;
                    }
                }
                j=temp;

                temp++;
                if( temp < line.length() ){
                    int cn = Character.getNumericValue(line.charAt(temp));
                    
                    if( c > cn ){
                        int re = c-cn;
                        for(int m =0;m< re;m++){
                            result+= ")";
                            op--;
                        }
                    }
                }
            }
            
            while( op!=0 ){
                result += ")";
                op--; 
            }           

            System.out.println("Case #" + i + ": " + result );
        }
    }
}
