import java.util.*;
import java.io.*;
class Solution {

    private static int[] c;
    private static int[] j;


    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int test = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        int size = 0;
        for (int i = 1; i <= test; i++) {
            String result = "";
            size = in.nextInt();
            c = new int[size * 2];
            j = new int[size * 2];
            in.nextLine();
            for (int a = 0; a < size; a++) {
                String next = in.nextLine();
                String[] temp;
                temp = next.split(" ");
                int[] nexts = {0, 0};
                nexts[0] = Integer.parseInt(temp[0]);
                nexts[1] = Integer.parseInt(temp[1]);
                result = result + Calculate(c, j, nexts);
            }
            if (result.contains("IMPOSSIBLE")) {
                System.out.println("Case #" + i + ": " +"IMPOSSIBLE");
            } else{
                System.out.println("Case #" + i + ": " + result);
            }
        }
    }
    private static String Calculate(int[] c,int[] j,int[] next) {
        if(check(c)) {
            c[0] = next[0];
            c[1] = next[1];
            return "C";
        }
        else{
            if(!(Calculateback(c,next) || Calculatefont(c,next))){
                if(check(j)){
                    j[0] = next[0];
                    j[1] = next[1];
                    return "J";
                }else {
                    if (Calculateback(j, next) || Calculatefont(j, next)) {
                        j[j.length - 2] = next[0];
                        j[j.length - 1] = next[1];
                        Arrays.sort(j);
                        return "J";
                    }else{
                        return "IMPOSSIBLE";
                    }
                }
            }else{
                    c[c.length-2] = next[0];
                    c[c.length -1]= next[1];
                    Arrays.sort(c);
                    return "C";
                }
            }
    }
    private static boolean Calculateback(int[] c,int[] next){
    for(int i = 1; i < c.length; i = i + 2 ){
        if(next[0] >= c[i] && c[i] != 0){
            return true;
        }

    }
    return false;
    }
    private static boolean Calculatefont(int[] c,int[] next){
        for(int i = 0; i < c.length; i = i + 2 ){
            if(next[1] <= c[i] && c[i] != 0){
                return true;
            }
        }
        return false;
    }

    private static boolean check(int[] c){
        for(int i =0;i< c.length;i++){
            if(c[i] != 0){
                return false;
            }
        }
        return true;
    }
}