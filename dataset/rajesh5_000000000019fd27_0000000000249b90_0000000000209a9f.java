
  
class GFG {
  
    static int maxDepth(String S) { 
        int current_max = 0;   
        int max = 0; 
        int n = S.length(); 
        for (int i = 0; i < n; i++) { 
            if (S.charAt(i) == '(') { 
                current_max++;
                if (current_max > max) { 
                    max = current_max; 
                } 
            } else if (S.charAt(i) == ')') { 
                if (current_max > 0) { 
                    current_max--; 
                } else { 
                    return -1; 
                } 
            } 
        } 
  
        
        if (current_max != 0) { 
            return -1; 
        } 
  
        return max; 
    } 
  
    public static void main(String[] args) { 
        String s = "( ((X)) (((Y))) )"; 
        System.out.println(maxDepth(s)); 
    } 
} 
