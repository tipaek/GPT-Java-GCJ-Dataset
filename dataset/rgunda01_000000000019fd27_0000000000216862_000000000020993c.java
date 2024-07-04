import java.util.*;
import java.io.*;
public class Solution {
    public static void main(String args[])throws IOException
    {
        Scanner sc=new Scanner(System.in);
        int N1=sc.nextInt();

        for(int i=0;i<N1;i++) {
            int N=sc.nextInt();
            int[][] mat = new int[N][N];
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < N; k++) {
                    mat[j][k] = sc.nextInt();
                }
            }
            int sum=0;
            for (int j = 0; j <N; j++) {
                sum+=mat[j][j];

            }
            int finrep1=0;
            int finrep2=0;

            for (int j = 0; j <N; j++) {

                HashSet<Integer>row=new HashSet<Integer>();
                HashSet<Integer>column=new HashSet<Integer>();
                int k=0;
                int rep1=0;
                int rep2=0;
                while((rep1==0||rep2==0)&&k<N) {
                    if(!row.add(mat[j][k])) {
                        rep1++;
                        int q=0;
                    }

                    if(!column.add(mat[k][j])) {
                        rep2++;
                    }


                        k++;
                }
                if(rep1>0)
                    finrep1++;
                if(rep2>0)
                    finrep2++;

            }

            System.out.println("Case #"+(i+1)+": "+sum+" "+finrep1+" "+finrep2);
        }

    }
}