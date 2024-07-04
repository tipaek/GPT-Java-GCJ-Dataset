import java.util.*;
class Main{
    public static void main(String[] args){
        Scanner s=new Scanner(System.in);
        int a=s.nextInt();
        for(int i=1;i<=a;i++){
            int b=s.nextInt();
            int[][] arr=new int[b][b];
            for(int j=0;j<b;j++){
                for(int k=0;k<b;k++){
                    arr[j][k]=s.nextInt();
                }
            }
            int sum=0,row=0,col=0;
             for(int x=0;x<b;x++){
                for(int y=0;y<b;y++){
                   if(x==y){
                      sum=sum+arr[x][y]; 
                   }
                }
            }
             for(int x=0;x<b;x++){
                for(int y=0;y<b;y++){
                   int num=arr[x][y];
                   for(int z=y+1;z<arr.length;z++){
                       if(num==arr[x][z]){
                           row++;
                           break;
                       }
                   }
                }
            }
            for(int x=0;x<b;x++){
                for(int y=0;y<b;y++){
                   int num=arr[x][y];
                   for(int z=y+1;z<arr.length;z++){
                       if(num==arr[z][x]){
                           col++;
                           break;
                       }
                   }
                }
            }
            System.out.println("Case"+" "+"#"+i+":"+" "+sum+" "+row+" "+col);
        }
    }
}