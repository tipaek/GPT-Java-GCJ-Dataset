import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        sc.nextLine();
        for (int k = 1; k <= x; k++) {
            String n = sc.nextLine();
            System.out.println("Case #" + k + ": " + findSDash(n));
        }
    }

    public static String findSDash(String s) {
        String sDash = "";
        char c;
        char[] chars = s.toCharArray();
        for(int i = 0; i< chars.length;i++){
           c = chars[i];
           if(c == '0')
               sDash = sDash + c;
           else {
               String sub = c+ "";
               while(i< chars.length-1 && c == chars[i+1]){
                   sub = sub + chars[i+1];
                   i++;
               }
               int n = Character.getNumericValue(c);
               for(int j =0;j<n;j++){
                   sDash = sDash + "(";
               }
               sDash = sDash + sub;
               for(int j =0;j<n;j++){
                   sDash = sDash + ")";
               }
           }
        }
        return sDash;
    }
}