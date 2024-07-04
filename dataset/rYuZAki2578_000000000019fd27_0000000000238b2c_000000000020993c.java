import java.util.*;
class compu{
    public static void main(String []ar){
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        for(int a=1;a<=t;a++){
            int n=sc.nextInt();
            int [][]Mat=new int[n][n];
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++)
                    Mat[i][j]=sc.nextInt();
            }
            int k=0,r=0,c=0;
            for(int i=0;i<n;i++){
                k+=Mat[i][i];
                HashSet<Integer> col=new HashSet<>();
                HashSet<Integer> row=new HashSet<>();
                for(int j=0;j<n;j++){
                    col.add(Mat[j][i]);
                    row.add(Mat[i][j]);
                }
                if(col.size()!=n){
                    c++;
                }
                if(row.size()!=n)
                    r++;
            }
            System.out.println("Case #"+a+": "+k+" "+r+" "+c);
        }
    }
}