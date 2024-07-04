import java.util.*;
import java.io.*;

class Pair implements Comparable{
    int st,end,ord;

    public Pair(int s, int e,int o){
        st=s;
        end=e;
        ord = o;
    }

    @Override
    public int compareTo(Object o) {
        int ost = ((Pair)o).st;
        return this.st - ost;
    }
}

public class Solution {




    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.

        for (int z = 1; z <= t; ++z) {
            int R = in.nextInt();
            int C = in.nextInt();
            int[][] input = new int[R][C];
            for (int i=0;i<R;i++){
                for (int j=0;j<C;j++){
                    input[i][j]=in.nextInt();
                }
            }
            HashMap<Integer, Integer>[] hmR = new HashMap[R];
            HashMap<Integer, Integer>[] hmC = new HashMap[C];
            int[] maxRow = new int[R];
            int[] maxCol = new int[C];
            int maxRound = 1;
            for (int i=0;i<R;i++){
                int[] row = input[i].clone();
                Arrays.sort(row);
                hmR[i] = new HashMap<>( );
                int ind=1;
                int currMax = 1;
                for (int j=0;j<row.length;j++){
                    if (!hmR[i].containsKey(row[j])){
                        hmR[i].put(row[j], ind);
                        ind++;
                    }
                }
                if (ind-1>maxRound)maxRound=ind-1;
                if (ind-1>currMax)currMax=ind-1;
                maxRow[i]=currMax;
            }
            for (int i=0;i<C;i++){
                int[] col = new int[R];
                for (int j=0;j<R;j++){
                    col[j]=input[j][i];
                }
                Arrays.sort(col);
                hmC[i] = new HashMap<>( );
                int ind=1;
                int currMax=1;
                for (int j=0;j<col.length;j++){
                    if (!hmC[i].containsKey(col[j])){
                        hmC[i].put(col[j], ind);
                        ind++;
                    }
                }
                if (ind-1>maxRound)maxRound=ind-1;
                if (ind-1>currMax)currMax=ind-1;
                maxCol[i]=currMax;
            }
            long sum=0;
            for (int i=0;i<R;i++){
                for (int j=0;j<C;j++){
                    int val = input[i][j];

                    int times=1;
                    if (hmR[i].get(val)==maxRow[i] && hmC[j].get(val)!=maxCol[j])times=hmC[j].get(val);
                    if (hmC[j].get(val)==maxCol[j] && hmR[i].get(val)!=maxRow[i])times=hmR[i].get(val);
                    if (hmC[j].get(val)==maxCol[j] && hmR[i].get(val)==maxRow[i])times=maxRound;
                    if (hmC[j].get(val)!=maxCol[j] && hmR[i].get(val)!=maxRow[i])times=Math.min(hmC[j].get(val),hmR[i].get(val));

                    sum+=val*times;

                }
            }

            System.out.println("Case #" + z + ": "+ sum);





            //read 2 bits for verification
            //read 8 bits
            //repeat



        }
    }
}