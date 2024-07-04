import java.util.ArrayList;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {


        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        for(int i = 0; i < t; i++) {
            int n = sc.nextInt();

            int s[] = new int[n];
            int e[] = new int[n];

            for(int j = 0; j < n; j++) {
                 s[j] = sc.nextInt();
                 e[j] = sc.nextInt();
            }


            //logic
            StringBuilder y = new StringBuilder();
            int order[] = new int[n];
            for(int l = 0; l < n; l++) {
                order[l] = l;
            }

            //sort
            for(int a = 0; a < n; a++) {
                for(int b = 0; b < n-1; b++) {
                    if(e[b] > e[b+1]) {
                        int temp = e[b];
                        e[b] = e[b+1];
                        e[b+1] = temp;

                        temp = s[b];
                        s[b] = s[b+1];
                        s[b+1] = temp;

                        temp = order[b];
                        order[b] = order[b + 1];
                        order[b + 1] = temp;
                    }
                }
            }


            boolean impossible = false;

            ArrayList<Integer> bufferS = new ArrayList<Integer>();

            ArrayList<Integer> bufferE = new ArrayList<Integer>();

            int k = 0;
            while(k < n) {

                if(bufferS.isEmpty()) {
                    bufferS.add(s[k]);
                    bufferE.add(e[k]);
                    y.append("J");
                }
                else {
                    //check overlap with all buffer elems
                    if(bufferE.size() == 2) {
                        if(bufferE.get(0) > s[k] && bufferE.get(1) > s[k]) {
                            impossible = true;
                            break;
                        }
                        if(bufferE.get(0) > s[k]) {
                            //overlap with 0 only
                            bufferE.remove(1);
                            bufferS.remove(1);
                            bufferE.add(1, e[k]);
                            bufferS.add(1, s[k]);
                            y.append("C");
                        }
                        else{
                            //overlap with 1 only
                            bufferE.remove(0);
                            bufferS.remove(0);
                            bufferE.add(0, e[k]);
                            bufferS.add(0, s[k]);
                            y.append("J");
                        }
                    }
                    else {
                        //size == 1
                        if(bufferE.get(0) > s[k]) {
                            //overlap
                            bufferE.add(e[k]);
                            bufferS.add(s[k]);
                            y.append("C");

                        }
                        else {
                            //no overlap
                            bufferE.clear();
                            bufferS.clear();
                            y.append("J");
                            bufferE.add(e[k]);
                            bufferS.add(s[k]);
                        }
                    }

                }
                k++;

            }

            //StringBuilder fin = new StringBuilder();


            char[] fin = new char[n];

            //fin[n] = 0;



            if(!impossible) {
                for(int l = 0; l < n; l++) {
                    fin[order[l]] = y.charAt(l);
                }
            }
            String out = new String(fin);
            if(impossible) {
                out = "IMPOSSIBLE";
            }



            //output
            System.out.println("Case " + (i + 1) + ": " + out);
        }









    }
}
