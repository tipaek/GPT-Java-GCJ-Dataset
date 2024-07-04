import java.lang.reflect.Array;
import java.util.*;
public class Solution{
    public static void main(String [] args){
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        for(int i = 1; i <= t; i++){
            String s = scanner.next();
            String sp = "";
            int hanging = 0;
            for(int j = 0; j < s.length(); j++){
                int digit = Character.getNumericValue(s.charAt(j));
                if(hanging > digit){
                    int temp = hanging - digit;
                    while(temp > 0){
                        sp += ")";
                        temp--;
                    }
                    hanging -= (hanging - digit);
                }
                else if(hanging < digit){
                    int temp = digit - hanging;
                    while(temp > 0){
                        sp += "(";
                        temp--;
                    }
                    hanging += (digit - hanging);
                }
                sp += Character.toString(s.charAt(j));
            }
            int temp = hanging;
            while(temp > 0){
                sp += ")";
                temp--;
            }
            System.out.println("Case #" + i + ": " + sp);
        }
    }
}