import java.util.*;
public class codejam1
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int t= sc.nextInt();
        int p=0;
        while(t-- >0)
        {
            p++;
            int n= sc.nextInt();
            int a[][]=new int[n][n];
String wd="";int f=0;int sum=0,r=0,c=0;
            for(int i=0;i<n;i++)
            {f=0;
            wd="";
                for(int j=0;j<n;j++){
      a[i][j]= sc.nextInt();
if(wd.indexOf(a[i][j])!=-1 && f==0){
r++;
f=1;
}
if(i==j)
sum+=a[i][j];
wd+=a[i][j];
}
                  
             
            }
          
            for(int i=0;i<n;i++)
            {  wd=""; f=0;
                for(int j=0;j<n;j++)
                {
 System.out.println(wd.indexOf(a[j][i])+"# "+a[j][i]);
if(wd.indexOf((char)a[j][i])!=-1 && f==0){
System.out.println(a[j][i]);
c++;
f=1;
}
wd+=a[j][i];
System.out.println(wd+" $  "+a[j][i]+" @");

                }
            }
            System.out.println("Case #"+p+": "+""+sum+" "+r+" "+c);
        }
        
    }
}