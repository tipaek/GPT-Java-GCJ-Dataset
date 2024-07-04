import java.util.*;
import java.io.*;

public class Solution {

    public static void main(String[] args) {
        Scanner cs = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int T = Integer.valueOf(cs.nextLine());

        for (int i = 1; i <= T; ++i) {
            int len = Integer.valueOf(cs.nextLine());
            int[][] range = new int[10000][len];
            char[][] codes = new char[10000][len];
            for (int j = 0; j < 10000; j++){
                String[] vals = cs.nextLine().split(" ");
                char[] vDig =  vals[0].toCharArray();
                for (int a = 0; a < len; a++){
                    if (a - len + vDig.length >= 0){
                        range[j][a] = -1;
                    } else {
                        range[j][a] = vDig[a - len + vDig.length]-'0';
                    }
                }

                int f = len - vals[1].length();
                for (char v : vals[1].toCharArray()){
                    codes[j][f] = v;
                    f++;
                }
            }
            String res = findMatch(range, codes, len);
            if (res.length() == 0){
                System.out.printf("Case #%d: IMPOSSIBLE\n", i);
            } else {
                System.out.printf("Case #%d: %s\n", i, res);
            }
        }
    }

    private static String findMatch(int[][] range, char[][] codesVals, int len) {
        char[] abc = new char[10];
        int[][] codes = new int[10000][len];
        int i = 0;
        Map<Character, Integer> charPos = new HashMap<>();
        for (char[] v : codesVals){
            for ( char a : v){
                if (a == 0){
                    continue;
                }
                boolean found = false;
                for (int j = 0; j < i && !found; j++){
                    found = abc[j] == a;
                }
                if (!found){
                    i++;
                    abc[i] = a;
                    charPos.put(a, i);
                }
            }
        }
        for (int n = 0; n < codesVals.length; n++){
            for (int j = 0; j < len; j++){
                codes[n][j] = codesVals[n][j] == 0 ? -1 : (charPos.get(codesVals[n][j]));
            }
        }
        int[][] pos = new int[10][10];
        for (int a = 0; a < 10; a++){
            for (int b = 0; b <10; b++){
                pos[a][b] = -1;
            }
        }
        Stack<int[][]>[] history = new Stack[10000];

        int depth = 0;
        while (depth >=0 && depth <= 10000){
            if (depth == 10000){
                StringBuilder sb = new StringBuilder();
                boolean[] used = new boolean[10];
                for (int[] v : pos){
                    for (int k = 0; k < 10; k++){
                        if (v[k] == -1 && !used[k]){
                            sb.append(abc[k]);
                            used[k] = true;
                            break;
                        }
                    }
                }
                return sb.toString();
            }
            if (history[depth] == null){
                history[depth] = findPositions(pos, range[depth], codes[depth], depth);
            }
            if (history[depth].size() == 0){
                depth--;
            } else {
                pos = history[depth].pop();
            }
        }
        return "";
    }

    private static Stack<int[][]> findPositions(int[][] pos, int[] range, int[] code, int depth) {
        Stack<int[][]> res = new Stack<>();
        for (int j = 0; j < range.length; j++){
            if (range[j] == -1){
                continue;
            }
            if (code[j] == -1){
                return res;
            }
            int maxVal = range[j];
            int position = code[j];
            boolean changed = false;
            for (int a = maxVal; a < 10; a++){
                if (pos[position][maxVal] == -1){
                    changed = true;
                    pos[position][maxVal] = depth;
                }
            }
            if (changed){
                res.push(copyPos(pos));
            }
            if (pos[position][maxVal] == -1){
                for (int a = 0; a < 10; a++){
                    pos[position][a] = depth;
                }
                pos[position][maxVal] = -1;
                res.push(copyPos(pos));
            }
        }
        return res;
    }

    private static int[][] copyPos(int[][] pos) {
        int[][] res = new int[10][10];
        for (int a = 0; a < 10; a++){
            for (int b = 0; b <10; b++){
                res[a][b] = pos[a][b];
            }
        }
        return res;
    }


}
