import java.util.*;
class Solution{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int t=Integer.parseInt(sc.nextLine()),t1=1;
        while(t-->0){
            String[] str=sc.nextLine().split(" ");
            System.out.print("Case #"+(t1++)+": ");
            int x=Integer.parseInt(str[0]),y=Integer.parseInt(str[1]);
            String s=str[2];
            int[][] a=new int[s.length()+1][4];
            a[0][0]=x;
            a[0][1]=y;
            a[0][2]=x+y;
            a[0][3]=0;
            int n=s.length(),x0=x,y0=y,flag=0;
            if(a[0][2]==a[0][3] || Math.abs(a[0][2]-a[0][3])==1){
                    System.out.println(Math.max(a[0][2],a[0][3]));
                    flag=1;
            }
            if(flag==0){
                for(int k=0;k<n;k++){
                    char c=s.charAt(k);
                    if(c=='S')
                        y--;
                    else if(c=='N')
                        y++;
                    else if(c=='E')
                        x++;
                    else if(c=='W')
                        x--;
                    a[k+1][0]=x;
                    a[k+1][1]=y;
                    a[k+1][2]=Math.abs(x)+Math.abs(y);
                    a[k+1][3]=Math.abs(Math.abs(x)-Math.abs(x0))+Math.abs(Math.abs(y)-Math.abs(y0));
                    if(a[k+1][2]==a[k+1][3] || Math.abs(a[k+1][2]-a[k+1][3])==1){
                        System.out.println(Math.max(a[k+1][2],a[k+1][3]));
                        flag=1;
                        break;
                    }
                }
            }
            if(flag==0)
                System.out.println("IMPOSSIBLE");
            /*for(int i=0;i<a.length;i++)
                System.out.print(a[i][0]+","+a[i][1]+","+a[i][2]+","+a[i][3]+"  ");
            System.out.println();*/
        }
    }
}