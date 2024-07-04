import java.util.*;
import java.lang.*;
class Solution{
    public static void main(String args[]){
        Scanner s=new Scanner(System.in);
        int numMat=s.nextInt();
        for(int i=0;i<numMat;i++){
            int n=s.nextInt();
            int arr[][]=new int[n][n];
            for(int j=0;j<n;j++){
               /* String temp=s.next();
                String[] arrTemp = temp.split(" ",n);*/
                for(int k=0;k<n;k++){
                    arr[j][k]=s.nextInt();
                }
            }
            
            //check the trace:
            int trace=0;
            for(int l=0;l<n;l++){
                trace=trace+arr[l][l];
            }
            
            //Repeated rows:
            int rowCount=0, colCount=0;
            for(int l=0;l<n;l++){
                HashSet<Integer> hs=new HashSet<>();
                for(int k=0;k<n;k++){
                    if(hs.contains(arr[l][k])){
                        rowCount++;
                        break;
                    }
                    else{
                        hs.add(arr[l][k]);
                    }
                }
            }
            
            for(int l=0;l<n;l++){
                HashSet<Integer> hs=new HashSet<>();
                for(int k=0;k<n;k++){
                    if(hs.contains(arr[k][l])){
                        colCount++;
                        break;
                    }
                    else{
                        hs.add(arr[l][k]);
                    }
                }
            }
            
            System.out.println("Case #"+i+":"+trace+" "+rowCount+" "+colCount);
            
            
        }
    }
}
