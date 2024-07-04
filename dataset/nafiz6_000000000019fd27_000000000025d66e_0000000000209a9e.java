import java.sql.SQLOutput;
import java.util.*;
import java.io.*;

class Pair implements Comparable{
    int st,end,ord;

    public Pair(int s, int e,int o){
        st=s;
        end=e;
        ord = o;
    }

    @Override
    public int compareTo(Object o) {
        int ost = ((Pair)o).st;
        return this.st - ost;
    }
}

public class Solution {

    public static String[] compute(String bits){
        StringBuilder neg = new StringBuilder(),
                rev = new StringBuilder(),both = new StringBuilder();
        for (int i=0;i<bits.length();i++){
            char c = bits.charAt(i);
            if (c=='1')neg.append('0');
            else neg.append('1');
            char ls = bits.charAt(bits.length()-i-1);
            rev.append(ls);
            if (ls=='1')both.append('0');
            else both.append('1');
        }
        String[] ret = {neg.toString(), rev.toString(), both.toString()};
        return  ret;
    }


    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int z = 1; z <= t; ++z) {
            int B = in.nextInt();
            StringBuilder known = new StringBuilder();

            //READ 10 bits
            int[] arr = new int[B];
            for (int i=0;i<B;i++)arr[i]=-1;
            for (int i=0;i<5;i++){
                System.out.println(i+1);
                System.out.flush();
                arr[i] = in.nextInt();
            }
            for (int i=0;i<5;i++){
                System.out.println(B-i);
                System.out.flush();
                arr[B-i-1] = in.nextInt();
            }
            if (B==10){
                StringBuilder sb= new StringBuilder();
                for (int i=0;i<B;i++) sb.append(arr[i]);
                System.out.println(sb.toString());
                System.out.flush();
                String inp = in.nextLine();
                while (true){
                    if (inp.equals("Y") || inp.equals("N"))break;
                    inp=in.nextLine();
                }
                if (inp.equalsIgnoreCase("N"))break;

            }
            else{
                int rem = B-10;
                int st = 6;
                int end = B-5;
                while (rem>0){
                    for (int i=0;i<B;i++){
                        if (arr[i]!=-1)known.append(arr[i]);
                    }
                    //verify 2 bits
                    String orig = known.toString();
                    String[] comp = compute(orig);
                    String neg =comp[0];
                    String rev = comp[1];
                    String both = comp[2];
                    Boolean negate=false;
                    Boolean reverse=false;
                    Boolean bothh = false;
                    if (orig.equalsIgnoreCase(rev) || orig.equalsIgnoreCase(both)){
                        //One is enuf
                        System.out.println(1);
                        System.out.flush();
                        int resp = in.nextInt();
                        if ((resp==0 && orig.charAt(0)=='1') || (resp==1 && orig.charAt(0)=='0'))negate=true;



                    }
                    else{
                        int sameInd=0;
                        int diffInd=0;
                        for (int i=0;i<orig.length();i++){
                            if (neg.charAt(i)==rev.charAt(i)){
                                sameInd=i;
                                break;
                            }
                        }
                        for (int i=0;i<orig.length();i++){
                            if (neg.charAt(i)!=rev.charAt(i)){
                                diffInd=i;
                                break;
                            }
                        }
                        int q1,q2;
                        if (sameInd < orig.length()/2){
                            System.out.println(sameInd+1);
                            System.out.flush();
                            q1 = in.nextInt();
                        }
                        else{
                            int sameInd2 = orig.length()-sameInd-1;
                            System.out.println(B-sameInd2);
                            System.out.flush();
                            q1 = in.nextInt();
                        }
                        if (diffInd < orig.length()/2){
                            System.out.println(diffInd+1);
                            System.out.flush();
                            q2 = in.nextInt();
                        }
                        else{
                            int diffInd2 = orig.length()-diffInd-1;
                            System.out.println(B-diffInd2);
                            System.out.flush();
                            q2 = in.nextInt();
                        }

                        if (q1==0 && orig.charAt(sameInd)=='0' ||
                            q1==1 && orig.charAt(sameInd)=='1'){
                            //orig or both
                            if (!(q2==0 && orig.charAt(sameInd)=='0' ||
                                    q2==1 && orig.charAt(sameInd)=='1')){
                                bothh=true;
                            }

                            }
                        else {
                            //neg or rev
                            if (q1 == 0 && neg.charAt(sameInd) == '0' ||
                                    q1 == 1 && neg.charAt(sameInd) == '1') {
                                negate = true;
                            } else reverse = true;
                        }

                        //comp both

                    }


                    //FIX arr[i]
                    if (negate){
                        for (int i=0;i<arr.length;i++){
                            if (arr[i]==0)arr[i]=1;
                            if (arr[i]==1)arr[i]=0;
                        }
                    }
                    if (reverse || bothh){
                        for (int i=0;i<arr.length;i++){
                            int temp = arr[i];
                            arr[i]=arr[arr.length-i-1];
                            arr[arr.length-i-1]=temp;
                        }
                        if (bothh){
                            for (int i=0;i<arr.length;i++){
                                if (arr[i]==0)arr[i]=1;
                                if (arr[i]==1)arr[i]=0;
                            }
                        }
                    }

                    if (rem>8) {

                        for (int i = 0; i < 4; i++) {
                            System.out.println(st);
                            System.out.flush();
                            arr[st-1] = in.nextInt();
                            st++;

                        }
                        for (int i = 0; i < 4; i++) {
                            System.out.println(end);
                            System.out.flush();
                            arr[end-1] = in.nextInt();
                            end--;

                        }
                        rem-=8;
                    }
                    else{
                        for (int i=0;i<rem;i++){
                            System.out.println(st);
                            System.out.flush();
                            arr[st-1] = in.nextInt();
                            st++;

                        }
                        rem=0;

                    }


                    //take 8 inputs


                }
                StringBuilder sb= new StringBuilder();
                for (int i=0;i<B;i++) sb.append(arr[i]);
                System.out.println(sb.toString());
                System.out.flush();
                String inp=in.nextLine();
                while (true){
                    if (inp.equals("Y") || inp.equals("N"))break;
                    inp=in.nextLine();
                }
                if (inp.equalsIgnoreCase("N"))break;

            }



            //read 2 bits for verification
            //read 8 bits
            //repeat



        }
    }
}