/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author aleks
 */
public class Solution {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        Scanner sc=new Scanner(System.in);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        
        int t=sc.nextInt();
        for(int x=0;x<t;x++){
            List<Integer>tmpRowList=new ArrayList<>();
            
            int k=0,r=0,c=0;
            int n=sc.nextInt();
            int [][] matrix=new int[n][n];
            for(int i=0;i<matrix.length;i++){
                List<Integer> addNumber=new ArrayList<>();
                String  lines = br.readLine();    
                    String[] strs = lines.trim().split("\\s+");
                    for (int z = 0; z < strs.length; z++) {
                        addNumber.add(Integer.parseInt(strs[z]));
                    }
                for(int j=0;j<matrix[i].length;j++){
                    matrix[i][j]=addNumber.get(j);
                    tmpRowList.add(matrix[i][j]);
                }
                tmpRowList.stream().distinct();
                for(int a=0;a<tmpRowList.size();a++){
                    int count=-1;
                    for(int j=0;j<matrix[i].length;j++){
                        if(tmpRowList.get(a)==matrix[i][j]){
                            count++;
                        }
                    }
                    if(count>=1){
                        r++;
                        break;
                    }
                }
            }
            for(int i=0;i<matrix.length;i++){
                int count=-1;
                for(int j=0;j<matrix.length;j++){
                    if(matrix[i][0]==matrix[j][0]){
                        count++;
                        if(count>=1){
                            c++;
                            break;
                        }
                    }
                   
                }
               
                
            }
            k=caclSum(matrix);
            System.out.println("Case #"+(x+1)+":"+ k+" "+r+" "+c);
           
        }
        
        
    }
    static int caclSum(int [][] matrix){
        int sum=0;
        for(int i=0;i<matrix.length;i++){
                for(int j=0;j<matrix[i].length;j++){
                    if(i==j){
                        sum+=matrix[i][j];
                    }
                }
        }
        return sum;
    }

    
}
