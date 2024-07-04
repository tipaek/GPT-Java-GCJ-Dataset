import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int T = in.nextInt();

        for(int i=1;i<=T;i++){
            String input = in.next();
            printOutput(i,input);
        }

    }
    private static void printOutput(int T,String input) {
        StringBuilder sb=new StringBuilder();
        int l=0;
        for(int i=0;i<input.length();i++){
            int v=Integer.parseInt(((Character)input.charAt(i)).toString());
            if(l==v){
                sb.append(v);
            } else if(v>l){
                int diff=v-l;
                if(diff>0){
                    for(int j=0;j<diff;j++){
                        sb.append("(");
                    }
                    l=v;
                    sb.append(v);
                } else {
                    sb.append(v);
                }
            } else {
                if(v>0){
                    int diff=l-v;
                    for(int j=0;j<diff;j++){
                        sb.append(")");
                    }
                    l=v;
                    sb.append(v);
                } else {
                    for(int j=0;j<l;j++){
                        sb.append(")");
                    }
                    l=0;
                    sb.append(v);
                }
            }
            if(i==input.length()-1 && v>0) {
                for(int j=0;j<v;j++){
                    sb.append(")");
                }
            }
        }
        System.out.println("Case #" + T + ": " + sb.toString());
    }
}
