import java.util.*;

class Solution{
    
    static int trace(int matrix[][], int N){
        int sum = 0;
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                if(i == j){
                    sum += matrix[i][j];
                }
            }
        }
        return sum;
    }
    
    static int countRepeatedValuesInaRow(int matrix[][], int N){
        int count = 0;
        for(int i=0;i<N;i++){
            Set<Integer> set = new HashSet<Integer>();
            for(int j=0;j<N;j++){
                set.add(matrix[i][j]);
            }
            if(set.size() != N) count++;
        }
        return count;
    }
    
    static int countRepeatedValuesInaColumn(int matrix[][], int N){
        int count = 0;
        for(int i=0;i<N;i++){
            Set<Integer> set = new HashSet<Integer>();
            for(int j=0;j<N;j++){
                set.add(matrix[j][i]);
            }
            if(set.size() != N) count++;
        }
        return count;
    }
    
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int T = scan.nextInt();
        for(int t=0;t<T;t++){
            int N = scan.nextInt();
            int[][] matrix = new int[N][N];
            for(int i=0;i<N;i++){
                for(int j=0;j<N;j++){
                    while(true){
                        if(scan.hasNextInt()){
                            matrix[i][j] = scan.nextInt();
                            if(matrix[i][j] <= N && matrix[i][j] >=1)
                                break;
                        }
                        else{
                            scan.next();
                        }
                    }
                }
            }
            System.out.println("Case #"+ t +": " + trace(matrix,N) +" "+ countRepeatedValuesInaRow(matrix,N)+" "+ countRepeatedValuesInaColumn(matrix,N));
        }
    }
}