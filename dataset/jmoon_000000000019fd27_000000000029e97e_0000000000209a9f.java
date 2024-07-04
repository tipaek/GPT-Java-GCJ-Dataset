import java.io.*;
import java.util.*;
import java.math.*;
public class Solution {
    
    static int [] consecDiff(int [] arr){
        int diff [] = new int [arr.length+1];
        int curr = 0;
        for (int i = 0; i < arr.length; i++) {
            diff[i] = arr[i] - curr;
            curr = arr[i];
        }
        diff[arr.length] = 0 - arr[arr.length-1];
        return diff;
    }
    static int [] parseString(String s) {
        int [] arr = new int [s.length()];
        for (int i = 0; i < s.length(); i++) {
            arr[i] = Integer.parseInt(s.substring(i,i+1));
        }
        return arr;
    }
    static String NestedDepth(String s) {
        String ans = "";
        int [] arr = parseString(s);
        int [] diffarray = consecDiff(arr);
        for (int i = 0; i < diffarray.length; i++){
            if (diffarray[i] > 0) {
                for (int j = 0; j < diffarray[i]; j++){
                    ans += "(";
                }
            }
            else if (diffarray[i] < 0) {
                for (int j = 0; j < -1 * diffarray[i]; j++){
                    ans += ")";
                }
            }
            if (i < arr.length) {
                ans+= arr[i];
            }
        }
        return ans;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

        int t = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < t; i++){
            String s = scanner.nextLine();
            System.out.println(String.format("Case #%d: %s", i+1, NestedDepth(s)));
        }

    }
    
}

