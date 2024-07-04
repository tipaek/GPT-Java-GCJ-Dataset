import java.util.*;
class Vest
{
    public static void main()
    {
        Scanner sc=new Scanner(System.in);
        int numTest=sc.nextInt();
        for(int i=0; i<numTest; i++)
        {
            int trace=0; int row=0; int col=0;
            int n=sc.nextInt();
            int arr[][]=new int[n][n];
            for(int j=0; j<n; j++)
            {
                String numInp=sc.nextLine();
                String num[]=numInp.split(" ");
                for(int k=0; k<n; k++)
                {
                    arr[j][k]=Integer.parseInt(num[k]);
                    if(j==k) trace+=arr[j][k];
                }
            }
            for(int j=0; j<n; j++)
            {
                for(int k=0; k<n-1; k++)
                {
                    int comp=arr[j][k];
                    for(int l=k+1; l<n; l++)
                    {
                        if(comp==arr[j][l])
                        {
                            row++;
                            if(j!=n-1) j++;
                            k=0;
                            break;
                        }
                    }
                }
            }
            for(int j=0; j<n; j++)
            {
                for(int k=0; k<n-1; k++)
                {
                    int comp=arr[k][j];
                    for(int l=k+1; l<n; l++)
                    {
                        if(comp==arr[l][j])
                        {
                            col++;
                            if(k!=n-1) j++;
                            k=0;
                            break;
                        }
                    }
                }
            }
            System.out.println("Case #"+(i+1)+":"+trace+" "+row+" "+col);
        }
    }
}