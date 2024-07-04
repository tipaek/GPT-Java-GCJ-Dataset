import java.util.*;

class Vestigium{
    
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int count = scanner.nextInt();
        
        for(int i=0;i<count && count>=1 && count<=100;i++){
            int n =  scanner.nextInt();
            if(n>=2 && n<=100){
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
                    HashSet<Integer> set = new HashSet<Integer>();
                    for(int k=0;k<n;k++){
                        if(set.add(matrix[j][k])==false){
                            inrow++;
                            break;
                        }
                    }
                }
                for(int j=0;j<n;j++){
                    HashSet<Integer> set = new HashSet<Integer>();
                    for(int k=0;k<n;k++){
                        if(set.add(matrix[k][j])==false){
                            incolumn++;
                            break;
                        }
                    }
                }
                System.out.println("Case #"+(i+1)+": "+trace+" "+inrow+" "+incolumn);
            }
        }
    }
}