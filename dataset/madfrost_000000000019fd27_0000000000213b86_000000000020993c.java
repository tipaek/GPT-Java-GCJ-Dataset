

import java.io.*;
import java.util.*;

public class Vestigium {

    static BufferedReader inp = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException{
        int testCase = Integer.parseInt(inp.readLine());
        for(int t=0;t<testCase;t++){
            int size = Integer.parseInt(inp.readLine());
            int[][] given = new int[size][size];
            Set<Integer>[] colomn = new HashSet[size];
            Set<Integer>[] row = new HashSet[size];
            for(int i=0;i<size;i++){
                colomn[i] = new HashSet<>();
                row[i] = new HashSet<>();
            }

            Set<Integer> x = new HashSet<>();
            Set<Integer> y = new HashSet<>();

            for(int i=0;i<size;i++){
                String[] s1 = inp.readLine().split(" ");
                for(int j=0;j<size;j++){
                    int a = Integer.parseInt(s1[j]);
                    given[i][j] = a;
                }
            }

            long sum = 0;

            for(int i=0;i<size;i++){
                for(int j=0;j<size;j++){
                    int a = given[i][j];

                    if(colomn[j].contains(a)){
                        y.add(j);
                    }
                    else{
                        colomn[j].add(a);
                    }

                    if(row[i].contains(a)){
                        x.add(i);
                    }
                    else{
                        row[i].add(a);
                    }

                    if(i==j){
                        sum+=a;
                    }

                }
            }

            out.write("case #"+(t+1)+":"+" "+sum+" "+x.size()+" "+y.size()+"\n");

        }
        out.flush();
    }
}
