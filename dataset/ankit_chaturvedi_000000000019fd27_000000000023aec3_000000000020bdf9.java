

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

class Solution{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        int count = 1;
        StringBuffer sbuf = new StringBuffer();
        while(t-->0){
            int n = Integer.parseInt(br.readLine().trim());
            ArrayList<ArrayList<Integer>> list=  new ArrayList<>();

            for(int i=0;i<n;i++){
                String[] values = br.readLine().split(" ");
                ArrayList<Integer> temp = new ArrayList<>();
                temp.add(Integer.parseInt(values[0]));
                temp.add(Integer.parseInt(values[1]));
                list.add(temp);
            }
            sbuf.append("Case #"+count+": ");
            printvalue(list,sbuf);
            sbuf.append("\n");
            count++;
        }
        System.out.println(sbuf);

    }
    public static void printvalue(ArrayList<ArrayList<Integer>> list,StringBuffer sbuf){
        ArrayList<ArrayList<Integer>> l = new ArrayList<>();


        for(int i=0;i<list.size();i++) {
            ArrayList<Integer> temp = new ArrayList<>();
            temp.add(list.get(i).get(0));
            temp.add(list.get(i).get(1));
            temp.add(i);

            l.add(temp);}


            Collections.sort(l, new Comparator<ArrayList<Integer>>() {
                @Override
                public int compare(ArrayList<Integer> o1, ArrayList<Integer> o2) {
                    return o1.get(0).compareTo(o2.get(0));
                }
            });



            int c = 0;
            int j = 0;
            boolean flag = true;
            ArrayList<ArrayList<String>> arr = new ArrayList<>();

            for(int i=0;i<l.size();i++){

                if(l.get(i).get(0)<c&&l.get(i).get(0)<j){
                    flag = false;
                    break;
                }

                if(l.get(i).get(0) >= c){
                    ArrayList<String> t = new ArrayList<>();
                    t.add(Character.toString('C'));
                    t.add(Integer.toString(l.get(i).get(2)));
                    arr.add(t);
                    c = l.get(i).get(1);
                }

                else{
                    ArrayList<String> t = new ArrayList<>();
                    t.add(Character.toString('J'));
                    t.add(Integer.toString(l.get(i).get(2)));
                    arr.add(t);
                    j = l.get(i).get(1);
                }

            }


         if(flag!=true){
             sbuf.append("IMPOSSIBLE");
         }
         else {
             Collections.sort(arr, new Comparator<ArrayList<String>>() {
                 @Override
                 public int compare(ArrayList<String> o1, ArrayList<String> o2) {
                     return o1.get(1).compareTo(o2.get(1));
                 }
             });
            for(int k=0;k<arr.size();k++)
                sbuf.append(arr.get(k).get(0));
         }



        }







    }





