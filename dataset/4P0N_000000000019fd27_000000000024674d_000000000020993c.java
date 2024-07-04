import java.util.Scanner;

public class vestigium {

    public static void main(String[] args) {

        int t;
        Scanner scn=new Scanner(System.in);
        t=scn.nextInt();

        String ans="";
        int caseNo=0;

        while(t-- > 0){
            caseNo++;
            int n=scn.nextInt();
            int[][] mat=new int [n][n];
            int sum=0;
            //System.out.println(n);

            for(int i=0;i<n;i++) {
                for (int j = 0; j < n; j++) {
                    mat[i][j] = scn.nextInt();
                    if (i == j) sum += mat[i][j];
                }
            }
            int rowCount=0,k;
            for(int i=0;i<n;i++){
                for(int j=0;j<n-1;j++){
                    for(k=j+1;k<n;k++){
                        if(mat[i][j]==mat[i][k]) break;
                    }
                    if(k<n) rowCount++;
                    break;
                }
            }

            int colCount=0;
            for(int j=0;j<n;j++){
                for(int i=0;i<n-1;i++){
                    for(k=i+1;k<n;k++){
                        if(mat[i][j]==mat[k][j]) break;
                    }
                    if(k<n) colCount++;
                    break;
                }
            }


            ans+= "Case " + caseNo + ": " + sum + " " + rowCount + " " + colCount + "\n";

        }

        System.out.print(ans);
    }
}
