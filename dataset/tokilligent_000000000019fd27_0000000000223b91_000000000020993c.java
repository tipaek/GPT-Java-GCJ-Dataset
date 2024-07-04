import java.util.*;
public class Solution{
    public static void main(String[]args){
        Scanner sc=new Scanner(System.in);
        int k=sc.nextInt();
    for(int l=0;l<k;l++){
      int n=sc.nextInt();
      int [][]arr=new int [n][n];
      
      for(int i=0;i<n;i++){
        for(int j=0;j<n;j++){
          arr[i][j]=sc.nextInt();
        }
      }
      
      int dia=0;
      
      for(int i=0;i<n;i++){
        dia+=arr[i][i];
      }
      int row=0;
      
      for(int i=0;i<n;i++){
        LinkedList <Integer> num=new LinkedList <Integer>();
        num.add(arr[i][0]);
        boolean check=true;
        for(int j=1;j<n;j++){
          if(num.contains(arr[i][j])){
            check=false;
            row++;
            break;
          }
          else
            num.add(arr[i][j]);
        }
      }
      int col=0;
      
      for(int i=0;i<n;i++){
        LinkedList <Integer> num=new LinkedList <Integer>();
        num.add(arr[0][i]);
        boolean check=true;
        for(int j=1;j<n;j++){
          if(num.contains(arr[j][i])){
            check=false;
            col++;
            break;
          }
          else
            num.add(arr[j][i]);
        }
      }
      
      System.out.println("Case #"+(l+1)+": "+dia+" "+row+" "+col);     
    }
  }
}