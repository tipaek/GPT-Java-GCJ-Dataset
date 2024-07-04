import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        for(int z = 0;z<t;z++) {

            String s = sc.next();
            StringBuffer sb = new StringBuffer();
            for(int i=0;i<s.length();i++) {
                int temp = Integer.parseInt(s.substring(i,i+1));
                for(int j = 0;j<temp;j++) {
                    sb.append("(");
                }
                sb.append(temp);
                for(int j = 0;j<temp;j++) {
                    sb.append(")");
                }
            }
            
            for (int i=0;i<sb.length();i++) {
                if(i != sb.length()-1 && sb.charAt(i) == ')' && sb.charAt(i+1) == '(') {
                    sb.delete(i,i+2);
                    i = 0;
                }
            }

            System.out.println("Case #"+(z+1)+": " + sb);
        }
    }
}
