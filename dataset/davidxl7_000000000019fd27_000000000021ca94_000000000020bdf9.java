import java.io.*;
import java.util.*;
public class Solution {
    public static void main(String[] args) throws IOException{
        //BufferedReader br = new BufferedReader(new FileReader("Vestigium.in"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            System.out.print("Case #"+(i+1)+": ");
            int T = Integer.parseInt(br.readLine());
            situation[]sits = new situation[T];
            for (int j = 0; j < T; j++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                sits[j]=new situation(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()),j);
            }
            Arrays.sort(sits);
            char[]ans = new char[T];
            boolean solvable = true;
            int C = -1;
            int J = -1;
            for (int j = 0; j < T; j++) {
                if(C!=-1&&sits[C].end<=sits[j].start){
                    C=-1;
                }
                if(J!=-1&&sits[J].end<=sits[j].start){
                    J=-1;
                }
                if(C==-1){
                    C = j;
                    ans[sits[j].index]='C';
                }
                else if(J==-1){
                    J = j;
                    ans[sits[j].index]='J';
                }
                else{
                    solvable = false;
                    break;
                }
            }
            if(solvable){
                for (int j = 0; j < T; j++) {
                    System.out.print(ans[j]);
                }
            }
            else{
                System.out.print("IMPOSSIBLE");
            }
            if(i!=N-1){
                System.out.println();
            }
        }
    }
    static class situation implements Comparable<situation>{
        int start,end,index;
        public situation(int s, int e, int i) {
            start = s;
            end = e;
            index = i;
        }

        @Override
        public int compareTo(situation situation) {
            return start-situation.start;
        }
    }
}
