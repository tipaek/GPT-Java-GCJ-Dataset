import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        //number of test case
        int t = in.nextInt(); 
        for (int i = 1; i <= t; ++i) {
            //matrix size
            int n = in.nextInt(); 
            int k = 0;
            int r = 0;
            int c = 0;
            //used for counting column with repeat
            List<Set> m = new ArrayList<Set>();
            List<Boolean> cflag = new ArrayList<Boolean>();
            for (int j = 0; j < n; j++) {
                Set ySet = new HashSet();
                m.add(ySet);
                cflag.add(false);
            }
            //y of matrix
            for (int y = 0; y < n; y++) { //will have to deal with it
                //used for counting row with repeat
                Set xSet = new HashSet();
                boolean rflag = false;
                //x of matrix
                for (int x = 0; x < n; x++) {
                    int xy = in.nextInt();
                    //add trace
                    if (x == y)
                        k += xy;
                    //find if row contain repeated element
                    if (!xSet.add(xy)) { 
                        rflag = true;
                    }
                    Set tempSet = m.get(x);
                    //find if column contain repeated element
                    if (!tempSet.add(xy)) {
                        cflag.set(x, true);
                    }
                    m.set(x, tempSet);
                }
                if (rflag)
                    r++;
            }
            for(int cf = 0; cf < n; cf++) {
                if(cflag.get(cf)) 
                    c++;
            }
            System.out.println("Case #" + i + ": " + k + " " + r + " " + c);
        }
    }
}