import java.util.Scanner;
import java.lang.String;
class Mine{


public static void main(String[] args){

Mine my=new Mine(); 
Scanner scan=new Scanner(System.in);
int T=scan.nextInt();

for(int k=1;k<=T;k++)
{
int N=scan.nextInt();
int sum=0;
int[][] matrix=new int[N][N];
for(int i=0;i<N;i++){
  for(int j=0;j<N;j++){
matrix[i][j]=scan.nextInt();
}
}
for(int l=0;l<N;l++){
  for(int m=0;m<N;m++){
if(l==m){
sum=sum+matrix[l][m];
}
}
}
System.out.println("Case #"+k+": "+sum+"0 0");


}

}

}