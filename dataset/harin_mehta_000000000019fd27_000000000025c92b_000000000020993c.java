import java.util.*;
class Solution{
    
    public static void main(String[] args){
    
        Scanner sc = new Scanner(System.in);
        
        int testCases = sc.nextInt();
        int x = 1;
        while(testCases>0){
            
            int size = sc.nextInt();
            
            int[][] arr = new int[size][size];
            
            int rowAns = 0, columnAns = 0 , k=0;
            
            for(int i =0; i<size; i++){
                
                Set<Integer> rowSet = new HashSet<>();
                boolean doesThisRowRepeat = false;
            
                for(int j = 0; j< size; j++){
                    
                    arr[i][j] = sc.nextInt();
                    
                    if(i==j) k+=arr[i][j];
                    
                    if(doesThisRowRepeat) continue;
                    
                    if(rowSet.contains(arr[i][j])){
                        
                        rowAns++;
                        doesThisRowRepeat = true;
                        
                    }
                    else rowSet.add(arr[i][j]);
                    
                }
                
            }
            
            // do it for columns
            
            for(int i = 0; i< size; i++){
                
                Set<Integer> columnSet = new HashSet<>();
                boolean doesThisColumnRepeat = false;
            
                for(int j = 0; j< size; j++){
                    
                    if(doesThisColumnRepeat) continue;
                    
                    if(columnSet.contains(arr[j][i])){
                        doesThisColumnRepeat = true;
                        columnAns++;
                    }
                    else columnSet.add(arr[j][i]);
                    
                }
                
            }
            
            System.out.println("Case #"+x+": "+k+" "+rowAns+" "+columnAns);
            x++;
            
            
            testCases--;
        }
        
        
    
    }
    
}