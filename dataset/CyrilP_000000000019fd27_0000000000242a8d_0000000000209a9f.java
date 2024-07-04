import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        sc.nextLine();
        StringBuilder sb = new StringBuilder();
        for(int t = 0; t<T; t++){
            sb.append(String.format("Case #%d: ", t+1));
            String s = sc.nextLine();
            int opened = 0;
            for(int i = 0; i<s.length(); i++){
                int n = s.charAt(i)-48;
                if(n > opened){
                    for(int j = opened; j<n; j++){
                        sb.append("(");
                    }
                    opened = n;
                    sb.append(n);
                    if(i==s.length()-1){
                        for(int j = 0; j<opened; j++){
                            sb.append(")");
                        }
                    }
                }
                else if(n < opened){
                    for(int j = opened; j>n; j--){
                        sb.append(")");
                    }
                    opened = n;
                    sb.append(n);
                    if(i==s.length()-1){
                        for(int j = 0; j<opened; j++){
                            sb.append(")");
                        }
                    }
                }
                else{
                    sb.append(n);
                    if(i==s.length()-1){
                        for(int j = 0; j<opened; j++){
                            sb.append(")");
                        }
                    }
                }
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
