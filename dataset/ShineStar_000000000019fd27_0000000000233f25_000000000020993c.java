import java.util.*;
import java.io.*;
class myClass{
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        String t = (s.nextLine()).trim();
        int T = Integer.parseInt(t);
        for(int i=1;i<=T;i++){
            String n =(s.nextLine()).trim();
            int N = Integer.parseInt(n);
            List<int[]> mat = new ArrayList<int[]>();
            for(int j=0; j<N;j++){
                String[] nn = (s.nextLine()).split(" ");
                int[] nN = new int[N];
                for(int k=0; k<N;k++){
                    nN[k] = Integer.parseInt(nn[k]);
                }
                mat.add(nN);
            }
            int trace = tr(N,mat);
            int row = rrow(N,mat);
            int col = rcol(N,mat);
            System.out.println("Case #"+i+": "+trace+" "+row+" "+col);
        }
    }
    public static int tr(int N, List<int[]> mat){
        int trace=0;
        for(int i=0;i<N;i++){
            int[] m= mat.get(i);
            trace += m[i];
        }
        return trace;
    }
    public static int rrow(int N,List<int[]> mat){
        int row=0;
        for(int i=0;i<N;i++){
            int[] m= mat.get(i);
            boolean repea = rep(m);
            if(repea){
                row++;
            }
        }
        return row;
    }
    public static int rcol(int N, List<int[]> mat){
        int col=0;
        for(int i=0;i<N;i++){
            int[] colu = new int[N];
            for(int j=0; j<N;j++){
                int[] m = mat.get(j);
                colu[j] = m[i];
            }
            boolean repea = rep(colu);
            if(repea){
                col++;
            }
        }
        return col;
    }
    public static boolean rep(int[] m){
        for(int i=0;i<m.length;i++){
            for(int j=0;j<m.length;j++){
                if(m[i]==m[j]){
                    return true;
                }
            }
        }
        return false;
    }
}