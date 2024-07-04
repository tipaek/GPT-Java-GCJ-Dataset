import java.util.Scanner;
class Solution {
   
    public static void main(String args[]){
        Scanner kb=new Scanner(System.in);
        int t=kb.nextInt();
        x:  for(int i=0;i<t;i++){
            int n=kb.nextInt();
            int b[]=new int[n];
            int a[][]=new int[n][2];
            for(int j=0;j<n;j++){
                for(int k=0;k<2;k++){
                    a[j][k]=kb.nextInt();
                }
                b[j]=j+1;
            }
            
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
            char c[]=new char[n];
            int C=-1,J=-1;
            for(int k=0;k<n;k++){
            if(a[k][0]>=C){
                c[k]='C';
                C=a[k][1];
            }
            else if(a[k][0]>=J){
                 c[k]='J';
                J=a[k][1];
            }
            else{
                System.out.println("Case #"+(i+1)+": IMPOSSIBLE");
                continue x;
            }
                    
            }
            for(int j=0;j<n-1;j++){
                for(int k=j+1;k<n;k++ ){
                    if(b[j]>b[k]){
                        int temp=b[j];
                        b[j]=b[k];
                        b[k]=temp;
                        char ch=c[j];
                        c[j]=c[k];
                        c[k]=ch;
                    }
                }
            }
            String s=new String(c);
            System.out.println("Case #"+(i+1)+": "+s);
            
            
            
        }
    }
 }  








