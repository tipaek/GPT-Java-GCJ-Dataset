import java.util.*;
class Solution
{
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		    int t=sc.nextInt();
            for(int k=1;k<=t;k++){
                int n=sc.nextInt();
                int trace=0,row=0,col=0,f=0;
                int[][] a=new int[n][n];
                
                
                for(int i=0;i<n;i++){
                    f=0;
                    ArrayList<Integer> al=new ArrayList<Integer>();
                    for(int j=0;j<n;j++){
                        a[i][j]=sc.nextInt();
                        if(i==j) trace+=a[i][j];
                        if(al.contains(a[i][j]) && f==0) {f=1; row++;}
                        else if(!al.contains(a[i][j]) && f==0) al.add(a[i][j]);
                    }
                }
                f=0;
                for(int i=0;i<n;i++){
                    f=0;
                    ArrayList<Integer> al2=new ArrayList<Integer>();
                    for(int j=0;j<n;j++){
                        if(al2.contains(a[j][i]) && f==0) {f=1; col++;}
                        else if(!al2.contains(a[j][i]) && f==0) al2.add(a[j][i]);
                    }
                }
                System.out.println("Case #"+k+": "+trace+" "+row+" "+col);
            }
	}
}

