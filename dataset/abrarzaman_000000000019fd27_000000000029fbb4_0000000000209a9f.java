import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());
        int t = Integer.parseInt(st.nextToken());
        for (int j =0; j<t; j++){
            String e;
            String result ="";
            e = in.readLine();
            char[] a = e.toCharArray();
            for (int k =0; k<a.length; k++){
                char b = a[k];
                int next = b-'0';
                int previous = 0;
                if (k>0){
                    previous = a[k-1] - '0';
                }

                for (int i =0; i<next-previous; i++){
                    result +="(";
                }
                int goop =0 ;
                int counter = 0;
                for (int q =k; q<a.length; q++){
                    if (a[q] == b){
                        result+=b;
                        counter++;
                    }else{
                        goop = a[q]-'0';
                        break;
                    }
                }
                k+=counter-1;
                for (int i =0; i<next-goop; i++){
                    result +=")";
                }
            }


            System.out.println("Case #" + (j+1) + ": " + result);
        }


        // close the output file
    }
}