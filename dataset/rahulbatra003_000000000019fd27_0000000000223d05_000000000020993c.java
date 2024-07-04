import java.util.*;
import java.io.*;
import java.lang.*;

class Vestigium {
    	static HashSet<Integer> set = new HashSet<Integer>();
    static int trace(int[][] a, int N) {
        int c=0;
        for(int i=0;i<N;i++) {
            c+=a[i][i];
        }
        return c;
    }
    
    static int rowRepeat(int[][] a, int N) {
        int r=0;
        for(int i=0;i<N;i++) {
            set.clear();
            for(int j=0;j<N;j++) {
                if(set.contains(a[i][j])) {
                    r++;
                    break;
                } else {
                    set.add(a[i][j]);
                }
            }
        }
        return r;
    }
    
    static int colRepeat(int[][] a, int N) {
        int r=0;
        for(int j=0;j<N;j++) {
            set.clear();
            for(int i=0;i<N;i++) {
                if(set.contains(a[i][j])) {
                    r++;
                    break;
                } else {
                    set.add(a[i][j]);
                }
            }
        }
        return r;
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        for(int k=0; k<T; k++) {
            int N = in.nextInt();
            int[][] a = new int[N][N];
            for(int i=0; i<N; i++) {
                for (int j=0; j<N; j++) {
                    a[i][j] = in.nextInt();
                }
            }
            int t = trace(a,N);
            int r = rowRepeat(a,N);
            int c = colRepeat(a,N);
            System.out.println("Case #"+(k+1)+": "+t+" "+r+" "+c);
        }
    }
}