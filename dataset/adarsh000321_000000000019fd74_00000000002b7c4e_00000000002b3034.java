import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        FastReader sc = new FastReader();
        int t=sc.nextInt();
        for (int tt=1;tt<=t;tt++){
            int n=sc.nextInt();
            String s[]=new String[n];
            for (int i=0;i<n;i++){
                s[i]=sc.next();
            }
            int suff[]=new int[n];
            int max=-1;
            int ind=-1;
            for (int i=0;i<n;i++){
                boolean f=false;
                for (int j=0;j<s[i].length();j++){
                    if (s[i].charAt(j)=='*'){
                        f=true;
                        suff[i]=j;
                        if (s[i].length()-suff[i]>max){
                            max=s[i].length()-suff[i]+1;
                            ind=i;
                        }
                        break;
                    }
                }
            }
            boolean ok=true;
            for (int i=0;i<n;i++){
                int l=s[ind].length()-1;
                for (int j=s[i].length()-1;j>=0;j--){
                    if (j==suff[i])break;
                    if (s[i].charAt(j)!=s[ind].charAt(l--)){
                        ok=false;
                        break;
                    }
                }
            }
            if (!ok){
                System.out.print("Case #"+tt+": *");
                continue;
            }
            max=-1;
            int ind1=-1;
            for (int i=0;i<n;i++){
                if (max<suff[i]){
                    max=suff[i];
                    ind1=i;
                }
            }
            ok=true;
            for (int i=0;i<n;i++){
                for (int j=0;j<s[i].length();j++){
                    if (j==suff[i])break;
                    if (s[i].charAt(j)!=s[ind1].charAt(j)){
                        ok=false;
                        break;
                    }
                }
            }
            if (!ok){
                System.out.print("Case #"+tt+": *");
                continue;
            }
            StringBuilder sb=new StringBuilder();
            sb.append(s[ind1].substring(0,suff[ind1])+s[ind].substring(suff[ind]+1));
            System.out.print("Case #"+tt+": "+sb);
        }
    }
    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new
                    InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }

        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }
}