

import java.io.*;
import java.util.ArrayList;

public class Solution {
    static BufferedReader inp = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        int testCase = Integer.parseInt(inp.readLine());
        for (int t = 0; t < testCase; t++) {

            String[] s1 = inp.readLine().split("");
            String string = "";

            int c = Integer.parseInt(s1[0]);
            for(int i=0;i<c;i++){
                string+="(";
            }

            for(int i=0;i<s1.length-1;i++){
                int a = Integer.parseInt(s1[i]);
                int b = Integer.parseInt(s1[i+1]);
                string+=a;
                if(a>b){
                    int diff = a-b;
                    for(int j=0;j<diff;j++){
                        string+=")";
                    }
                }
                else{
                    int diff = b-a;
                    for(int j=0;j<diff;j++){
                        string+="(";
                    }
                }
            }


            int a = Integer.parseInt(s1[s1.length-1]);
            string+=a;
            for(int i=0;i<a;i++){
                string+=")";
            }

            out.write("Case #"+(t+1)+":"+" "+string+"\n");
        }
        out.flush();
    }
}
