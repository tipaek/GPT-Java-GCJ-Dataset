import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Solution {
    public static InputStreamReader r=new InputStreamReader(System.in);
    public static BufferedReader br=new BufferedReader(r);
    public static void main(String[] args) throws IOException {
        int t= Integer.parseInt(br.readLine());
        for(int i=1;i<=t;i++){
            System.out.println("Case #"+i+": "+solve());
        }
    }
    public static String solve() throws IOException {
        String S=br.readLine();
        int brackets = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < S.length(); i++) {
            if (S.charAt(i)-'0' == 0) {
                for(int j=0;j<brackets;j++){
                    sb.append(')');
                }
                brackets=0;
                sb.append('0');
            } else if (i == 0) {
                for (int j = 0; j < S.charAt(i) - '0'; j++) {
                    sb.append('(');
                }
                sb.append(S.charAt(i));
                brackets+=S.charAt(i)-'0';
            } else {
                int diff=brackets-(S.charAt(i)-'0');
                if(diff>0){
                    for(int j=0;j<diff;j++){
                        sb.append(')');
                    }
                    brackets-=diff;
                    sb.append(S.charAt(i));
                }else{
                    int tobeadded=(S.charAt(i)-'0')-brackets;
                    for(int j=0;j<tobeadded;j++){
                        sb.append('(');
                    }
                    sb.append(S.charAt(i));
                    brackets+=tobeadded;
                }
            }
        }
        for(int j=0;j<brackets;j++){
            sb.append(')');
        }
        return sb.toString();
    }
}
