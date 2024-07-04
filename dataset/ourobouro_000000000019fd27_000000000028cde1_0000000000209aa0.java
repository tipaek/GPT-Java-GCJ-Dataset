
import java.util.*;
import java.io.*;
import java.lang.*;

public class Solution {
    
    static class BruteForceMatrix{
        
        int n;
        ArrayList<ArrayList<Integer>> generatedAnswer;
        
        BruteForceMatrix(ArrayList<ArrayList<Integer>> input){
            n = input.size();
            generatedAnswer = new ArrayList<ArrayList<Integer>>();
        }
        
        boolean isPossible(int x, int y, int val,ArrayList<ArrayList<Integer>> currentSet){
            
            for(int i=0;i<n;i++){
                if(i!= x && currentSet.get(i).get(y) == val ){
                    return false;
                }
            }
            
            for(int j=0;j<n;j++){
                if(j!= y && currentSet.get(x).get(j) == val ){
                    return false;
                }
            }
            
            return true;
        }
        
        boolean isValid(ArrayList<ArrayList<Integer>> currentSet){
        	
        	for(int i=0;i<n;i++){
        		for(int j=0;j<n;j++){
        			
        			if(currentSet.get(i).get(j).intValue() == 0){
        				return false;
        			}
        		}
        	}
        	
        	
        	return true;
        }
        
        void generatePossibleAnswer(ArrayList<ArrayList<Integer>> currentSet, int filledCount){
            
            if(generatedAnswer.size() == 0){
                
                if(isValid(currentSet)){
                    
                    for(int i=0;i<n;i++){
                    	
                    	 ArrayList<Integer> lst = new ArrayList<Integer>();
                        
                        for(int j=0;j<n;j++){
                            int val = currentSet.get(i).get(j);
                            //generatedAnswer.get(i).set(j,val);
                            
                            lst.add(val);
                        }
                        
                        generatedAnswer.add(lst);
                    }
                }
                else{
                    
                    int x = -1;
                    int y = -1;
                    
                    for(int i=0;i<n;i++){
                        for(int j=0;j<n;j++){
                            if(currentSet.get(i).get(j) == 0){
                                x = i;
                                y = j;
                                break;
                            }
                        }
                    }
                    
                    if(x > -1){
                        
                        for(int i = 1;i<=n;i++){
                            
                            if(isPossible(x,y,i,currentSet)){
                                
                                currentSet.get(x).set(y,i);
                                filledCount++;
                                
                                generatePossibleAnswer(new ArrayList<ArrayList<Integer>>(currentSet),filledCount);
                                
                                currentSet.get(x).set(y,0);
                            }
                        }
                    }
                    
                }
            }
        }
    }
    
    static class GenerateCombinations{
        int length;
        ArrayList<Integer> list;
        int sum;
        ArrayList<ArrayList<Integer>> geenratedCombinations;
        
        GenerateCombinations(ArrayList<Integer> list,int sum){
            this.sum = sum;
            this.list = new ArrayList<Integer>(list);
            this.length = list.size();
            geenratedCombinations = new ArrayList<ArrayList<Integer>>();
        }
        
        void generateSets(int index, ArrayList<Integer> currentSet, int currentSum){
            
            if(index < length && currentSum < sum && (currentSet.size() < length)){
                
                int indexVal = list.get(index);
                        
                int oriCurr = currentSum;
                ArrayList<Integer> oriSet = new ArrayList<Integer>(currentSet);
        
                currentSet.add(indexVal);
                currentSum += indexVal;
                
                if(currentSum == sum && currentSet.size() == length){
                    
                    if(!geenratedCombinations.contains(currentSet)){
                        geenratedCombinations.add(new ArrayList<Integer>(currentSet));
                    }
                }
                
                generateSets(index,new ArrayList<Integer>(currentSet),currentSum);
                generateSets(index+1,new ArrayList<Integer>(currentSet),currentSum);
                generateSets(index+1,oriSet,oriCurr);
            }
        }
    }
        
    static class FastReader{
        
        BufferedReader br;
        StringTokenizer st;
        
        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }
        
        String next() {
            
            while (st == null || !st.hasMoreElements())
            {
                try
                {
                    st = new StringTokenizer(br.readLine());
                }
                catch (IOException  e)
                {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }
        
        int nextInt() {
            return Integer.parseInt(next());
        }
        
        long nextLong()
        {
           return Long.parseLong(next());
        }
        
        double nextDouble()
        {
            return Double.parseDouble(next());
        }
         
       String nextLine()
       {
           String str = "";
           try
           {
               str = br.readLine();
           }
           catch (IOException e)
           {
               e.printStackTrace();
           }
           return str;
       }

    }

  public static void main(String[] args) {
   
    FastReader fastRead = new FastReader();
    PrintWriter out = new PrintWriter(System.out);
      
    int t = fastRead.nextInt();
    int caseNum = 0;
      
    while (t-- > 0) {
        
        int n = fastRead.nextInt();
        int k = fastRead.nextInt();
        
        caseNum++;
        
        ArrayList<Integer> list = new ArrayList<Integer>();
        
        for(int i=1;i<=n;i++){
            list.add(i);
        }
        
       GenerateCombinations combinationGenerator = new GenerateCombinations(list,k);
       
       ArrayList<Integer> currSet = new ArrayList<Integer>();
       combinationGenerator.generateSets(0,currSet,0);
    
        if(combinationGenerator.geenratedCombinations.size() > 0){
            
            boolean found = false;
            ArrayList<ArrayList<Integer>> answer = new ArrayList<ArrayList<Integer>>();
            
            for(int l=0;l<combinationGenerator.geenratedCombinations.size();l++){
                
                ArrayList<Integer> nums = combinationGenerator.geenratedCombinations.get(l);
                
                
                
                ArrayList<ArrayList<Integer>> set = new ArrayList<ArrayList<Integer>>();
                
                 for(int i=0;i<n;i++){
                    ArrayList<Integer> lst = new ArrayList<Integer>();
                    
                    for(int j=0;j<n;j++){
                        
                        if(i==j){
                           int val = nums.get(i);
                            lst.add(val);
                        }
                        else{
                            lst.add(0);
                        }
                    }
                    
                    set.add(lst);
                }
                
                BruteForceMatrix bfm = new BruteForceMatrix(set);
                
                bfm.generatePossibleAnswer(set,n);
                
                if(bfm.generatedAnswer.size() > 0){
                    answer = new ArrayList<ArrayList<Integer>>(bfm.generatedAnswer);
                    found = true;
                    break;
                }
            }
            
            if(found){
                 out.println("Case #"+caseNum+": POSSIBLE");
                
                for(int i=0;i<n;i++){
                    for(int j=0;j<n;j++){
                        out.print(answer.get(i).get(j)+" ");
                    }
                    out.println();
                }
            }
            else{
            	out.println("Case #"+caseNum+": IMPOSSIBLE");
            }
        
        }
        else{
            out.println("Case #"+caseNum+": IMPOSSIBLE");
        }
   
   }
      
    out.close();
  }
}
