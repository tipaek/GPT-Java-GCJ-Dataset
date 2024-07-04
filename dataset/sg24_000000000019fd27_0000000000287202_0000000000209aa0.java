
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class Solution {
    
    public static void main(String[] args) {
        Scanner in = new Scanner((Readable) new BufferedReader(new InputStreamReader(System.in)));
        int testCount = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        List<BigInteger[]> l = new ArrayList<>();
        
        for(int testIndex = 0 ;testIndex < testCount ; testIndex++){
            String answer = "";
            int rowCount = in.nextInt();
            int trace =  in.nextInt();
            answer = rowCount+"\t"+trace;
            List<List<Integer>> output = null;
            // System.out.println("Case #"+(testIndex+1)+": "+answer);
            List<Set<Integer>> table1 = new ArrayList<>();
            List<Set<Integer>> table2 = new ArrayList<>();
            int[] doubleIntArray =  new int[2*rowCount];
            List<Integer> doubleList = new ArrayList<>();
            boolean transpose = false;
            for(int i= 0; i< rowCount;i++){
                doubleIntArray[i] = i+1;
                doubleIntArray[rowCount+i] = i+1; 
            }
            List<List<Integer>> ddList = new ArrayList<>();
            for(int i = 0; i < rowCount;i++){
                List<Integer> iList = new ArrayList<>();
                for(int j = i ; j < (i+rowCount);j++ ){
                    iList.add(doubleIntArray[j]);
                }
                
                ddList.add( iList);
            }
            for(int i = 0; i < rowCount;i++){
                List<Integer> iList = new ArrayList<>();
                for(int j = i ; j < (i+rowCount);j++ ){
                    iList.add(doubleIntArray[j]);
                }
                
                ddList.add( iList);
            }
            for(int i = 0; i < rowCount ;i++ ){
                List<List<Integer>> matrix =     (ddList.subList(i, i+rowCount));
                int cTrace = 0;
                int tTrace = 0;
                for(int rI =0 ;rI<rowCount ;rI++){
                    cTrace = cTrace + matrix.get(rI).get(rI);
                    //  System.out.println(matrix.get(rI));
                    tTrace = tTrace+ matrix.get( i).get(rowCount-i-1);
                }
                if(trace == cTrace){
                    output = matrix;
                    break;
                }
                if(trace == tTrace){
                    output = matrix;
                    transpose= true;
                }
                // System.out.println("-------------------------");
            }
            
            for(int i = rowCount; i > rowCount ;i-- ){
                List<List<Integer>> matrix =     (ddList.subList(i, i+rowCount));
                int cTrace = 0;
                int tTrace = 0;
                for(int rI =0 ;rI<rowCount ;rI++){
                    cTrace = cTrace + matrix.get(rI).get(rI);
                    tTrace = tTrace+ matrix.get( i).get(rowCount-i-1);
                    // System.out.println(matrix.get(rI));
                }
                if(trace == cTrace){
                    output = matrix;
                    break;
                }
                if(trace == tTrace){
                    output = matrix;
                    transpose= true;
                }
                // System.out.println("-------------------------");
            }
            
            
            
            doubleIntArray =  new int[2*rowCount];
            doubleList = new ArrayList<>();
            for(int i= 0; i< rowCount;i++){
                doubleIntArray[i] = rowCount - i;
                doubleIntArray[rowCount+i] = rowCount - i; 
            }
            ddList = new ArrayList<>();
            for(int i = 0; i < rowCount;i++){
                List<Integer> iList = new ArrayList<>();
                for(int j = i ; j < (i+rowCount);j++ ){
                    iList.add(doubleIntArray[j]);
                }
                
                ddList.add( iList);
            }
            for(int i = 0; i < rowCount;i++){
                List<Integer> iList = new ArrayList<>();
                for(int j = i ; j < (i+rowCount);j++ ){
                    iList.add(doubleIntArray[j]);
                }
                
                ddList.add( iList);
            }
            for(int i = 0; i < rowCount ;i++ ){
                List<List<Integer>> matrix =     (ddList.subList(i, i+rowCount));
                int cTrace = 0;
                int tTrace = 0;
                for(int rI =0 ;rI<rowCount ;rI++){
                    cTrace = cTrace + matrix.get(rI).get(rI);
                    tTrace = tTrace+ matrix.get( i).get(rowCount-i-1);
                    //   System.out.println(matrix.get(rI));
                }
                if(trace == cTrace){
                    output = matrix;
                    break;
                }
                if(trace == tTrace){
                    output = matrix;
                    transpose= true;
                }
                //  System.out.println("-------------------------");
            } 
            for(int i = rowCount; i > rowCount ;i-- ){
                List<List<Integer>> matrix =     (ddList.subList(i, i+rowCount));
                int cTrace = 0;
                int tTrace = 0;
                for(int rI =0 ;rI<rowCount ;rI++){
                    cTrace = cTrace + matrix.get(rI).get(rI);
                    tTrace = tTrace+ matrix.get( i).get(rowCount-i-1);
                    //System.out.println(matrix.get(rI));
                }
                if(trace == cTrace){
                    output = matrix;
                    break;
                }
                if(trace == tTrace){
                    output = matrix;
                    transpose= true;
                }
                //   System.out.println("-------------------------");
            }
            
            
            
            
            
            if(output != null){
                System.out.println("Case #"+(testIndex+1)+": POSSIBLE");
                //System.out.println(transpose);
                if(!transpose){
                    for(List<Integer> row:output){
                        for(Integer cell : row){
                            System.out.print(cell);
                            System.out.print(" ");
                            
                        }
                        System.out.println();
                    }
                }else{
                    for(int i = 0 ;i<rowCount ;i++){
                        for(int j = rowCount-1 ;j >= 0 ;j--){
                            System.out.print(output.get(i).get(j));
                            System.out.print(" ");
                        } 
                        System.out.println();
                    }
                }
            }else{
                System.out.println("Case #"+(testIndex+1)+": IMPOSSIBLE");
            }
        }
        
        
        
        /*  
        for(int i =0 ; i<l.size();i++){
            System.out.println("Case #"+(i+1)+": "+l.get(i)[0]+" "+l.get(i)[1]);
        }*/
        
        
        
    }
    
    
    
}
