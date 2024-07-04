import java.io.*;
import java.util.Scanner;
import java.util.Set;
import java.util.StringTokenizer;

public class Solution {

    public static void main(String[] args){



        MyScanner sc = new MyScanner();

        out = new PrintWriter(new BufferedOutputStream(System.out));

        int tests=sc.nextInt();

        for(int ll=0;ll<tests;ll++){

            int tasks=sc.nextInt();

            int[] start=new int[tasks];
            int[] end=new int[tasks];
            int[] assigned=new int[tasks];
            boolean impossible=false;
            // 1-C  2-J

            for(int i=0;i<tasks;i++){

                start[i]=sc.nextInt();
                end[i]=sc.nextInt();

            }

            StringBuilder sb=new StringBuilder();

            for(int ii=0;ii<tasks;ii++){


                    boolean checkC=assigned(start,end,assigned,1,ii);

                    if(checkC==true){

                        assigned[ii]=1;
                    }else{


                        boolean checkJ=assigned(start,end,assigned,2,ii);
                        if(checkJ==true){

                            assigned[ii]=2;
                        }else{
                            impossible=true;
                            break;
                        }



                    }






            }



            if(impossible==true){
                out.println("IMPOSSIBLE");
            }else{

                for(int i=0;i<assigned.length;i++){
                    if(assigned[i]==1){
                        sb.append('C');
                    }
                    else if(assigned[i]==2){
                        sb.append('J');
                    }else {
                        sb.append('W');
                    }
                }

                out.println(sb);

            }









        }//ll loop




        // sc.close();
        out.close();


    }//main


    public static boolean assigned(int[] start,int[] end,int [] assigned,int person,int index){


            int starttime=start[index];
            int endtime=end[index];

            for(int i=0;i<start.length;i++){

                if(assigned[i]==person){

                    if(starttime<end[i]){

                        for(int j=0;j<start.length;j++){

                            if(assigned[j]==person){
                                if(endtime>start[j]){
                                    return false;

                                }


                            }

                        }


                       // return false;
                    }


                }

            }


        return true;



    }


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
