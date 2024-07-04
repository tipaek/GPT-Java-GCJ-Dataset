import java.util.*;
 class mainq {
    public static void main (String args[]){
        Scanner sc = new Scanner (System.in);
        int n = sc.nextInt();
        for (int i=0;i<n;i++){
            int mat= sc.nextInt();
            int arr[][]= new int [mat][mat];
            for (int ii=0;ii<mat;ii++){
                for (int j=0;j<mat;j++){
                    arr[ii][j]= sc.nextInt();
                   // System.out.print(arr[ii][j]+" ");
                }
                //System.out.println();
            }
           int row= checkrow(arr,mat);
           int col = checkcol(arr,mat);
           int sum = sumit(arr,mat);
           System.out.println("Case #"+(i+1)+": "+sum+" "+row+" "+col);
        }
    }
    
    static int checkrow(int arr[][],int n ){
        int rrow=0;
   
        for (int i=0;i<n;i++){
             Set<Integer>hs = new HashSet<>();
            for (int j=0;j<n;j++){
                hs.add(arr[i][j]);

            }
            if (hs.size()!=n){rrow++;}
         }
        return rrow;

    }
    static int sumit(int arr[][],int n ){
        int length=0;
   
        for (int i=0;i<n;i++){
          //  System.out.println(arr[i][i]);
            length= length+ arr[i][i];
      
         }
        return length;
        
    }
    static int checkcol(int arr[][],int n ){
        int rcol=0;
   
        for (int i=0;i<n;i++){
             Set<Integer>hs = new HashSet<>();
            for (int j=0;j<n;j++){
                hs.add(arr[j][i]);

            }
            if (hs.size()!=n){rcol++;}
         }
        return rcol;
        
    }
}