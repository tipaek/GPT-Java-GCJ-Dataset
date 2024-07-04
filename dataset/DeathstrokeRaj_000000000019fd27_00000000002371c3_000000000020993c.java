import java.util.Scanner;
public class Solution
{
    public static void main(String[] args)
    {

        Scanner scan = new Scanner(System.in);
        int t=scan.nextInt();
        int[][] colMatrix;
        int[][] rowMatrix;
        int[] r;
        int[] c;
        for(int z=1;z<=t;z++){
            int trace=0,rowCount=0,colCount=0,element=0;
            int n=scan.nextInt();
            rowMatrix=new int[n][n+1];
            colMatrix=new int[n][n+1];
            r=new int[n];
            c=new int[n];
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    element=scan.nextInt();
                    if(i==j){
                        trace+=element;
                    }
                    if(rowMatrix[i][element]==0){
                        rowMatrix[i][element]=1;
                    }
                    else{
                        rowMatrix[i][element]+=1;
                        if(r[i]==0)
                        rowCount++;
                        r[i]=1;
                    }
                    if(colMatrix[j][element]==0){
                        colMatrix[j][element]=1;
                    }
                    else{
                        colMatrix[j][element]+=1;
                        if(c[j]==0)
                        colCount++;
                        c[j]=1;
                    }
                }
            }
            System.out.println("Case #"+z+": "+trace+" "+rowCount+" "+colCount+"");
        }

    }
}

