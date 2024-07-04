import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Solution {

    private static final Scanner numScan=new Scanner(System.in), chrScan=new Scanner(System.in);
    
    public static void main(String[] args) {
        
        int T=numScan.nextInt();
        if(T>=1 && T<=100){
            int X[][]=new int[T][3];
            for (int eT = 0; eT < T; eT++) {
                int N=numScan.nextInt();
                if(N>=2 && N<=100){
                    int M[][]=new int[N][N];
                    int trace=0;
                    for (int i = 0; i < N; i++) {
                        X[eT][1]=0;
                        for (int j = 0; j < N; j++) {
                            M[i][j]=numScan.nextInt();
                            if(j==i){trace+=M[i][j];}
                        }
                    }
                    
                    X[eT][0]=trace;
                    int result[]=processMatrix(M, N);
                    X[eT][1]=result[0];
                    X[eT][2]=result[1];
                }
            }
            
            for (int eT = 0; eT < T; eT++) {
                System.out.println("Case #"+(eT+1)+": "+X[eT][0]+" "+X[eT][1]+" "+X[eT][2]);
            }
        }
        
    }
    
    private static int[] processMatrix(int[][] matrix, int length){
        int result[]={0, 0};
        
        int flipped[][]=new int[length][length];
        for(int i=0; i<length; i++){
            List<Integer> r=new ArrayList<>();
            boolean alreadyAdded=false;
            for(int j=0; j<length; j++){
                if(!alreadyAdded && r.contains(matrix[i][j])){
                    result[0]+=1;
                    alreadyAdded=true;
                }else if(!alreadyAdded){
                    r.add(matrix[i][j]);
                }
                flipped[j][i]=matrix[i][j];
            }
        }
        for(int i=0; i<length; i++){
            List<Integer> c=new ArrayList<>();
            boolean alreadyAdded=false;
            for(int j=0; j<length; j++){
                if(!alreadyAdded && c.contains(flipped[i][j])){
                    result[1]+=1;
                    alreadyAdded=true;
                }else if(!alreadyAdded){
                    c.add(flipped[i][j]);
                }
            }
        }
        
        return result;
    }
    
}
