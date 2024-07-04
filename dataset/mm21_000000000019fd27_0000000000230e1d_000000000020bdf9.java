import java.util.*;
class jav
{
public static boolean isbusy(int n[][] , int l[],int len) 
{
    int i;
    for(i = 0; i < len; i++)
    {
        if((l[0] >= n[i][0] && l[0] < n[i][1]) ||  (l[1] > n[i][0] && l[1] <= n[i][1]))
            return true;
    }
    return false;
}
public static void main(String args[])
{
    Scanner sc = new Scanner(System.in);
int k,i,m,n,c[][],j[][],l[],p = 0;
String sp;
m = sc.nextInt();
while(p < m)
{
    n = sc.nextInt();
    sp= "";
    l = new int[2];
    c = new int[n][2];
    j = new int[n][2];
    int cc = 0,jj = 0;
    for(i = 0;i < n;i++)
    {
        for(k=0;k<2;k++)
         l[k] =sc.nextInt();
        if(sp != "IMPOSSIBLE") {
            if(isbusy(j , l,jj)) {
                if(isbusy(c , l,cc)) {
                    sp = "IMPOSSIBLE";
                }
                else {
                    sp = sp + 'C';
		    for(int z=0;z<2;z++)
                    c[cc][z] = l[z];
			cc++;
                }
            }
            else {
                sp = sp + 'J' ;
		for(int z=0;z<2;z++)
                j[jj][z] = l[z];
		jj++;
            }
        }
    }
    System.out.println("Case #"+ p+1 +": "+sp);
    p++;
}
sc.close();
}
}