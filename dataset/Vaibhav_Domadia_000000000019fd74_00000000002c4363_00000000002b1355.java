import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Objects;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        PrintWriter pw = new PrintWriter(System.out);
        
        try {
            int t = Integer.parseInt(br.readLine());
            for(int zx = 1 ; zx<=t ; zx++) {
                st = new StringTokenizer(br.readLine());
                int r = Integer.parseInt(st.nextToken());
                int c = Integer.parseInt(st.nextToken());
                int[][] a = new int[r][c];
                for(int i=0 ; i<r ; i++) {
                    st = new StringTokenizer(br.readLine());
                    for(int j=0 ; j<c ; j++) {
                        a[i][j] = Integer.parseInt(st.nextToken());
                    }
                }

                long totalSum = 0;

                TreeSet<Integer>[] hor = new TreeSet[r];
                TreeSet<Integer>[] ver = new TreeSet[c];
                for(int i=0 ; i<r ; i++) hor[i] = new TreeSet<>();
                for(int i=0 ; i<c ; i++) ver[i] = new TreeSet<>();
                for(int i=0 ; i<r ; i++) {
                    for(int j=0 ; j<c ; j++) {
                        hor[i].add(j);
                        ver[j].add(i);
                    }
                }


                while(true) {
                    ArrayList<Pair> updates = new ArrayList<>();
                    long roundSum = 0;
                    for(int i=0 ; i<r ; i++) {
                        for(int j=0 ; j<c ; j++) {
                            if(a[i][j] != 0) {
                                roundSum += a[i][j];
                                int left = -1;
                                if(hor[i].floor(j-1) != null) {
                                    int ind = hor[i].floor(j-1);
                                    left = a[i][ind];
                                }

                                int right = -1;
                                if(hor[i].ceiling(j+1) != null) {
                                    int ind = hor[i].ceiling(j+1);
                                    right = a[i][ind];
                                }

                                int up = -1;
                                if(ver[j].floor(i-1) != null) {
                                    int ind = ver[j].floor(i-1);
                                    up = a[ind][j];
                                }

                                int down = -1;
                                if(ver[j].ceiling(i+1) != null) {
                                    int ind = ver[j].ceiling(i+1);
                                    down = a[ind][j];
                                }

                                ArrayList<Integer> x = new ArrayList<>();
                                if(left != -1) x.add(left);
                                if(right != -1) x.add(right);
                                if(up != -1) x.add(up);
                                if(down != -1) x.add(down);

                                if(x.size() != 0) {
                                    double sum = 0;
                                    for(int z=0 ; z<x.size() ; z++) {
                                        sum += x.get(z);
                                    }
                                    sum /= x.size();
                                    if(sum > a[i][j]) {
                                        updates.add(new Pair(i, j));
                                    }
                                }
                            }
                        }
                    }

                    totalSum += roundSum;

                    if(updates.size() == 0) {
                        break;
                    }
                    else {
                        for(int i=0 ; i<updates.size() ; i++) {
                            Pair v = updates.get(i);
                            a[v.x][v.y] = 0;
                            ver[v.y].remove(v.x);
                            hor[v.x].remove(v.y);
                        }
                    }
                }

                pw.println("Case #" + zx + ": " + totalSum);
            }
        }
        finally {
            pw.flush();
            pw.close();
        }
    }
}

class Pair {
    int x;
    int y;
    Pair(int a, int b) {
        x = a;
        y = b;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pair pair = (Pair) o;
        return x == pair.x && y == pair.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

    @Override
    public String toString() {
        return "Pair{" +
            "x=" + x +
            ", y=" + y +
            '}';
    }
}
