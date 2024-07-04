import java.io.*;
import java.util.*;

@SuppressWarnings("unchecked")

public class Solution {

    public static void main(String[] args) throws IOException {

        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

        int t = in.nextInt();
        for (int x = 0; x < t; x++) {
            int u = in.nextInt();
            char[] D = new char[10];
            HashSet<Pair> pairs =new HashSet();
            HashSet<Character> chars =new HashSet();

            for(int i = 0; i < 10000; i++){
                long m = in.nextLong();
                String r = in.next();
                int leading = String.valueOf(m).charAt(0) - '0';
                char c = r.charAt(0);
                for(int k = leading+1; k < 10; i++){
                    pairs.add(new Pair(c, k));
                    chars.add(c);
                }
            }

            for(int i = 0; i < 10; i++){
                Iterator<Character> iter=chars.iterator();
                int[] vals = new int[10-i]; char[] charsArr = new char[10-i];int counter = 0;
                while(iter.hasNext()) {
                    char c = iter.next();

                    Iterator<Pair> iterTemp= pairs.iterator(); int temp = 0;
                    if(iterTemp.hasNext()){
                        Pair p = iterTemp.next();
                        if(p.c == c) temp++;
                    }

                    vals[counter] = temp;
                    charsArr[counter] = c;
                    counter++;
                }
                //find max
                char maxChar = 'L';
                int maxApp = -1;
                for(int j = 0; j < vals.length; j++){
                    if(vals[j]>maxApp){
                        maxApp = vals[j]; maxChar = charsArr[j];
                    }
                }
                //assign to D
                D[i] = maxChar;
                //remove all the instances in hashset using that
                chars.remove(maxChar);
                Iterator<Pair> iter2=pairs.iterator();
                if(iter2.hasNext()){
                    Pair p = iter2.next();
                    if(p.c == maxChar) pairs.remove(p);
                }
            }

            String ans = ""+D[0]+D[1]+D[2]+D[3]+D[4]+D[5]+D[6]+D[7]+D[8]+D[9];

            System.out.println("Case #" + (x + 1) + ": "+ans);
        }
    }
}

class Pair{
    char c; int forbidden;
    public Pair(char cnew, int fnew){
        c = cnew; forbidden = fnew;
    }
}

