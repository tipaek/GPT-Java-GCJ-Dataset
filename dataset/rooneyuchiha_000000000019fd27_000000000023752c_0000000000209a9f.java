import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

class CodeChef {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T =Integer.parseInt(br.readLine());
        for(int o=1;o<=T;o++){
            String s =br.readLine();
            List<String> ans =new ArrayList<>();
            char[] a =s.toCharArray();
            int open=0,close=0;
            for(int i=0;i<a.length;i++){
                int x = Integer.parseInt(String.valueOf(a[i]));
                if(i==0) {
                    for(int j=0;j<x;j++) {

                        ans.add("(");
                    }

                    ans.add(String.valueOf(x));
                    open+=x;
                }
                else {
                    int x1 =Integer.parseInt(String.valueOf(a[i-1]));
                    if(x1==x){

                        ans.add(String.valueOf(x));
                    }
                    else if(x1>x) {
                        int d =x1-x;
                        for(int j=0;j<d;j++) {

                            ans.add(")");
                        }

                        ans.add(String.valueOf(x));
                        close+=d;
                    }
                    else {
                        int d =x-x1;
                        for(int j=0;j<d;j++) {

                            ans.add("(");
                        }
                        ans.add(String.valueOf(x));
                        open+=d;
                    }
                }

            }
            int f =open-close;
            for(int j=0;j<f;j++) {
                ans.add(")");
            }
            StringBuilder g = new StringBuilder();
            for(int i=0;i<ans.size();i++){
                g.append(ans.get(i));
            }
            String fin = "Case #"+o+": "+g;
            System.out.println(fin);
        }
    }
}