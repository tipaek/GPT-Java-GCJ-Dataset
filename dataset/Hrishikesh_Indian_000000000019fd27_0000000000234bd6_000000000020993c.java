import java.io.*;
import java.util.Scanner;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Solution {

    public static void main(String[] args){

       // Scanner sc=new Scanner(System.in);

        MyScanner sc = new MyScanner();
        //Scanner sc=new Scanner(System.in);
        out = new PrintWriter(new BufferedOutputStream(System.out));

        int tests=sc.nextInt();

        for(int ll=0;ll<tests;ll++){

            int N=sc.nextInt();

            int[][] mat=new int[N][N];
            int trace=0;
            for(int i=0;i<N;i++){

                for(int j=0;j<N;j++){

                    mat[i][j]=sc.nextInt();

                    if(i==j){
                        trace=trace+mat[i][j];
                    }

                }

            }


            int row=0;
            int col=0;

            Set<Integer> rowset=new TreeSet<>();
            Set<Integer> colset=new TreeSet<>();

            int rowcheck=0;
            int colcheck=0;

            for(int i=0;i<N;i++){

                rowset.clear();
                colset.clear();

                rowcheck=0;
                colcheck=0;

                for(int j=0;j<N;j++){

                    int rowelement=mat[i][j];
                    int colelement=mat[j][i];

                    if(rowset.contains(rowelement)&&rowcheck==0){
                        rowcheck=1;
                        rowset.add(rowelement);
                    }else{
                        rowset.add(rowelement);
                    }

                    if(colset.contains(colelement)&&colcheck==0){
                        colcheck=1;
                        colset.add(colelement);
                    }else{
                        colset.add(colelement);
                    }




                }


                if(rowcheck==1){
                    row++;
                }

                if(colcheck==1){
                    col++;
                }



            }


            out.println("Case #"+(ll+1)+": "+trace+" "+row+" "+col);








        }//ll loop




       // sc.close();
        out.close();


    }//main


    //-----------PrintWriter for faster output---------------------------------
    public static PrintWriter out;

    //-----------MyScanner class for faster input----------
    public static class MyScanner {
        BufferedReader br;
        StringTokenizer st;

        public MyScanner() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }

        String nextLine(){
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }

    }
    //--------------------------------------------------------




}
