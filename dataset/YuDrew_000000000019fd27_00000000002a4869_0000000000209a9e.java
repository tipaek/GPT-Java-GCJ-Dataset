/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author yudrew
 */
import java.util.*;
import java.io.*;
public class Solution {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = sc.nextInt(), b = sc.nextInt();
        
    }//main
    
    public static void test(Scanner sc, int b){
        //begin searching and populating
        int querynum = 0;
        boolean hasAnswer = false;
        List<Integer> changeLog = new LinkedList<>();
        int[] array = new int[b];
        //potential changes are logged as follows: 
        // 0 - Nothing
        // 1 - Complement
        // 2 - Reverse
        // 3 - Complement & Reverse
        //We will track the current array by performing the transformation as necessary
        do{
            querynum++;
            //if(querynum % 10 == 1){
                //consider potential changes
            //}else{
                //for first 10
                System.out.println(querynum);
                array[querynum - 1] = sc.nextInt();
            //}
            
        }while(!hasAnswer || querynum == 150);
        String guessString = "";
        for(int i : array){
            guessString += i;
        }
        System.out.print(guessString);
        String correct = sc.next();
    }
}//Solution
