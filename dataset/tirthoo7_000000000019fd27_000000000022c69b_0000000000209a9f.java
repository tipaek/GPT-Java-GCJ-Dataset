/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.util.*;
import java.io.*;

/**
 *
 * @author EliteBook
 */
public class Solution {

    /**
     * @param args the command line arguments
     */
    public static void main(String arg[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        for (int i = 1; i <= t; i++) {

            char[] s = br.readLine().trim().toCharArray();
            List<Character> resRev = new ArrayList<>();
            int op = 0;
            int cp = 0;
            char pd='n';
            for (int k=s.length-1;k>=0;k--) {
                char c=s[k];
                if (c == '0') {
//                    Balance The prev Result then add 0
                    while (cp > 0) {
                        resRev.add('(');
                        cp--;
                    }
                    resRev.add('0');
                    pd=c;
                } else {
                    
                    if(pd==c){
                        resRev.add(c);
                        continue;
                    }
                    int d = Integer.parseInt(c + "");
                    if (d > cp) {

                        while (d - cp > 0) {
                            cp++;
                            resRev.add(')');
                        }
                        resRev.add(c);
                    }
                    if(d<cp){
                        while(cp-d>0){
                            cp--;
                            resRev.add('(');
                        }
                        resRev.add(c);
                    }
                    pd=c;
                }

            }
            while(cp>0){
                resRev.add('(');
                cp--;
            }
//            System.out.println(resRev);
            StringBuilder res=new StringBuilder();
            for(int j=resRev.size()-1;j>=0;j--){
                res.append(resRev.get(j));
            }
//            System.out.println(res);
                System.out.println("Case #"+i+": "+res);
        }

    }
}
