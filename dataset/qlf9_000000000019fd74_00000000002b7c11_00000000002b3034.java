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
            pref.append(suff.reverse());
            out.println("Case #" + (tt-t) + ": " + pref.toString());
        }


        out.close();
    }
}
