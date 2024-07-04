import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {
    public static void main(String[] args){
        Scanner scan  = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        Integer caseNumber = scan.nextInt();

        for(int i = 0; i < caseNumber; i++){
            Integer row = scan.nextInt();
            Integer col = row;
            Integer sumTrace = 0;
            Map colMap = new HashMap();
            Integer numRowRepeated = 0;
            Integer colRepeatNum = 0;
            Map<Integer,Integer> numColRepeated = new HashMap();

            for(int j = 0; j < row; j++){
                boolean rowContainRepeated = false;
                Map rowMap = new HashMap();

                for(int k = 0; k < col; k++) {
                    Integer data = scan.nextInt();
                    if(j == k)
                        sumTrace += data;
                    if(rowMap.containsValue(data)){
                        rowContainRepeated = true;
                    }
                    if(colMap.get(k) != null && ((Map)colMap.get(k)).containsValue(data)){
                        Integer repeatCol = (Integer)numColRepeated.get(k);
                        numColRepeated.put(new Integer(k),++repeatCol);
                    }else{
                        numColRepeated.put(new Integer(k),new Integer(0));
                    }
                    if(colMap.get(k) == null) {
                        Map colData = new HashMap();
                        colData.put(j,data);
                        colMap.put(k,colData);
                    }
                    else{
                        Map colData = (Map)colMap.get(k);
                        colData.put(j,data);
                        colMap.put(k,colData);
                    }

                    rowMap.put(k,data);
                }

                if(rowContainRepeated)
                    ++numRowRepeated;
            }

            for (Map.Entry<Integer,Integer> entry : numColRepeated.entrySet()){
                Integer num = entry.getValue();
                if(num > 0)
                ++colRepeatNum;
            }
            System.out.println("Case #" + (i+1) + ": " + sumTrace + " " + numRowRepeated + " " +colRepeatNum);
        }
    }
}
