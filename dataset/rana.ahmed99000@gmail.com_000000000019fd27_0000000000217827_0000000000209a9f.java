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
        int open = 0, i, diff = 0,n;
        char[] chars = s.toCharArray();
        for(i =0 ; i< chars.length;i++){
           c = chars[i];
           if(c == '0'){

            while(open >0){
                sDash = sDash + ")";
                open--;
            }
               sDash = sDash + c;
           }
           else {
               String sub = c+ "";
               while(i< chars.length-1 && c == chars[i+1]){
                   sub = sub + chars[i+1];
                   i++;
               }
               n = Character.getNumericValue(c);
               diff = n - open;
               if(diff > 0){
                   for(int j =0;j<diff;j++){
                       sDash = sDash + "(";
                       open++;
                   }
                   sDash = sDash + sub;
               }else {

                   for(int j =0;j<diff*-1;j++){
                       sDash = sDash + ")";
                       open--;
                   }
                   sDash = sDash + sub;
               }
           }
        }
        while(open >0){
            sDash = sDash + ")";
            open--;
        }
        return sDash;
    }
}