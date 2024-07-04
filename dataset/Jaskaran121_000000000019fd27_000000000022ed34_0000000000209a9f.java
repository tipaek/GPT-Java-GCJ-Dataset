import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Scanner;

public class Solution {

    public static String calculate(String string){
        char[] array = string.toCharArray();

        String result = "";
        for(int i=0;i<array.length;i++){
            int num = Character.getNumericValue(array[i]);
            int count = 0;
            if(num ==1) result+="(";
            if(i == array.length-1){
                result+=array[i];
            }
            while(true && i+1 != array.length){
                if(array[i] == array[i+1]) {
                    //System.out.println(i+"-"+count);
                    result+=array[i];
                    count++;
                    i++;
                    if(i == array.length-1) result+=array[i];
                }
                else
                {
                    result+=array[i];
                    break;
                }
            }
            if(num ==1) result+=")";
        }

        return result;
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        in.nextLine();
        String[] result = new String[t];
        for (int i = 0; i <t; i++) {
            String string = in.nextLine();
            result[i] = calculate(string);
        }

        for(int i=1;i<=t;i++){
            System.out.print("Case #" + i + ": " + result[i-1]);
            if(i!=t)
                System.out.println("");
        }
    }
}
