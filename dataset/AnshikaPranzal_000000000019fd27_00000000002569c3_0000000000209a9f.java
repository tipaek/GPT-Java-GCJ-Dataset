import java.lang.*;
import java.util.*;
public class Solution {

    static String a;

    public static void main(String[] args) {
        int t, n, m ,min,s,f,j,b;
        Scanner sc = new Scanner(System.in);
        t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            if(i==0)
            sc.nextLine();
            a = sc.nextLine();
            char[] ch = a.toCharArray();
            ArrayList<Character> al = new ArrayList<Character>();
            for (int k = 0; k < ch.length ; k++) {
                for (int l = 0; l <  Character.getNumericValue(a.charAt(k)) ; l++) {
                    al.add('(');
                }
                al.add(a.charAt(k));
                for (int l = 0; l <  Character.getNumericValue(a.charAt(k)) ; l++) {
                    al.add(')');
                }
            }
            StringBuffer sb = new StringBuffer();

            for (Character sr : al) {
                sb.append(sr);
            }

        while(sb.indexOf(")(")!= -1){
            sb.delete(sb.indexOf(")("), sb.indexOf(")(")+2);
        }
        System.out.println("Case #"+(i+1)+": "+sb);
        }
    }

}