import java.io.*;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Set;
import java.util.StringTokenizer;

public class Solution{

    public static void main(String[] args){



        MyScanner sc = new MyScanner();

        out = new PrintWriter(new BufferedOutputStream(System.out));

        int tests=sc.nextInt();

        for(int ll=0;ll<tests;ll++){

            int tasks=sc.nextInt();

            int[] start=new int[tasks];
            int[] end=new int[tasks];
            int[] assigned=new int[tasks];
            int[] answer=new int[tasks];
            int counter=0;

            boolean impossible=false;
            // 1-C  2-J

            for(int i=0;i<tasks;i++){

                start[i]=sc.nextInt();
                end[i]=sc.nextInt();

            }

            StringBuilder sb=new StringBuilder();

            int[] processstart=start.clone();
            int[] processend=new int[tasks];

            Arrays.sort(processstart);

            for(int i=0;i<tasks;i++){

                //int elem=processstart[i];

                for(int j=0;j<tasks;j++){

                    if(processstart[i]==start[j]){
                        processend[i]=end[j];

                    }


                }



            }


            int index=0;
            int processed=0;
            while (true){

                processed=0;
                int endtime=processend[index];
                assigned[index]=1;
                counter++;

                for (int i=index+1;i<tasks;i++){

                        if(processstart[i]>=endtime&&assigned[i]!=1){
                            index=i;
                            processed=1;
                            break;
                        }


                }

                if(processed==0){
                    break;
                }




            }


            int Jindex=0;
            for(int i=0;i<tasks;i++){

                if(assigned[i]==0){
                    Jindex=i;
                    break;
                }


            }


            if(Jindex!=0) {
                processed = 0;
                index = Jindex;
                while (true) {

                    processed = 0;
                    int endtime = processend[index];
                    assigned[index] = 2;
                    counter++;

                    for (int i = index + 1; i < tasks; i++) {

                        if (processstart[i] >= endtime && assigned[i] != 1) {
                            index = i;
                            processed = 1;
                            break;
                        } else if (processstart[i] < endtime && assigned[i] != 1 && counter < tasks) {
                            impossible = true;
                            break;
                        }


                    }

                    if (processed == 0) {
                        break;
                    }


                }
            }



            if(impossible!=true){


                for(int i=0;i<processstart.length;i++){

                    for(int j=0;j<start.length;j++){

                        if(processstart[i]==start[j]){
                            answer[j]=assigned[i];
                        }


                    }

                }




                for(int i=0;i<answer.length;i++){
                    if(answer[i]==1){
                        sb.append('C');
                    }
                    else if(answer[i]==2){
                        sb.append('J');
                    }else {
                        sb.append('W');
                    }
                }


                out.println("Case #"+(ll+1)+": "+sb);






            }else if(impossible==true){
                out.println("Case #"+(ll+1)+": "+"IMPOSSIBLE");
            }








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
