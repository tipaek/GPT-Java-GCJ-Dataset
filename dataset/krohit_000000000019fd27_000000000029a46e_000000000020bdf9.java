import java.util.*;
import java.util.Scanner;  // Impo

public class Solution {
    public static void main(String[] args) throws Exception {
        int n; int i; int t;
Scanner sc = new Scanner(System.in);
t = sc.nextInt();

for(int x = 0; x<t; x++){
    n = sc.nextInt();
int s[] = new int[n];   //start time array
int e[] = new int[n];   //end time array
HashMap<Integer, Integer> map = new HashMap();
for(i=0; i<n; i++){
    s[i] = sc.nextInt();
    e[i] = sc.nextInt();
map.put(s[i], e[i]);       //using a map to store start and end values as key-value pairs
    
}


char output[] = new char[n];   //output array
 boolean imposs = false; int j;
 
 //start traversing the map's keySet 
for(i=0; i<map.keySet().toArray().length; i++ ){  
  
      int key = (int) map.keySet().toArray()[i];  //getting key i.e. start time for current index
      
    if(i==0){  
        output[i] = 'C';        
    }

    else if(key >= (int)map.get(map.keySet().toArray()[i-1]) ){          //comparing current start time with previous end time
    char lastChar;
        lastChar = output[i-1];
         for(j=0;j<n;j++){
        
            if(output[j]==lastChar ){
               
              if(key < (int) map.get(map.keySet().toArray()[j])  &&  key>(int) map.keySet().toArray()[j]   ||  ((int) map.keySet().toArray()[j] > key    &&   (int) map.keySet().toArray()[j] < map.get(key) ) )
              {
             
                  imposs = true;
                  break;
              }
            }
        }
        
        
        if(imposs == false){
                output[i] = output[i-1];
        }
        else{
            break;
        }
    
    }
    else if(key < (int) map.get(map.keySet().toArray()[i-1])  ){
        char nextChar;
        if(output[i-1] == 'C')
        {
            nextChar = 'J';
        }
        else{
            nextChar = 'C';
        }
        
        for(j=0;j<n;j++){
        
            if(output[j]==nextChar ){

           
              if(key < (int) map.get(map.keySet().toArray()[j])  &&  key>(int) map.keySet().toArray()[j]   ||   ((int) map.keySet().toArray()[j] > key    &&   (int) map.keySet().toArray()[j] < map.get(key) )    )
              {
                 
                  imposs = true;
                  break;
              }
            }
        }
        
        if(imposs==false){
            output[i] = nextChar;
        }
        else{
            break;
        }
        
        
    }
       
}

if(imposs==true){
    System.out.println("IMPOSSIBLE");
}
else{
    System.out.println(output);
}

    
    
}


    }
}
