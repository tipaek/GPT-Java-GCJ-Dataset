import java.util.*;
public class Solution
{
	public static void main(String[] args) {

        
		Scanner in = new Scanner(System.in);  
        int testCases = in.nextInt();
        in.nextLine();
		for(int k=1;k<=testCases;k++){
    		
    		int bracesFlag=0;
            String name = in.nextLine(); 
            String finalStr = "";
            for(int i=0;i<name.length();i++){
                int numberStr = name.charAt(i);
            	int number = Character.getNumericValue(numberStr);
            	
            	if(bracesFlag==number){
            	    
            	    finalStr=finalStr+number;
            	    
            	}
            	if(bracesFlag<number){
                    String testBrace="";
                    while(number!=bracesFlag){
                        testBrace=testBrace+"(";
                        bracesFlag=bracesFlag+1;
                    }
                    finalStr = finalStr+testBrace+number;
                    bracesFlag = number;
                    
                }
                
                if(bracesFlag>number){
                    String testBrace="";
                    int numBrace = bracesFlag-number;
                    for(int m=0;m<numBrace;m++){
                        testBrace=testBrace+")";
                        bracesFlag=bracesFlag-1;
                    }
                    finalStr = finalStr+testBrace+number;
                    bracesFlag=number;
                }
                
                
            }
            if(bracesFlag>0){
                String testBrace="";
                while(bracesFlag!=0){
                    testBrace=testBrace+")";
                    bracesFlag--;
                }
                    finalStr = finalStr+name.charAt(name.length()-1)+testBrace;
            }
            System.out.println("Case #"+k+": "+finalStr);
		}
	}
}
