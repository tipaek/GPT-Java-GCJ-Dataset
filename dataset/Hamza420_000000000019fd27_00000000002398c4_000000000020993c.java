/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author M Hamza Khan
 */
import java.util.Scanner;
public class Hamza_CodeJam {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        Scanner input =new Scanner(System.in);
        
        System.out.print("Enter nuber of Test Cases");
        int n = input.nextInt();
        
        for(int a=1;a<=n;a++) {
        
        System.out.print("Enter Matrix "+a+" Size NxN:");
        int s = input.nextInt();
        int[][] M1 = new int[s][s];
        int diagonalSum =0;
        for(int i=0;i<M1.length;i++) {
            for(int j=0;j<M1[i].length;j++) {
                System.out.print("Enter Matrix Elements");
                M1[i][j] = input.nextInt();
                
                int RepeatedRows=0;
                if(M1[i][0]==M1[j][0]) {
                    RepeatedRows++;
            }
                int RepeatedColumns=0;
                if(M1[0][i]==M1[0][j]) {
                    RepeatedColumns++;
                    
           }
                if(i==j) {
                    diagonalSum+=M1[i][j];
                   
                }
                System.out.print("Case #"+a+":"+diagonalSum+" "+RepeatedRows+" "+RepeatedColumns);
            }
        }
        
        }
    }
}

        
        
        
    
    

