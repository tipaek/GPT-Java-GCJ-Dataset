import java.util.*;
 
import java.io.*;
 class CodeJam {
 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s=new Scanner(System.in);
int t=s.nextInt();
int p=1;
 while(p<=t){
int n=s.nextInt();
int[][] a=new int[n][n];
for(int i=0;i<n;i++){
for(int j=0;j<n;j++){
a[i][j]=s.nextInt();
}
}


int trace=0;int r=0,c=0;
for(int i=0;i<n;i++){
HashSet<Integer>h1 =new HashSet<>();
HashSet<Integer>h2 =new HashSet<>();
for(int j=0;j<n;j++){
h1.add(a[i][j]);
h2.add(a[j][i]);
if(i==j)
trace+=a[i][j];

}
if(h1.size()<n)
r++;
if(h2.size()<n)
c++;
}
System.out.println("Case #"+p+": "+trace+" "+r+" "+c);
  
 
 p++;
}
	    
	}
    
}