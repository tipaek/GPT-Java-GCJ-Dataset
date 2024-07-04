
import java.util.Scanner;
class Solution {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        int t=in.nextInt();
        
      l:  for(int i=0;i<t;i++){
            int n=in.nextInt();
            int a[][]=new int[n][2],b[]=new int[n],C=-1,J=-1;
            for(int j=0;j<n;j++){
                for(int k=0;k<2;k++){
                    a[j][k]=in.nextInt();
                }
                b[j]=j+1;
            }
            char[] c=new char[n];
            
            for(int j=0;j<n-1;j++){
                for(int k=j+1;k<n;k++){
                    if(a[j][0]>a[k][0]){
                        int temp=a[j][0];
                        a[j][0]=a[k][0];
                        a[k][0]=temp;
                        temp=a[j][1];
                        a[j][1]=a[k][1];
                        a[k][1]=temp;
                        temp=b[j];
                        b[j]=b[k];
                        b[k]=temp;
                    }
                }
            }
            
              
            for(int k=0;k<n;k++){
                if(a[k][0]>=C){
                    c[k]='C';
                    C=a[k][1];
                }else if(a[k][0]>=J){
                    c[k]='J';
                    J=a[k][1];
                    
                }else{
                    System.out.println("Case #"+(i+1)+": IMPOSSIBLE");
                    continue l;
                }
            }
            for(int j=0;j<n-1;j++){
                for(int k=j+1;k<n;k++){
                    if(b[j]>b[k]){
                        int temp=b[j];
                        b[j]=b[k];
                        b[k]=temp;
                       char te= c[j];
                       c[j]=c[k];
                       c[k]=te;
                    }
                }
            }
            System.out.println("Case #"+(i+1)+": "+new String(c));

            
        }
    }
}
