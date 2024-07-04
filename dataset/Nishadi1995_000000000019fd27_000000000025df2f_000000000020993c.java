import java.util.Scanner;


class MyClass {
    public static void main(String args[]) {
        
      Scanner s = new Scanner(System.in);
      int n = s.nextInt();

      for (int t = 1; t < n+1; t++) {
               
            int m = s.nextInt();
            int rows = m ;
            int columns = m ;
            int k = 0;
            int[][] array = new int[rows][columns];
            int a= 0;
            int b= 0;
            s.nextLine();

            for (int i = 0; i < rows; i++) {
                String str[]= s.nextLine().split(" ");
                
   	            for(int j = 0; j < columns; j++){
      	           array[i][j] = Integer.parseInt(str[j]);
     	        }
            }
            
            for(int i = 0; i < rows; i++){

                int[] rowvalues = new int[m];
                int[] columnvalues = new int[m];

    	        for(int j = 0; j < columns; j++){
                    if(i == j){
               	        k = k + (array[i][j]);
               	    }
               	    
               	    rowvalues [j] = array[i][j];
               	    columnvalues [j] = array[j][i];
                }
                
                outer:for (int c = 0; c < m; c++){ 
                    for (int d = c + 1; d < m; d++){ 
                        if (rowvalues[c] == rowvalues[d]) {
                            a+=1;
                            break outer;
                        }
                    }
                } 
                
                outer:for (int c = 0; c < m; c++){ 
                    for (int d = c + 1; d < m; d++){ 
                        if (columnvalues[c] == columnvalues[d]) {
                            b+=1;
                            break outer;
                        }
                    }
                } 
        
            }
        
            System.out.println("Case #"+t+":"+" "+k+" "+a+" "+b);
      }
    }
}