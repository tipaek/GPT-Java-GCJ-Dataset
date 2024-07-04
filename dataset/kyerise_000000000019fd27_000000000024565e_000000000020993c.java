/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication3;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 *
 * @author com4t
 */
public class JavaApplication3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        Scanner s = new Scanner(System.in);
        int T = s.nextInt();
        for (int i = 0; i < T; i++) {
            int N = s.nextInt();
            int m[][] = new int[N][N];
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < N; k++) {
                    m[j][k] = s.nextInt();
                }
            }
            analysis(i+1,N,m);
        }
    }

    private static void analysis(int i, int N, int[][] m) {
        System.out.println("Case #"+i+" "+trace(m)+" "+repeatedRows(m)+" "+repeatedCols(m)+" ");
    }

    private static int trace(int[][] m) {
        int r=0;
        for(int i=0;i<m.length;i++){
        r+=m[i][i];
        }
        return r;}

    private static int repeatedRows(int[][] m) {
        int r=0;
            Set<Integer> st=new HashSet<>(m.length);
        for(int i=0;i<m.length;i++){
            st.clear();
                for (int k = 0; k < m.length; k++) {
                    st.add(m[i][k]);
                }
                if(st.size()!=m.length){
                    r++;
                }
            //System.out.println("sum:"+i+"="+sum);
        }
        return r;}
    
    private static int repeatedCols(int[][] m) {
        int r=0;
            Set<Integer> st=new HashSet<>(m.length);
        for(int i=0;i<m.length;i++){
            st.clear();
                for (int k = 0; k < m.length; k++) {
                    st.add(m[k][i]);
                }
                if(st.size()!=m.length){
                    r++;
                }
            //System.out.println("len"+m.length+"max"+max+" rsum:"+i+"="+sum+" ?"+(sum==max));
        }
        return r;}

}
