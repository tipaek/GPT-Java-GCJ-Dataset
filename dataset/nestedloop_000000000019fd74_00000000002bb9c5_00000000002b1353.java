import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Bohdan
 */
public class Solution {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int test = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int t = 1; t <= test; ++t) {
            int n = in.nextInt();
            System.out.println("Case #" + t + ": ");
            if (n == 1){
                System.out.println("1 1");
            }
            else if ((n<999)&&(n>1)){
                int step = (n+1)/2;
                int pos = n/2+1;
                for (int i=0; i<step; i++){
                    System.out.println((i+1)+" 1");                    
                }
                System.out.println(pos+" 2");
            }
            else if ((n==1000)||(n==999)){
                n = n-2;
                int step = (n+1)/2;
                int pos = n/2+1;
                for (int i=0; i<step; i++){
                    if (i!=3){
                        System.out.println((i+1)+" 1"); 
                    }
                    else{
                        System.out.println((i+1)+" 2");
                    }
                }
                System.out.println(pos+" 2");
            }          
            
            
            
            
        }
    }
    
}
