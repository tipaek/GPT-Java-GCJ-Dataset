import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

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

                while(true) {
                    ArrayList<Pair> updates = new ArrayList<>();
                    long roundSum = 0;
                    for(int i=0 ; i<r ; i++) {
                        for(int j=0 ; j<c ; j++) {
                            if(a[i][j] != 0) {
                                roundSum += a[i][j];
                                int left = -1;
                                for(int k=j-1 ; k>=0 ; k--) {
                                    if(a[i][k] != 0) {
                                        left = a[i][k];
                                        break;
                                    }
                                }

                                int right = -1;
                                for(int k=j+1 ; k<c ; k++) {
                                    if(a[i][k] != 0) {
                                        right = a[i][k];
                                        break;
                                    }
                                }

                                int up = -1;
                                for(int k=i-1 ; k>=0 ; k--) {
                                    if(a[k][j] != 0) {
                                        up = a[k][j];
                                        break;
                                    }
                                }

                                int down = -1;
                                for(int k=i+1 ; k<r ; k++) {
                                    if(a[k][j] != 0) {
                                        down = a[k][j];
                                        break;
                                    }
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
    public String toString() {
        return "Pair{" +
            "x=" + x +
            ", y=" + y +
            '}';
    }
}
