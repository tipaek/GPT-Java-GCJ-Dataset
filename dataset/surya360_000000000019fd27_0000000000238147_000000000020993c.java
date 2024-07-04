import java.util.Scanner;
import java.util.HashMap; 
import java.util.Map; 
 class solution { 

	static int[][] matrix = null;
	static int flag = 0;
	static int D = 0;
	static int R = 0;
	static int C = 0;
	
    public static void main(String[] args) 
    { 
    	Scanner in = new Scanner(System.in);  

  			int n = in.nextInt();
         
			
        	int[] result = new int[3];
            for (int l=1;l<=n ;l++ ) {
            int size = in.nextInt();
            matrix = new int[size][size]; 
              int[] fin =  compute(size,in,result);
              System.out.println("Case #"+l+":"+ fin[0]+","+fin[1]+","+fin[2]);
            }
            in.close();
  			

  
    } 

    public static int[] compute(int n,Scanner in,int[] result){
    	
          for(int i=0;i<n;i++){
            HashMap<Integer, Integer> map = new HashMap<>(); 
        	for (int j=0;j<n ;j++ ) {
        		
        		if (flag==0) {
        		int val =  in.nextInt();
        		matrix[i][j] = val;
        		}
        		else if (flag==1) {
        			if (j<n) {
        			D+=matrix[i][j];
        			i++;
        			}
        		}
                else if (flag==2) {
                    if (map.containsKey(matrix[i][j])) {
                        int a = map.get(matrix[i][j]);
                        
                        map.replace(matrix[j][i], a , ++a);
                        
            

                    }
                    else {
                        map.put(matrix[i][j], 0);
            

                    }

                    


                    
                }
                 else  if (flag==3){
                    
                  if (map.containsKey(matrix[j][i])) {
                        int a = map.get(matrix[j][i]);
                          System.out.println(a+" val");
                       
                          
                        map.replace(matrix[j][i], a , ++a);

                    }
                else {
                     
                    
                        map.put(matrix[j][i], 0);
          

                    }

                     }
                        
        
                }

            if (flag==2) {
                int sum=0;
                for (int f : map.values()) {
                        sum += f;
                
                    }
                    R+=sum;
            }else if (flag==3) {
                    int sum=0;
                for (int f : map.values()) {
                        sum += f;
                 
                    }
                    C+=sum;
            }
 
        }
       
        
       
        if (flag<3) {
             flag++;
        	compute(n,in,result);
        }else {
         result[0]=D;
        result[1]=R;
        result[2]=C;
        	
        }
        
        return result;

    }
} 