import java.util.*;
public class Solution {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int cases = sc.nextInt();
        String[] results = new String[cases];
        for (int i = 0; i < cases; i++){
            int n = sc.nextInt();
            sc.nextLine();
            String[] arr = new String[n];
            for (int j = 0; j < n; j++){
                arr[j] = sc.nextLine();
            }
            String result = "";
            results[i] = "Case #" + (i+1) + ": " + findStr(arr);
        }
        sc.close();
        for (String str : results){
            System.out.println(str);
        }
    }
    public static String findStr(String[] arr){
        String maxStr = arr[0];
        for (int i = 1; i < arr.length; i++){
            maxStr = union(maxStr, arr[i]);
            if (maxStr == null) return "*";
        }
        int index = maxStr.indexOf("*");
        return maxStr.substring(0, index) + maxStr.substring(index+1);
    }
    public static String union(String str1, String str2){
        int getAsterisk1 = str1.indexOf("*");
        int getAsterisk2 = str2.indexOf("*");
        String part1 = "";
        String part2 = "";
        String part11 = str1.substring(0,getAsterisk1);
        String part12 = str1.substring(getAsterisk1+1);
        String part21 = str2.substring(0,getAsterisk2);
        String part22 = str2.substring(getAsterisk2+1);
        if (part11.contains(part21)) {
            part1 = part11;
        }
        else if (part21.contains(part11)){
            part1 = part21;
        }
        else {
            return null;
        }
        if (part12.contains(part22)) {
            part2 = part12;
        }
        else if (part22.contains(part12)){
            part2 = part22;
        }
        else {
            return null;
        }
        return part1 + "*" + part2;
    }
}