import java.util.*;
import java.io.*;
public class Solution {
    public static void solve(int t, List<String> patterns, int mxlen){
        String resString = "";
        int stars = 0;
        int position[] = new int[patterns.size()];
        int startStar = 0;
        int finished = 0;
        for (int i = 0; i < patterns.size(); i++){
            position[i] = 0;
        }
        //check start
        while (resString.length() < mxlen && resString != "IMPOSSIBLE") {
            for (int i = 0; i < patterns.size(); i++) {
                if (position[i] >= patterns.get(i).length()){
                    finished ++;
                    continue;
                }
                if (patterns.get(i).charAt(position[i]) == '*') {
                    stars++;
                    continue;
                }
                if (resString.length() > position[i] &&
                        patterns.get(i).charAt(position[i]) != resString.charAt(position[i])){
                    resString = "IMPOSSIBLE";
                    break;
                }
                if (resString.length() > position[i]) {
                    position[i]++;
                }
                if (resString.length() <= position[i]){
                    resString += patterns.get(i).charAt(position[i]);
                    position[i]++;
                }
            }
            if (resString == "IMPOSSIBLE"){
                break;
            }
            if (finished == patterns.size()){
                break;
            }
            if (stars == patterns.size()){
                break;
            }
        }
        String x = patterns.get(0);
        String mxsuf = "";
        int idx = x.lastIndexOf('*');

        mxsuf = idx != -1 ? x.substring(idx + 1) : mxsuf;

        if (resString == "IMPOSSIBLE"){

            System.out.println("Case #" + t + ": *");
            return;
        }
        for (int i = 1; i < patterns.size(); i++){
            x = patterns.get(i);
            String suf = "";
            idx = x.lastIndexOf('*');
            suf = idx != -1 ? x.substring(idx + 1) : suf;

            String tmp = suf;
            if (mxsuf.length() < suf.length()){
                tmp = mxsuf;
                mxsuf = suf;
            }
            if (!mxsuf.endsWith(tmp)){
                resString = "IMPOSSIBLE";
            }
        }
        if (resString == "IMPOSSIBLE"){

            System.out.println("Case #" + t + ": *");
            return;
        }

        for (int i = 0; i < patterns.size(); i++){
            x = patterns.get(i);
            String suf = "";
            idx = x.indexOf('*');
            suf = idx != -1 ? x.substring(idx + 1) : suf;
            idx = suf.lastIndexOf('*');
            suf = (idx != -1) ? suf.substring(idx + 1) : suf;
            suf.replaceAll("\\*","");
            resString += suf;
        }
        resString += mxsuf;

        if (resString == "IMPOSSIBLE"){

            System.out.println("Case #" + t + ": *");
            return;
        }

        System.out.println("Case #" + t + ": " + resString);

    }

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= t; ++i) {
            int n = in.nextInt();
            List<String> l = new ArrayList<>();
            int mxlen = 0;
            for (int k = 0; k < n; k++) {
                String s = in.next();
                l.add(s);
                if (s.length() > mxlen) mxlen = s.length();
            }
           solve(i, l, mxlen);
        }
    }
}
