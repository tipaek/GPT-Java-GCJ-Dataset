import java.util.*;

public class Solution{
    
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int count = scanner.nextInt();
        //int[][] solution= new int[count][3];
        for(int i=0;i<count;i++){
            int n =  scanner.nextInt();
            int[][] matrix = new int[n][n];
            for(int j=0;j<n;j++){
                for(int k=0;k<n;k++){
                    int number = scanner.nextInt();
                    matrix[j][k]=number;
                }
            }
            int trace=0;
            for(int j=0;j<n;j++){
                trace=trace+matrix[j][j];
            }
            int incolumn=0;
            int inrow=0;
            
            for(int j=0;j<n;j++){
                boolean found = false;
                for(int k=0;k<(n-1) && found==false;k++){
                    int number = matrix[j][k];
                    int l=k+1;
                    for(int o=l;o<n && found==false;o++){
                        if(number==matrix[j][o]){
                            inrow++;
                            break;
                        }
                    }
                }
            }
            for(int j=0;j<n;j++){
                boolean found = false;
                for(int k=0;k<(n-1) && found==false;k++){
                    int number = matrix[k][j];
                    int l=k+1;
                    for(int o=l;o<n && found==false;o++){
                        if(number==matrix[o][j]){
                            incolumn++;
                            break;
                        }
                    }
                }
            }
            System.out.println("Case #"+(i+1)+": "+trace+" "+inrow+" "+incolumn);
        }
        
    }
}