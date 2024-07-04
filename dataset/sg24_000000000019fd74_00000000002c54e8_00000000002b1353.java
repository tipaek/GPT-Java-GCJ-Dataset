
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Solution {
    
    static BigInteger sum;
    static BigInteger newSum;
    static List<String> path;
    static List<List<BigInteger>> pascal;
    
    public static void main(String[] args) {
        Scanner in = new Scanner((Readable) new BufferedReader(new InputStreamReader(System.in)));
        int testCount = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        in.nextLine();
        pascal = new ArrayList<>();
        List<BigInteger> firstRow = new ArrayList<>();
        firstRow.add(BigInteger.ONE);
        pascal.add(firstRow);
        for(int rowNumber = 1 ; rowNumber <= 500 ; rowNumber++){
            List<BigInteger> row = new ArrayList<>();
            List<BigInteger> lastRow = pascal.get(rowNumber-1);
            for(int i = 0 ; i < rowNumber ; i++){
                if(i > 0 &&  i < rowNumber -1 ){
                    row.add(lastRow.get(i).add(lastRow.get(i-1)));
                }else{
                    row.add(BigInteger.ONE);
                }
                
            }
            
            pascal.add(row);
        }
        for(int testIndex = 0 ;testIndex < testCount ; testIndex++){
            sum = new BigInteger(in.nextLine());
            path = new ArrayList<>();
            newSum = BigInteger.ONE;
            path.add("1 1");
            int t = 0;
            while(!sum.equals(newSum)){
                checkForNewCoordinate();
                t++;
                if(t>6){
                    break;
                }
            }
            
            System.out.println("Case #"+(testIndex+1)+": ");
            for(String s: path){
                System.out.println(s);
            }
        }
        
        
        
        /*  
        for(int i =0 ; i<l.size();i++){
            System.out.println("Case #"+(i+1)+": "+l.get(i)[0]+" "+l.get(i)[1]);
        }*/
        
        
        
    }
    
    private static void checkForNewCoordinate() {
        String[] lastCoOrdinate =  path.get(path.size() -1).split(" ");
        int lastX = Integer.valueOf(lastCoOrdinate[0]) - 1;
        int lastY = Integer.valueOf(lastCoOrdinate[1]) -1 ;
        
        //  if(lastX > 0 && lastX < lastY){
      
        int   x = lastX;
        int  y = lastY +1;
        String cs =  (x+1)+" "+(y+1);
        
        if(!path.contains(cs)){
            try{
                if(sum.compareTo(newSum.add(pascal.get(x).get(y))) >= 0){
                    
                    path.add(cs);
                    newSum = newSum.add(pascal.get(x).get(y));
                    return;
                }
            }catch (Exception e) {
                // TODO: handle exception
            }
        }
         x = lastX+1;
         y = lastY;
         cs = (x+1)+" "+(y+1);
        
        if(!path.contains(cs)){
            try{
                if(sum.compareTo(newSum.add(pascal.get(x).get(y))) >= 0){
                    newSum = newSum.add(pascal.get(x).get(y));
                    path.add(cs);
                    return;
                }
            }catch (Exception e) {
                // TODO: handle exception
            }
        }
        
        x = lastX-1;
        y = lastY;
        cs =  (x+1)+" "+(y+1);
        
        if(!path.contains(cs)){
            try{
                if(sum.compareTo(newSum.add(pascal.get(x).get(y))) >= 0){
                    newSum = newSum.add(pascal.get(x).get(y));
                    path.add(cs);
                    return;
                }
            } catch (Exception e) {
                // TODO: handle exception
            }
        }
        
        x = lastX;
        y = lastY - 1;
        cs =  (x+1)+" "+(y+1);
        
        if(!path.contains(cs)){
            try{
                if(sum.compareTo(newSum.add(pascal.get(x).get(y))) >= 0){
                    
                    path.add(cs);
                    newSum = newSum.add(pascal.get(x).get(y));
                    return;
                }
            }catch (Exception e) {
                // TODO: handle exception
            }
        }
        
        //}
    }
    
    
    
    
    
    
    
}