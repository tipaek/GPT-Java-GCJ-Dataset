import java.util.Scanner;
import java.util.Arrays;
import java.util.Comparator;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();

        for(int test = 1; test<=t; test++){
            int n = scan.nextInt();
            String[] list = new String[n];
            for(int i = 0; i<n; i++){
                list[i] = scan.next();
            }


            boolean c = false;
            String check = "";
            ArrayList<ArrayList<Integer>> arr = new ArrayList<>();
            for(int j = 0; j<n; j++) {
                for (int i = 0; i < n; i++) {
                    if(i == j) continue;
                    ArrayList<Integer> l = new ArrayList<>();
                    l.add(Math.max(i, j));
                    l.add(Math.min(i, j));
                    if(arr.contains(l) ) continue;
                    arr.add(l);
                    String temp = check(list[i], list[j]);
                  //  System.out.println(list[i] + " " + list[j] + " " + temp);
                    if (temp.equals("")) c = true;
                    if (check.length() <= temp.length()) check = temp;
                }
            }

            if(c) System.out.println("Case #" + test + ": *");
            else System.out.println("Case #" + test+": " + check);

        }
    }

    public static String check(String a, String b){


        int acount = 0;
        int bcount =0;
        String ans = "";
        while(a.indexOf('*', acount) != -1 && b.indexOf('*', bcount) != -1){
            int acur = a.indexOf('*', acount); //0
            int bcur = b.indexOf('*', bcount); //4



           String aBef = a.substring(acount, acur);
           String bBef = b.substring(bcount, bcur);


           if(aBef.length() > bBef.length()) {
              if(! aBef.contains(bBef)) return "";
              else {
                  ans += aBef;
                  acount = acur+1;
                  bcount = bcur+1;
                  continue;
              }
           }
           else{
               if(!bBef.contains(aBef)){
                   return "";
               }
               else{
                   ans += bBef;
                   acount = acur+1;
                   bcount = bcur +1;
               }
           }


           if(acount >= a.length() || bcount >= b.length()){
              break;
           }
        }

        String aBef = a.substring(acount);
        String bBef = b.substring(bcount);

        if(aBef.length() > bBef.length()){
            if(aBef.lastIndexOf(bBef) == aBef.length() - bBef.length()){

                ans+= aBef;
                return ans;
            }
            else return "";
        }
        else {
            if(bBef.lastIndexOf(aBef) == bBef.length() - aBef.length()){

                ans += bBef;
                return ans;
            }
            else return "";
        }

    }
}
