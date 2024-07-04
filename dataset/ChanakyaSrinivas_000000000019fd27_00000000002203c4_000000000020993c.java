import java.util.Scanner;

public class Solution {
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        int T=sc.nextInt();
        for(int t=1;t<=T;t++){
            int n=sc.nextInt(),c=0,r=0,l=0;
            int array[][]=new int[n][n];
//            System.out.print(xor+" ");
            for(int i=0;i<n;i++){
                int cou[]=new int[n];
                for(int j=0;j<n;j++){
                    array[i][j]=sc.nextInt();
                    cou[array[i][j]-1]++;
                    if(i==j)
                        l+=array[i][j];
                }
                for(int j=0;j<n;j++){
                    if(cou[j]==0){
                        r++;
                        break;
                    }
                }
            }
            for(int i=0;i<n;i++){
                int cou[]=new int[n];
                for(int j=0;j<n;j++)
                    cou[array[j][i]-1]++;
                for(int j=0;j<n;j++){
                    if(cou[j]==0){
                        c++;
                        break;
                    }
                }
            }
            System.out.println("Case #"+(t)+": "+l+" "+r+" "+c);
        }
    }
}
