import java.io.*;
class Vest
{
    int rowDup(int arr[][])
    {
        int count=0;
        for(int i=0; i<arr.length; i++)
        {
            for(int j=0; j<arr.length-1; j++)
            {
                boolean flag=false;
                for(int k=j+1; k<arr.length; k++)
                {
                    if(arr[i][j]==arr[i][k])
                    {
                        count++; flag=true;
                        j=0;
                        break;
                    }
                }
                if(flag) break;
            }
        }
        return count;
    }
    int colDup(int arr[][])
    {
        int count=0;
        for(int i=0; i<arr.length; i++)
        {
            for(int j=0; j<arr.length-1; j++)
            {
                boolean flag=false;
                for(int k=j+1; k<arr.length; k++)
                {
                    if(arr[j][i]==arr[k][i])
                    {
                        count++;
                        flag=true;
                        break;
                    }
                }
                if(flag) break;
            }
        }
        return count;
    }
    public static void main()throws IOException
    {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int testNum=Integer.parseInt(br.readLine());
        Vest obj=new Vest();
        for(int i=0; i<testNum; i++)
        {
            int n=Integer.parseInt(br.readLine()),trace=0;
            int arr[][]=new int[n][n];
            for(int j=0; j<n; j++)
            {
                char num[]=br.readLine().toCharArray();
                int temp=0;
                for(int k=0; k<num.length; k++)
                {
                    if(num[k]==' ') { temp++; continue; }
                    arr[j][k-temp]=num[k]-48;
                    if(j==(k-temp)) trace+=arr[j][k-temp];
                }
            }
            int row=obj.rowDup(arr); int col=obj.colDup(arr);
            System.out.println("Case #"+(i+1)+": "+trace+" "+row+" "+col);
        }
    }
}