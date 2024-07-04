import java.util.*;
class A{
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        for(int h=1;h<=t;h++)
        {
            int n=sc.nextInt();
            int arr[][]=new int[n][n];
            for(int i=0;i<n;i++)
                for(int j=0;j<n;j++)
                    arr[i][j]=sc.nextInt();
                    int row=0;
                    int col=0;
                    int diag=0;
                HashSet<Integer> c[]=new HashSet[n];
                for(int i=0;i<n;i++)
                    c[i]=new HashSet<Integer>();
            for(int i=0;i<n;i++)
            {
                HashSet<Integer>s=new HashSet<>();
                for(int j=0;j<n;j++)
                {
                    if(i==j)
                    diag+=arr[i][j];
                    s.add(arr[i][j]);
                    c[j].add(arr[i][j]);
                }
                if(s.size()!=n)
                row++;
            }
            for(int i=0;i<n;i++)
                if(c[i].size()!=n)
                col++;
            System.out.println("Case #"+h+": "+diag+" "+row+" "+col);
        }
    }
}