import java.io.*;
import java.util.Scanner;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Solution {

    public static void main(String[] args){



        MyScanner sc = new MyScanner();

        out = new PrintWriter(new BufferedOutputStream(System.out));

        int tests=sc.nextInt();

        for(int ll=0;ll<tests;ll++){

          String str=sc.next();

          StringBuilder sb=new StringBuilder();

          int open=0;
          int close=0;

          for(int ii=0;ii<str.length();ii++){

              int num=Character.getNumericValue(str.charAt(ii));
              int prev=-1;
              if(ii>0){

                  prev=Character.getNumericValue(str.charAt(ii-1));
              }


              if(prev==num&&prev!=-1){

                  sb.append(num);

              }else{

                  if(num>open){

                      for(int i=open;i<num;i++){
                          sb.append('(');
                      }
                      sb.append(num);
                      open=num;

                  }

                  if(num<open){

                      for(int i=0;i<open-num;i++){
                          sb.append(')');
                      }
                      sb.append(num);
                      open=num;


                  }

                  if(num==0){
                      sb.append(num);
                  }


              }

              /*


              if(num>open){

                  for(int i=open;i<num;i++){
                      sb.append('(');
                  }
                  sb.append(num);
                  open=num;

              }

              if(num<open){

                  for(int i=0;i<open-num;i++){
                      sb.append(')');
                  }
                  sb.append(num);
                  open=open-num;


              }

               */




          }


          for(int i=0;i<open;i++){
              sb.append(')');
          }


         out.println("Case #"+(ll+1)+": "+sb);







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
