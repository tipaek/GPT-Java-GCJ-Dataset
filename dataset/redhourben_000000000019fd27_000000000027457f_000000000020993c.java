import java.util.Scanner;
import java.util.Random;
 
public class Vestigium {
    public static void main(String args[]) {
        int T,N,NT=0;
        int sum=0;
        int summation[]= new int[20];
        int repeatedrow[]= new int[20];
        int repeatedcol[]= new int[20];
            int array[][]= new int[20][20];       
            int repeated_row=0;
            int repeated_column=0;
 
        Scanner sc = new Scanner(System.in);
        T = sc.nextInt();
        for(int i=0; i<T; i++) {
            N=sc.nextInt();
            sum=0;
            for(int j=0; j<N; j++) {
                for(int k=0; k<N; k++) {
                    array[j][k] = sc.nextInt();
                    if(j==k) {
                        sum+=array[j][k];
                    }
                }
            }
            summation[i]=sum; 
            repeated_row=0; 
            for(int p=0; p<N; p++) {
                for(int q=0; q<N; q++) {
                    if(array[p][q]==array[p][q+1]) {
                        ++repeated_row;
                        break;
                    }
                }
            }
            repeatedrow[i]=repeated_row;
                
            repeated_column=0;
            for(int q=0; q<N; q++) {
                for(int p=0; p<N; p++) {
                    if(array[p][q]==array[p+1][q]) {
                        ++repeated_column;
                        break;
                    }
                }
            }            
            repeatedcol[i]=repeated_column;
        }
        
        for(int out=0; out<T; out++) {
            System.out.println("Case #"+(out+1)+": "+summation[out]+" "+repeatedrow[out]+" "+repeatedcol[out]);
        }
        
        
    }

}
