import java.util.*;
import java.io.*;
public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int T = in.nextInt();
        in.nextLine();
        for(int i=0; i<T; i++) {
            String str = in.nextLine();
            int d = 0;
            String results = "";
            for(int j=0; j<str.length(); j++) {
                int k = Integer.parseInt(String.valueOf(str.charAt(j)));
                if(d<k) {
                    for(int as=0; as<(k-d); as++)
                    results = results + ("(");
                }
                else {
                    for(int as=0; as<(d-k); as++)
                    results = results + ")";
                }
                results = results + k;
                d = k;
            }
            for(int as=0; as<d; as++)
            results = results + ")";
            System.out.println("Case #" + (i+1)+": " + results);
        }
    }
}
