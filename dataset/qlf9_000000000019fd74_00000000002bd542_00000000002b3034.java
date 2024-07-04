import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException{
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
        int tt = Integer.parseInt(f.readLine());
        int t = tt;
        while(t --> 0){
            int n = Integer.parseInt(f.readLine());
            int[] startidxs = new int[n];
            int[] endidxs = new int[n];
            String[] strings = new String[n];
            for(int i = 0; i < n; i++){
                strings[i] = f.readLine();
                endidxs[i] = strings[i].length()-1;
            }
            StringBuilder pref = new StringBuilder();
            StringBuilder suff = new StringBuilder();
            boolean good = true;
            while(true){
                boolean same = true;
                char sameChar = '-';
                for(int i = 0; i < n; i++){
                    if(strings[i].charAt(startidxs[i]) == '*') continue;
                    if(sameChar == '-'){
                        sameChar = strings[i].charAt(startidxs[i]);
                        startidxs[i]++;
                    }else{
                        if(strings[i].charAt(startidxs[i]) != sameChar) {
                            same = false;
                            break;
                        }else{
                            startidxs[i]++;
                        }
                    }
                }
                if(sameChar == '-') break;
                pref.append(sameChar);
                boolean ended = false;
                for(int i = 0; i < n; i++){
                    if(startidxs[i] != strings[i].length() && ended){
                        same = false;
                        break;
                    }
                    if(startidxs[i] == strings[i].length()) ended = true;
                }
                if(ended) break;
                if(!same){
                    out.println("Case #" + (tt-t) + ": *");
                    good = false;
                    break;
                }
            }
            if(!good) continue;
            while(true){
                boolean same = true;
                char sameChar = '-';
                for(int i = 0; i < n; i++){
                    if(strings[i].charAt(endidxs[i]) == '*') continue;
                    if(sameChar == '-'){
                        sameChar = strings[i].charAt(endidxs[i]);
                        endidxs[i]--;
                    }else{
                        if(strings[i].charAt(endidxs[i]) != sameChar) {
                            same = false;
                            break;
                        }else{
                            endidxs[i]--;
                        }
                    }
                }
                if(sameChar == '-') break;
                suff.append(sameChar);
                boolean ended = false;
                for(int i = 0; i < n; i++){
                    if(endidxs[i] != -1 && ended){
                        same = false;
                        break;
                    }
                    if(endidxs[i] == -1) ended = true;
                }
                if(ended) break;
                if(!same){
                    out.println("Case #" + (tt-t) + ": *");
                    good = false;
                    break;
                }
            }
            if(!good) continue;
            boolean valid = true;
            for(int i = 0; i < n; i++){
                if(startidxs[i] != endidxs[i]) valid = false;
            }
            if(valid){
                pref.append(suff.reverse());
                out.println("Case #" + (tt-t) + ": " + pref.toString());
                continue;
            }
            StringBuilder toapp = new StringBuilder();
            while(true){
                boolean done = true;
                boolean ok2 = false;
                for(int i = 0; i < n; i++){
                    boolean ok = true;
                    if(startidxs[i] == endidxs[i]) continue;
                    done = false;
                    StringBuilder test1 = new StringBuilder();
                    startidxs[i]++;
                    while(strings[i].charAt(startidxs[i]) != '*'){
                        test1.append(strings[i].charAt(startidxs[i]));
                        startidxs[i]++;
                    }
                    for(int j = 0; j < n; j++){
                        if(i == j || startidxs[j] == endidxs[j]) continue;
                        StringBuilder test2 = new StringBuilder();
                        startidxs[j]++;
                        while(strings[j].charAt(startidxs[j]) != '*'){
                            test2.append(strings[j].charAt(startidxs[j]));
                            startidxs[j]++;
                        }
                        test1.append(test2);
                    }
                    if(!ok) continue;
                    toapp.append(test1);
                    ok2 = true;
                    break;
                }
                if(done) break;
                if(!ok2){
                    out.println("Case #" + (tt-t) + ": *");
                    good = false;
                    break;
                }
            }
            if(!good) continue;
            pref.append(toapp);
            pref.append(suff.reverse());
            out.println("Case #" + (tt-t) + ": " + pref.toString());


        }



        out.close();
    }

    public static boolean KMPSearch(String pat, String txt)
    {
        int M = pat.length();
        int N = txt.length();

        // create lps[] that will hold the longest
        // prefix suffix values for pattern
        int lps[] = new int[M];
        int j = 0; // index for pat[]

        // Preprocess the pattern (calculate lps[]
        // array)
        computeLPSArray(pat, M, lps);

        int i = 0; // index for txt[]
        while (i < N) {
            if (pat.charAt(j) == txt.charAt(i)) {
                j++;
                i++;
            }
            if (j == M) {
                return true;
            }

            // mismatch after j matches
            else if (i < N && pat.charAt(j) != txt.charAt(i)) {
                // Do not match lps[0..lps[j-1]] characters,
                // they will match anyway
                if (j != 0)
                    j = lps[j - 1];
                else
                    i = i + 1;
            }
        }
        return false;
    }

    public static void computeLPSArray(String pat, int M, int lps[])
    {
        // length of the previous longest prefix suffix
        int len = 0;
        int i = 1;
        lps[0] = 0; // lps[0] is always 0

        // the loop calculates lps[i] for i = 1 to M-1
        while (i < M) {
            if (pat.charAt(i) == pat.charAt(len)) {
                len++;
                lps[i] = len;
                i++;
            }
            else // (pat[i] != pat[len])
            {
                // This is tricky. Consider the example.
                // AAACAAAA and i = 7. The idea is similar
                // to search step.
                if (len != 0) {
                    len = lps[len - 1];

                    // Also, note that we do not increment
                    // i here
                }
                else // if (len == 0)
                {
                    lps[i] = len;
                    i++;
                }
            }
        }
    }
}
