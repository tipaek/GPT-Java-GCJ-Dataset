import java.util.*; 

class Solution { 
    public static void main(String[] args) 
    { 
        Scanner sc1 = new Scanner(System.in); 
        StringBuilder sb = new StringBuilder();
        
        for(int i=0;i<11;i++){
            System.out.println(i); 
            int response = sc1.nextInt(); 
            sb.append(String.valueOf(response));
        }
        
        System.out.println(sb.toString()); 
        return;  
        
    } 
} 
