import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

final class Solution {

    public static void main(String[] args) {
         
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int cases = in.nextInt();
        System.out.println(cases);
        in.nextLine();  
        for (int i = 0; i < cases; i++) {
            String s = new String();
            s = in.nextLine();
            StringBuilder second = new StringBuilder();
            System.out.println(s);
            int j = 0;
            while( j < s.length()){
               if(Character.getNumericValue(s.charAt(j)) == 1 ){
                    second.append("(");
                    while((Character.getNumericValue(s.charAt(j)) == 1)){
                        second.append("1");
                        j++;
                        if(j == s.length()) break;
                    }
                    second.append(")");
                }
                if(j != s.length()){
                    if(Character.getNumericValue(s.charAt(j)) == 0){
                        second.append("0");
                    }
                j++;
                }
            }

            String last = second.toString();

            System.out.println("Case #" + (i+1) + ": " + last);
            
        }
    }
}