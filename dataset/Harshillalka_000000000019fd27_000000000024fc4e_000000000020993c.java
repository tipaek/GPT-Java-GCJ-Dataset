import java.util.*;

class Solution{
    
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
                    boolean found = false;
                    HashSet<Integer> set = new HashSet<Integer>();
                    for(int k=0;k<n && found==false;k++){
                        if(set.add(matrix[j][k])==false){
                            inrow++;
                            found=true;
                        }
                    }
                    boolean found1 = false;
                    HashSet<Integer> seta = new HashSet<Integer>();
                    for(int k=0;k<n && found1==false;k++){
                        if(seta.add(matrix[k][j])==false){
                            incolumn++;
                            found1=true;
                        }
                    }
                }
                System.out.println("Case #"+(i+1)+": "+trace+" "+inrow+" "+incolumn);
            }
        }
    }
}