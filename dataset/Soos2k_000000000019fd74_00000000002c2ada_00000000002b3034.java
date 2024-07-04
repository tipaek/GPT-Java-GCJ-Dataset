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
                arr[j] = sc.nextLine().substring(1);
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
        String maxStr = "";
        for (int i = 0; i < arr.length; i++){
            if (arr[i].length() > maxStr.length()){
                maxStr = arr[i];
            }
        }
        boolean contain = true;
        for (int i = 0; i < arr.length; i++){
            if (!maxStr.contains(arr[i])){
                contain = false;
                break;
            }
        }
        if (!contain) return "*";
        return maxStr;
    }
}