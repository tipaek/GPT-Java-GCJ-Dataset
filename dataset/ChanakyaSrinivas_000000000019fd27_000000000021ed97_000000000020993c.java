import java.util.Scanner;

public class Solution {
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        int T=sc.nextInt();
        for(int t=1;t<=T;t++){
            int n=sc.nextInt(),xor=0,c=0,r=0,l=0;
            int array[][]=new int[n][n];
            for(int i=1;i<=n;i++)
                xor^=i;
//            System.out.print(xor+" ");
            for(int i=0;i<n;i++){
                int temp=0;
                for(int j=0;j<n;j++){
                    array[i][j]=sc.nextInt();
                    temp^=array[i][j];
                    if(i==j)
                        l+=array[i][j];
                }
//                System.out.print(temp+" ");
                if(temp!=xor)
                    r++;
            }
            for(int i=0;i<n;i++){
                int temp=0;
                for(int j=0;j<n;j++){
                    temp^=array[j][i];
                }
//                System.out.println(temp+" ");
                if(temp!=xor)
                    c++;
            }
            System.out.println("Case #"+(t)+": "+l+" "+r+" "+c);
        }
    }
}
