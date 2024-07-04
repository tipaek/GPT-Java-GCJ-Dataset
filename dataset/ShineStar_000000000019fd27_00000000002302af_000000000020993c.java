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
                int trace = tr(N,mat);
            }
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
}