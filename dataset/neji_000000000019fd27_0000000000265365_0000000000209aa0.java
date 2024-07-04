
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.HashMap;

public class Solution {

    public static void main(String[] args) {
        InputStream is = System.in;
        try (Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(is)))) {
            int testCount = scanner.nextInt();

            for (int testNumber = 1; testNumber <= testCount; testNumber++) {
                int order = scanner.nextInt();
                int trace = scanner.nextInt();
                boolean isPossible = true;
                if (trace % order == 0 && trace / order <= order) {
                    System.out.println("Case #" + testNumber + ":" + "POSSIBLE");
                } else {
                    System.out.println("Case #" + testNumber + ":" + "IMPOSSIBLE");
                }

            }
        } catch (Exception e) {
        }
    }}

    

    

    
    
    
        
        
        
        
        
        
            
            
            
            
            
            
                
                
                        
                    
                    
                
            
            
                
                
            
                
                    
                    
                            
                        
                        
                    
                
                
                    
                    
                
                    
                    
                    
                

            
        
        
            
    
    
    
    
    
    
    
