import java.io.*;
import java.math.BigInteger;
import java.util.*;
public class Solution {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        int p = 1;
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            int a[]= new int[1441];
            int j[]=new int[1441];
            int c[]= new int[1441];
            Arrays.fill(a,0);
            Arrays.fill(j,0);
            Arrays.fill(c,0);
            String ans= "";
            for(int i=0;i<n;i++){
                    String[] inp = br.readLine().split(" ");
                    int si= Integer.parseInt(inp[0]);
                    int ei= Integer.parseInt(inp[1]);
                if(ei== 1440){
                    ei=1441;
                }
                    int joc=0, coc=0;
                    for(int i1=si;i1<ei;i1++){
                        a[i1]++;
                        if(j[i1]==1){
                            joc=1;
                        }
                        else if(c[i1]==1){
                            coc=1;
                        }
                    }
                    if(joc==0){
                        ans=ans+"C";
                        for(int ff=si;ff<ei;ff++){
                            j[ff]=1;
                        }
                    }
                    else if(coc==0){
                       ans=ans+"J";
                       for(int ff=si;ff<ei;ff++){
                           c[ff]=1;
                       }
                    }
                }
            for(int i=0;i<1441;i++){
                if(a[i]>2){
                    ans= "IMPOSSIBLE";
                }
            }
            System.out.println("Case #"+p+": "+ans);
            p++;
                }
            }
}
