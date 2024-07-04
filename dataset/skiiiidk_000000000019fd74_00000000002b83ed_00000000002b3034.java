import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Comparator;
import java.util.Collections;
import java.util.ArrayList;

public class Solution {
    private static class Comp implements Comparator<String> {
        public int compare(String o1, String o2) {
            return Integer.compare(o1.length(), o2.length());
        }
    }
    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(System.in);
        BufferedWriter log = new BufferedWriter(new OutputStreamWriter(System.out));
        //log.write() //log.flush()
        int t = scan.nextInt();
        int count = 1;
        while(t-- >0){
            int nT = scan.nextInt();
            scan.nextLine();
            String[] s = new String[nT];
            for(int i = 0; i<nT; i++){

                s[i] = scan.nextLine();
            }
            ArrayList<String> pre = new ArrayList<>();
            ArrayList<String> suf = new ArrayList<>();

            for(int i = 0; i<nT; i++){
                //System.out.println(i);
                if(s[i].length() < 1){

                }
                else if(s[i].charAt(0) == '*'){
                    suf.add(s[i]);
                }
                else if(s[i].charAt(s[i].length()-1) == '*'){
                    pre.add(s[i]);
                }
            }

            Collections.sort(pre, new Comp());
            Collections.sort(suf, new Comp());



            boolean nC = false;
            String pL = "";
            if(pre.size() >= 1) {
                pL = pre.get(pre.size() - 1);
                for(String p: pre){

                    if(!pL.contains(p.substring(0,p.length()-1))){
                        nC = true;
                    }
                }
                pL = pL.substring(0,pL.length()-1);
            }
            else{
                pL = "";
            }

            String sL = "";
            if(suf.size() >=1) {
                sL = suf.get(suf.size() - 1);
                for(String su: suf){
                    if(!sL.contains(su.substring(1))){
                        nC = true;
                    }
                }

                sL = sL.substring(1);
            }
            else{
                sL = "";
            }


            //System.out.println(pL);
            //System.out.println(sL);





            String ans = "";
            if(!nC) {
                ans =  pL+sL ;
            }
            else{
                ans = "*";
            }






            log.write("Case #" + (count) + ": " + ans + "\n");
            //System.out.println(colRep);
            count++;
        }
        log.flush();





    }
}