import java.util.*; 

 public class Solution  {
    
    
    public static void main(String args[]) {
        
        Scanner sc = new Scanner(System.in);
        
        int T = sc.nextInt();
        int t=1;
        while(t<=T) {
        	
            Integer s = sc.nextInt();
            int arr[][]  = new int[s][s];
            
            Set<Integer> set = new HashSet<>();
            int row=0;
            int col=0;
            sc.nextLine();
            for(int i=0;i<s;i++) {
        		String in[] = sc.nextLine().split(" ");
            	for(int j=0;j<s;j++) {
            		arr[i][j] = Integer.parseInt(in[j]);
                }
            }
                
            
           
            for(int i=0;i<s;i++) {
            	for(int j=0;j<s;j++) {	
                	if(set.contains(arr[i][j])) {
                		row++;
                		break;
                	} else {
                		set.add(arr[i][j]);
                	}
                }
            	set.clear();
            }
            
            for(int j=0;j<s;j++) {
            	for(int i=0;i<s;i++) {	
                	if(set.contains(arr[i][j])) {
                		col++;
                		break;
                	} else {
                		set.add(arr[i][j]);
                	}
                }
            	set.clear();
            }
            
            
            int trac =  0;
            
            
            int i=0,j=0;
            while(i<s) {
            	trac += arr[i][j];
            	i++;
            	j++;
            	
            }
            
           
            
            System.out.println("Case #"+t+": "+trac+" "+row+" "+col);
            
            t++;
            
        }
        
        sc.close();
        
        
        
    }
}