import java.util.*;
class Solution{
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        
        int T = scan.nextInt();
        
        int C = T;
        
        //cases 
        while(T-->0){
          String N = scan.next();
          
          List<Integer> NN = new ArrayList<Integer>();
          List<String> NN2 = new ArrayList<String>();
          
          
          
          for(int i=0; i<N.length()-1; i++){
              NN.add(Integer.parseInt(N.substring(i, i+1)));
          }
          NN.add(Integer.parseInt(N.substring(N.length()-1)));
          //NN2
          for(int i=0; i<N.length()-1; i++){
              NN2.add((N.substring(i, i+1)));
          }
          NN2.add((N.substring(N.length()-1)));
          
          
          //max 
          int max = 1;
          for(int i=0; i<NN.size(); i++){
              if(NN.get(i)>max){
                  max=NN.get(i);
              }
          }
          int left = 0; 
          int right = 0; 
          
          
          
          for(int j=1; j<=max; j++){
          
          
                      
                          if(Integer.parseInt(NN2.get(NN2.size()-1-right))>=j){
                               NN2.add(")");
                               right++;
                          }
                          
                         //System.out.println(NN2);
                         if( (Integer.parseInt(NN2.get(0+left))>=j) ){
                               NN2.add(0, "(");
                               left++;
                          }
                      
                      
                      for(int i=0; i<NN2.size()-1; i++){
                          
                          int mm = i+1;
                          if(mm<NN2.size()-1-right){
                              while(NN2.get(mm).equals("(") || NN2.get(mm).equals(")")) {
                                  mm++;
                                  //System.out.println("here");
                              }
                          }
                          
                          if(!NN2.get(i).equals("(") && !NN2.get(i).equals(")") && !NN2.get(mm).equals("(") && !NN2.get(mm).equals(")")){
                              
                              
                              
                              if((Integer.parseInt(NN2.get(i))<j && Integer.parseInt(NN2.get(mm))>=j)){
                                  NN2.add(i+1, "(");
                                  i++;
                              }else if(Integer.parseInt(NN2.get(mm))<j && Integer.parseInt(NN2.get(i))>=j){
                                  NN2.add(i+1, ")");
                                  i++;
                              }
                          }
                      }
                      
          
          }
          
          
          
          
          
          
            System.out.print("Case #"+(C-T)+": "); 
            for(int i=0; i<NN2.size(); i++){
                System.out.print(NN2.get(i));
            }
            System.out.println();
 
        }
        
        
    }
}