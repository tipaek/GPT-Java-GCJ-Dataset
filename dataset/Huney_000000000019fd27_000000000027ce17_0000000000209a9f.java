public class GFG { 
  
   
    static int minParentheses(String p)  
    {  
        
   
        int bal = 0;  
        int ans = 0;  
        
        for (int i = 0; i < 100; ++i) {  
        
            bal += p.charAt(i) == '(' ? 1 : -1;  
        
  
            if (bal == -1) {  
                ans += 1;  
                bal += 1;  
            }  
        }  
        
        return bal + ans;  
    }  
      
    public static void main(String args[]) 
    { 
        String p = "())";  
          
   
        System.out.println(minParentheses(p));  
        
    } 
   
} 