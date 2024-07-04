import java.util.*;
import java.io.*;
public class Solution{
    public static void main(String[]args){
        Scanner in = new Scanner (System.in);
        int T = in.nextInt(), i=0, j=0, sum=0, contR=0, contC=0, cont=1;
        int N = 0;
            
       do{
            N = in.nextInt();
            int[][] Mat = new int[N][N];
            i=0;
            j=0;
            Mat[i][j] = 0;
            for(i=0; i<N; i++){
                Mat[i][j] = in.nextInt();
                if(i==j)
                sum+=Mat[i][j];
            }
            j+=1;
            do{
               i=0;
               for(i=0; i<N; i++){
                   Mat[i][j] = in.nextInt();
                   if(i==j)
                   sum+=Mat[i][j];
               }
               j+=1;
            }while(j<N);
            contR = ripRighe(Mat);
            contC = ripCol(Mat);
            T-=1;
            System.out.println("Case #"+cont+": "+sum+" "+contR+" "+contC);
            cont++;
            sum =0;
       }while(T>0);
    
        
    
    }
    public static int ripRighe(int[][]M){
       int contRighe=0, righe=0, col=0;
       
       while(righe<M.length){
           int[] array = new int[M.length];
       for(int indx = 0; indx<array.length; indx++){
           array[indx] = 0;
       }
       for(col=0; col<M.length; col++){
           array[col] = M[col][righe];
       }
       Arrays.sort(array);
       do{
           for(int temp=0,  indx=1; indx<array.length; indx++){
               temp = array[indx-1];
               if(temp == array[indx]){
               contRighe += 1;
               break;
            }
               else{
               contRighe+=0;
               
            }
           } 
       }while(col<array.length);
       righe++;
    }return contRighe;
 }
 public static int ripCol(int[][]M){
     int contCol=0, righe=0, col=0;
     while(col<M.length){
         int[] array = new int[M.length];
         for(int indx=0; indx<array.length; indx++){
             array[indx] = 0;
         }
         for(righe=0; righe<M.length; righe++){
             array[righe] = M[col][righe];
         }
         Arrays.sort(array);
         do{
             for(int temp=0, indx=1; indx<array.length; indx++){
                temp = array[indx];
                if(temp == array[indx-1]){
                    contCol +=1;
                    break;
                }
                else{
                    contCol +=0;
                }
             }
         }while(righe<array.length);
         col++;
     }
     return contCol;
 }

}