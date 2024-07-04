/**
 * @author egaeus
 * @date 04/04/2020
 **/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.TreeSet;

import static java.lang.Integer.parseInt;

public class Solution {
    public static void main(String args[]) throws Throwable{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int T=parseInt(in.readLine());
        StringBuilder sb = new StringBuilder();
        for(int t=0;t++<T;) {
            sb.append("Case #").append(t).append(": ");
            StringTokenizer st = new StringTokenizer(in.readLine());
            int R = parseInt(st.nextToken()), C = parseInt(st.nextToken());
            long[][] tab = new long[R][C];
            long sum = 0, res = 0;
            TreeSet<Integer> cols[] = new TreeSet[C];
            TreeSet<Integer> rows[] = new TreeSet[R];
            for(int i=0;i<R;i++)rows[i] = new TreeSet<>();
            for(int i=0;i<C;i++)cols[i] = new TreeSet<>();
            for(int i = 0; i < R; i++) {
                st = new StringTokenizer(in.readLine());
                for(int j=0;j<C;j++) {
                    sum += (tab[i][j] = parseInt(st.nextToken()));
                    rows[i].add(j);
                    cols[j].add(i);
                }
            }
            while(true) {
                res+=sum;
                long less = 0;
                ArrayList<int[]> delete = new ArrayList<>();
                for(int i=0;i<R;i++) {
                    for (int j : rows[i]) {
                        double q = 0;
                        long neigh = 0;
                        Integer izq = rows[i].floor(j-1);
                        Integer der = rows[i].ceiling(j+1);
                        Integer abajo = cols[j].ceiling(i+1);
                        Integer arriba = cols[j].floor(i-1);
                        if(izq != null) {
                            q++;
                            neigh+=tab[i][izq];
                        }
                        if(der != null) {
                            q++;
                            neigh += tab[i][der];
                        }
                        if(abajo!=null) {
                            q++;
                            neigh += tab[abajo][j];
                        }
                        if(arriba!=null) {
                            q++;
                            neigh += tab[arriba][j];
                        }
                        if(q>0&&tab[i][j]<neigh/q) {
                            delete.add(new int[]{i,j});
                        }
                    }
                }
                for(int[] d:delete) {
                    less+=tab[d[0]][d[1]];
                    rows[d[0]].remove(d[1]);
                    cols[d[1]].remove(d[0]);
                }
                sum-=less;
                if(less==0)break;
            }
            sb.append(res);
            sb.append("\n");
        }
        System.out.print(new String(sb));
    }

}
