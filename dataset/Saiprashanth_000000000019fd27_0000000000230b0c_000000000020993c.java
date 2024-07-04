import java.util.*;
class Main{
    public static void main(String[] args){
        Scanner s=new Scanner(System.in);
        int a=s.nextInt();
        for(int i=1;i<=a;i++){
            int b=s.nextInt();
            int[][] arr=new int[a][a];
            for(int j=0;j<b;j++){
                for(int k=0;k<a;k++){
                    arr[j][k]=s.nextInt();
                }
            }
            int sum=0,row=0,col=0;
             for(int x=0;x<b;x++){
                for(int y=0;y<a;y++){
                   if(x==y){
                      sum=sum+arr[x][y]; 
                   }
                }
            }
             for(int x=0;x<b;x++){
                for(int y=0;y<a;y++){
                   for(int z=1;z<a;z++){
                       if(arr[y+z][x]==arr[y][x]){
                           row++;
                           break;
                       }
                   }
                }
            }
            for(int x=0;x<b;x++){
                for(int y=0;y<a;y++){
                   for(int z=1;z<a;z++){
                       if(arr[y][x+z]==arr[y][x]){
                           col++;
                           break;
                       }
                   }
                }
            }
            System.out.println("Case"+"#"+i+":"+sum+" "+row+" "+col);
        }
    }
}