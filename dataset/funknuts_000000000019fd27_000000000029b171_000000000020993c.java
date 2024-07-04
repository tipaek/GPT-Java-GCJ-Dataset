import java.io.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

class Solution {

    public static void main(String[] args) {
        try {
            BufferedReader buffReader = new BufferedReader(new InputStreamReader(System.in));
            int num = Integer.parseInt(buffReader.readLine());

            for(int cases = 1; cases <= num; cases++) {
                int trace = 0;
                int rows = 0;
                int columns = 0;

                int n = Integer.parseInt(buffReader.readLine());
                int[][] li = new int[n][];
                HashSet<Integer> hash = new HashSet<>();
                for(int i = 0; i < n; i++) {
                    String line = buffReader.readLine();
                    String[] tokened = line.split(" ");
                    int[] l = new int[n];
                    boolean repeated = false;
                    for(int j = 0; j < tokened.length; j++) {
                        int tmp = Integer.parseInt(tokened[j]);
                        l[j] = tmp;
                        if(hash.contains(tmp)) {
                            repeated = true;
                        } else {
                            hash.add(tmp);
                        }
                        if(i == j) {
                            trace+=tmp;
                        }
                    }
                    if(repeated == true) {
                        rows++;
                    }
                    li[i] = l;
                    hash.clear();
                }

                int k = 0;
                while(k < n) {
                    int m = 0;
                    boolean repeated = false;
                    while(m < n) {
                        if(hash.contains(li[m][k])){
                            repeated = true;
                        } else {
                            hash.add(li[m][k]);
                        }
                        m++;
                    }
                    k++;
                    if(repeated) {
                        columns++;
                    }
                }

                System.out.println("Case #" + cases + ": " + trace + " " + rows + " " + columns);
            }

        } catch (IOException e) {
            System.out.println("IOException: " + e);
        }
    }
}
