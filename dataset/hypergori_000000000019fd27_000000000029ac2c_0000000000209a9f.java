import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for (int i = 0; i < T; i++) {
            String S = sc.next();

            int[] arr = new int[S.length()+2];
            for (int j = 1; j <= S.length(); j++) {
                arr[j] = S.charAt(j-1)-'0';
            }

            StringBuilder sb = new StringBuilder();
            for (int j = 0; j <= S.length() ; j++) {
                int diff = arr[j+1] - arr[j];
                if(diff>0){
                    for (int k = 0; k < diff ; k++) {
                        sb.append("(");
                    }
                }else if(diff<0){
                    for (int k = 0; k < Math.abs(diff) ; k++) {
                        sb.append(")");
                    }
                }
                if(j<S.length())
                sb.append(S.charAt(j));
            }

            System.out.println("Case #"+(i+1)+": " + sb.toString()  );

        }

    }
}