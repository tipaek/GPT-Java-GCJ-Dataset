import java.util.Scanner;

class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int ntc = sc.nextInt();
        int currTest = 1;
        while (currTest<=ntc) {
            int N = sc.nextInt();
            int[][] mat = new int[N][N];
            int[] markR = new int[N+1];
            int[] markC = new int[N+1];
            int trace=0;
            int cr=0;
            int cc=0;
            boolean sameR = false;
            boolean sameC = false;
            for(int i=0;i<N;i++){
                for(int j=0;j<N;j++){
                    mat[i][j] = sc.nextInt();
                }
            }

            for(int i=0;i<N;i++){
                sameR =false;
                sameC =false;
                for(int j=0;j<N;j++){
                    if(i==j) {
                        trace += mat[i][j];
                    }
                    if(markR[mat[i][j]]!=i+1){
                        markR[mat[i][j]] = i+1;
                    }else{
                        sameR = true;
                    }
                    if(markC[mat[j][i]]!=i+1){
                        markC[mat[j][i]] = i+1;
                    }else{
                        sameC = true;
                    }
                }
                if(sameR){
                    cr+=1;
                }
                if(sameC){
                    cc+=1;
                }
            }
            System.out.println("Case #"+currTest+":"+" "+trace+" "+cr+" "+cc);
            currTest++;
        }
    }

}