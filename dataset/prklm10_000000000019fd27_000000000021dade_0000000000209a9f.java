import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T =Integer.parseInt(br.readLine());
        for(int o=1;o<=T;o++){
            String s =br.readLine();
            StringBuilder sb =new StringBuilder();
            char[] a =s.toCharArray();
            int opening=0,closing=0;
            for(int i=0;i<a.length;i++){
                int x = Integer.parseInt(String.valueOf(a[i]));
                if(i==0) {
                    for(int j=0;j<x;j++) {
                        sb.append("(");
                    }
                    sb.append(x);
                    opening+=x;
                }
                else {
                    int x1 =Integer.parseInt(String.valueOf(a[i-1]));
                    if(x1==x){
                        sb.append(x);
                    }
                    else if(x1>x) {
                        int d =x1-x;
                        for(int j=0;j<d;j++) {
                            sb.append(")");
                        }
                        sb.append(x);
                        closing+=d;
                    }
                    else {
                        int d =x-x1;
                        for(int j=0;j<d;j++) {
                            sb.append("(");
                        }
                        sb.append(x);
                        opening+=d;
                    }
                }

            }
            int f =opening-closing;
            for(int j=0;j<f;j++) {
                sb.append(")");
            }

            String ans = "Case #"+o+": "+sb;
            System.out.println(ans);
        }
    }
}