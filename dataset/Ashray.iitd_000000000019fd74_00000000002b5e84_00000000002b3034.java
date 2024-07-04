import java.util.*;
import java.io.*;


public class Solution{

    public static String f(String[] arr,int[] idx, int max,String maxlen){
        if(max == 0){
            String comp = maxlen.substring(1);
            for(String temp:arr){
                String aa = temp.substring(1);
                if(!aa.equals(maxlen.substring(maxlen.length()-aa.length())))
                    return "*";
            }
            return comp;
        }

        if(max != 0){
            int n = arr.length;
            String[] arr1 = new String[n];
            String[] arr2 = new String[n];
            String maxstart = "",maxend="";
            int idxa=0;
            for(String temp:arr){
                int t = temp.indexOf("*");
                String s1 = temp.substring(0,t);
                String s2 = temp.substring(t+1);
                arr1[idxa]=s1;
                arr2[idxa]=s2;
                idxa++;
                if(maxstart.length()<s1.length())
                    maxstart = s1;
                if(maxend.length()<s2.length())
                    maxend = s2;
            }
            // System.out.println(maxstart+" "+maxend+"p");
            for(String temp:arr1){
                if(!temp.equals(maxstart.substring(0,temp.length()))){
                    // System.out.println(maxstart.substring(0,temp.length()));
                    // System.out.println(temp);
                    return "*";
                }
            }
            for(String temp:arr2){
                if(!temp.equals(maxend.substring(maxend.length()-temp.length()))){
                    // System.out.println(maxend.substring(maxend.length()-temp.length()));
                    // System.out.println(temp);
                    return "*";

                }
            }
            return maxstart+maxend;
        }



        return "*";
    }

    public static void main(String[] args){
        Scanner s= new Scanner(System.in);
        int T = s.nextInt();
        for(int t=0;t<T;t++){
            int n = s.nextInt();
            String[] arr = new String[n];
            // ArrayList<ArrayList<Integer>> arr = new ArrayList<Integer>();
            int[] idx = new int[n];
            int max = 0;
            String maxlen = "";
            for(int i=0;i<n;i++){
                String temp = s.next();
                arr[i]=temp;
                idx[i] = temp.indexOf("*");
                if(idx[i]>max)
                    max = idx[i];
                if(temp.length()>maxlen.length()){
                    maxlen = temp;
                }
            }
            String toreturn = f(arr,idx,max,maxlen);
            System.out.println("Case #"+Integer.toString(t+1)+": "+toreturn);
        }
        
    }
}