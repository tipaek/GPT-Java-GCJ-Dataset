/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//package googlecodejam;
import java.util.*;
import java.lang.*;

/**
 *
 * @author hp
 */
public class Solution {   
    

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       Scanner sc = new Scanner(System.in);
       
       int T = sc.nextInt();
       int A = sc.nextInt();
       int B = sc.nextInt();
       sc.nextLine();
       for(int i = 0; i < T; i++)
       {
            if(A == B && A == 999999995)
            {
                String res = "";
                boolean found  = false;
                boolean exit = false;
                for(int j = 0; j < 11; j++)
                {
                    for(int k = 0; k < 11; k++)
                    {
                          System.out.println((j-5) + " " + (k-5));
                          res = sc.nextLine();
                          if(res.compareTo("CENTER") == 0)
                          {
                              found  = true;
                              break;
                          }
                          else if(res.compareTo("WRONG")!=0)
                          {
                              exit = true;
                              break;
                          }
                    }
                    if(found || exit)
                        break;
                }
                if(exit)
                    break;
                
            }
            else
            {
                String res = "";
                while(res.compareTo("WRONG")!=0)
                {
                    System.out.println("0 0");
                    res = sc.nextLine();
                }
                break;
            }
       }
    }
    
}
