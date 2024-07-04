import java.util.Scanner;

public class Solution {
	
    public static void main(String[] args) {
    
        Scanner sc= new Scanner(System.in);     
        
        int numTest = sc.nextInt();

        String input;
        int numRows;
        int matriz[][];
        		
        int solution[][]= new int[numTest][3];
        
        for(int test= 0; test< numTest ; ++test) {      
        	
        	numRows = sc.nextInt();
        	matriz = new int[numRows][numRows];

        	//Lectura datos
        	sc.nextLine();
        	for(int i=0; i<numRows;++i) {
        		     		
        		input=sc.nextLine();        		
        		String[] inputFormat = new String[numRows];
        		inputFormat=input.split(" ");
        		for(int j=0 ;j< numRows; ++j) {
        			matriz[i][j] = Integer.parseInt(inputFormat[j]);
        		}
        	}
        	
        	//solution[0]
        	solution[test][0]=0;
        	for(int i=0; i<numRows;++i) {
        		solution[test][0]+=matriz[i][i];
        	}
        	//solution[1]
        	solution[test][1]=0;
        	boolean bd =false;
        	for(int i=0;i<numRows;++i) {
        		bd=false;
        		for(int j=0;j<numRows && !bd;++j) {
        			int element=matriz[i][j];
        			if(j<(numRows-1) && !bd) {
        				for(int k=j+1;k<numRows;++k) {
        					int comprobasion= matriz[i][k];
        					if(element==comprobasion) {
        						bd=true;
        					}
        						
            			}
        			}
        			
        		}
        		if(bd) {
        			solution[test][1]++;
        		}
        	}
        	
        	//solution[2]
        	solution[test][2]=0;
        	boolean bd2 =false;
        	for(int i=0;i<numRows;++i) {
        		bd2=false;
        		for(int j=0;j<numRows;++j) {
        			int element=matriz[j][i];
        			if(j<(numRows-1) && !bd2) {
        				for(int k=j+1;k<numRows;++k) {
        					if(element==matriz[k][i]) {
        						bd2=true;
        					}
        						
            			}
        			}
        			
        		}
        		if(bd2) {
        			solution[test][2]++;
        		}
        	}
        	
       
        	
        	System.out.println("Case #"+(test+1)+": "+solution[test][0]+" "+solution[test][1]+" "+solution[test][2]);
       }//forTest
        
    }
}