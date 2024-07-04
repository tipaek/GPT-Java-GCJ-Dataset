import java.util.Scanner;
public class Solution{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int t1 = sc.nextInt();
        int count=0;
        while(++count<=t1){
            int n=sc.nextInt();
            boolean[][] col =new boolean[n][n];
            boolean[] colstat = new boolean[n];
            int r=0;
            int k=0;
            int c=0;
            for(int i=0;i<n;i++){
                boolean row[]=new boolean[n];
                boolean rowstat=false; 
                for(int j=0;j<n;j++){
                    int t = sc.nextInt()-1;
                    if(i==j)
                        k+=t;
                    if(!colstat[j] && col[j][t]){
                        colstat[j]=true;
                        c++;
                    }
                    col[j][t]=true;

                    if(row[t]) rowstat=true;
                    row[t]=true;
                }
                if(rowstat) r++;
            }

            System.out.print("Case #"+count+": "+(k+n)+" "+r+" "+c+"\n");
        }
    }
}