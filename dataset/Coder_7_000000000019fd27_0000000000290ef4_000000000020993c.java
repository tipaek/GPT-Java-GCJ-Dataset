import java.util.*;
class Essayas{
    public static void main(String[] args) {
    Scanner in=new Scanner(System.in);
    int cases=Integer.parseInt(in.nextLine());
    int count=1;
    for(int i=0; i<cases; i++){
        int size=Integer.parseInt(in.nextLine());
        int sum=0;
        int r=0;
        int c=0;
        int [][]colSum=new int[size][size];
        int []check=new int[size];
        int sC=0;
        for(int j=0; j<size; j++){
            int []rowSum=new int[size];
            String []array=in.nextLine().split(" ");
            boolean done=false;
            for(int k=0; k<size; k++){
                int value=Integer.parseInt(array[k]);
              
                rowSum[value-1]+=1;
                if(rowSum[value-1]>1 && !done){r++;done=true;}
                
                colSum[k][value-1]+=1;
                if(check[k]!=1 && colSum[k][value-1]>1){c++; check[k]=1;}
                if(k==j){
                    sum+=value;
                }
            }
            
        }
        
        System.out.println("Case #"+count+": "+sum+" "+r+" "+c);
        count++;
    }
    
  }
    
}