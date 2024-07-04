import java.io.*;
class am
{
public static void main(String args[])throws IOException
{
InputStreamReader reader=new InputStreamReader(System.in);
BufferedReader input=new BufferedReader(reader);
int t,i,j,n,k=0,test,h,hi,r,c,row,column;
String s;
test=Integer.parseInt(input.readLine());
for(t=0;t<test;t++)
{
r=c=row=column=0;
n=Integer.parseInt(input.readLine());
int arr[][]=new int[n][n];
for(i=0;i<n;i++)
{
s=input.readLine();
String []st=s.split(" ");
for(j=0;j<n;j++)
{
arr[i][j]=Integer.parseInt(st[j]);
}
}

for(i=0;i<n;i++)
{
for(j=0;j<n;j++)
{
if(i==j)
{
k=k+arr[i][j];
}
}


}

for(i=0;i<n;i++)
{
    for(j=0;j<n;j++)
    {
        for(h=j+1;h<n;h++)
        {
            if(arr[i][j]==arr[i][h])
            {
                row=1;
                break;
            }
            
        }
        if(row==1)
        {
            r=r+1;
            row=0;
            break;
        }
    }
}

for(i=0;i<n;i++)
{
    for(j=0;j<n;j++)
    {
        for(h=j+1;h<n;h++)
        {
            if(arr[j][i]==arr[h][i])
            {
                column=1;
                break;
            }
            
        }
        if(column==1)
        {
            c=c+1;
            column=0;
            break;
        }
    }
}

System.out.println(k+" "+r+" "+c);
k=0;
}
}
}

