import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int a = s.nextInt();
        for (int i = 0; i < a; i++) {
            String b = s.next();
            int curropen = 0;
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < b.length(); j++) {
                if (curropen < (b.charAt(j) - '0'))
                    for (int k = curropen; k < (b.charAt(j) - '0'); k++) {
                        sb.append('(');
                    curropen++;
                    }
                 else if(curropen > (b.charAt(j) - '0'))
                    for (int k = curropen; curropen!=( b.charAt(j) - '0'); k--) {
                        sb.append(')');
                    curropen--;
                    }
                    sb.append(b.charAt(j)-'0');
            }
            while(curropen!=0){
                sb.append(')');
                curropen--;
            }
            System.out.println("Case #"+(i+1)+": "+sb.toString());

        }
    }
}
