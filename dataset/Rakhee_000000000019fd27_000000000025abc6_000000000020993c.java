class Solution{
      static void Vestigium(int x,int k,int r,int c){
          
        // A variable to control the  
        // rotation point. 
        int matchRows=0,matchCols=0,sum=0;
      int[][] arr=new int[r][c];
        // Loop to print rows 
            for(int i=0;i<c;i++){
              int j=i+1;
              while(j<c){
              if(arr[i][j-1]==arr[i][j]){
                    matchCols=matchCols+1;
                 }
                  if(i==j-1){
                     sum=sum+arr[i][j-1];
                 }
                j=j++;
              }
                
            }
            
            for(int j=0;j<r;j++){
                int i=j+1;
                while(i<r){
                    if(arr[j][i]==arr[j][i-1]){
                        matchRows=matchRows+1;
                    }
                   i++;

                }
            }
            
        System.out.print("Case#"+x+": "+sum+" "+matchRows+" "+matchCols);
        } 

}

