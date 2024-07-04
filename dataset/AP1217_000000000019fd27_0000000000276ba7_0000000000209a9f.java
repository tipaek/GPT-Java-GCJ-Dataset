import java.util.Scanner;

public class Solution {


    public static void main(String[] args) {


        Scanner scanner = new Scanner(System.in);

        int numTestCases = 0;
        
        while (true)
        {
            numTestCases = scanner.nextInt();
            if (numTestCases >=1 && numTestCases <=100)
                break;
            else {
                System.out.println("Value must be between 1 and 100");
            }
        }
       

       //Scanner scanner1 = new Scanner(System.in);
        
        for (int eachinput=0; eachinput<numTestCases;eachinput++){
            String str = null;
            boolean bRun=true;
            do {
                str = scanner.next();
                
                for (int m=0;m<str.length();m++){
                    char achar = str.charAt(m);
                    if (achar !='0' && achar !='1'){
                        //System.out.println("Input should have 1 or 0: " + achar);
                        bRun=true;
                    }
                    else{
                        bRun=false;
                    }
                    
                }
            } while (bRun);

            char aChar[] = str.toCharArray();

           

          

            StringBuffer resultBuf = new StringBuffer();
    
            int ilen = str.length();
    
            boolean bOpenParam=false;
            boolean bCloseParam=false;
    
            for (int i=0; i<ilen; i++){
    
                if ( aChar[i] == '0') {
                    ///System.out.println(" Main Next character is zero");
                    //
                    if (bOpenParam && !bCloseParam){
                        //System.out.println(" Main: Add close param");
                        resultBuf.append(")");
                        bOpenParam=false;
                        bCloseParam=false;
                    }
                    resultBuf.append("0");
                    
    
                }
                else {
                    //if it is one check next character until we see another 0
                    //it must be one and check if this is the very first time
                    if (!bOpenParam){
                        resultBuf.append("(");
                       // System.out.println(" Main: Add open param");
                        bOpenParam=true;
    
                    }
                    resultBuf.append("1");
    
                    int j=i+1;
                    for (j=i+1; j<ilen;j++){
                        if (aChar[j] == '1'){
                            //System.out.println("Nested Next character is one");
                            resultBuf.append("1");
                            i=i+1; //skip this one
                            continue;
                        }
                        else { 
                           // System.out.println("Nested Next character is zero");
                            
                            //check to see if there 
                            if (bOpenParam && !bCloseParam){
                                resultBuf.append(")");
                                bOpenParam=false;
                                bCloseParam=false;
                            }
                            
                            break;
                        }
                    }
                    if (j==ilen){
                        if (bOpenParam && !bCloseParam){
                            resultBuf.append(")");
                            bOpenParam=false;
                            bCloseParam=false;
                        } 
                        break;
                    }
    
                }
    
            }
    
            System.out.println("Case #" + (eachinput+1) + ": " + resultBuf.toString());
    
        
        }
        scanner.close();
    
    }
}