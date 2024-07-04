import java.util.*;
import java.io.*;
public class Solution
{
  public static void main(String args[]) {
    Scanner input = new Scanner(System.in);
    int t = input.nextInt();
    int b = input.nextInt();
    if(b == 10){
        StringBuffer arr = new StringBuffer(b);
        for (int i = 1; i <= t; i++) {
            for(int bi = 1; bi <= b; bi++){
                System.out.println(bi);
                int bit = input.nextInt();
                arr.append(bit);
            }
            System.out.println(arr.toString());
            String s = input.next();
            arr = new StringBuffer(b);
        }
    } else if(b == 20){
        StringBuffer arr = new StringBuffer(b);
        for (int i = 1; i <= t; i++) {
            Map<Integer, List<Integer>> pairs = new HashMap<>();
            Map<Integer, Integer> diffPair = new HashMap<>();
            for(int bi = 1; bi <= 5; bi++){
                System.out.println(bi);
                int bit = input.nextInt();
                System.out.println( 21-bi );
                int pairBit = input.nextInt();
                int equal = bit == pairBit ? 1 : 0;
                diffPair.put(equal, bi);
                pairs.put(bi,Arrays.asList(bit, pairBit));
            }// no change till here
            
            if(diffPair.size() == 2){
                List<Integer> currentValues = new ArrayList<>();
                currentValues.addAll(pairs.get(diffPair.get(0)));
                currentValues.addAll(pairs.get(diffPair.get(1)));
                List<Integer> changedValues = new ArrayList<>();
                for(int j = 0; j < 2; j++){
                    int bi = diffPair.get(j);
                    System.out.println(bi);
                    int bit = input.nextInt();
                    System.out.println( 21-bi );
                    int pairBit = input.nextInt();
                    changedValues.add(bit);
                    changedValues.add(pairBit);
                }
                int operation = identifyOperation(currentValues,changedValues);
                if(operation != 1){
                    changeList(pairs,operation);
                }
                for(int bi = 6; bi <= 8; bi++){
                System.out.println(bi);
                int bit = input.nextInt();
                System.out.println( 21-bi );
                int pairBit = input.nextInt();
                pairs.put(bi,Arrays.asList(bit, pairBit));
            }
            currentValues = new ArrayList<>();
                currentValues.addAll(pairs.get(diffPair.get(0)));
                currentValues.addAll(pairs.get(diffPair.get(1)));
                changedValues = new ArrayList<>();
                for(int j = 0; j < 2; j++){
                    int bi = diffPair.get(j);
                    System.out.println(bi);
                    int bit = input.nextInt();
                    System.out.println( 21-bi );
                    int pairBit = input.nextInt();
                    changedValues.add(bit);
                    changedValues.add(pairBit);
                }
                operation = identifyOperation(currentValues,changedValues);
                if(operation != 1){
                    changeList(pairs,operation);
                }
                for(int bi = 9; bi <= 10; bi++){
                System.out.println(bi);
                int bit = input.nextInt();
                System.out.println( 21-bi );
                int pairBit = input.nextInt();
                pairs.put(bi,Arrays.asList(bit, pairBit));
            }
            currentValues = new ArrayList<>();
                currentValues.addAll(pairs.get(diffPair.get(0)));
                currentValues.addAll(pairs.get(diffPair.get(1)));
                changedValues = new ArrayList<>();
                for(int j = 0; j < 2; j++){
                    int bi = diffPair.get(j);
                    System.out.println(bi);
                    int bit = input.nextInt();
                    System.out.println( 21-bi );
                    int pairBit = input.nextInt();
                    changedValues.add(bit);
                    changedValues.add(pairBit);
                }
                operation = identifyOperation(currentValues,changedValues);
                if(operation != 1){
                    changeList(pairs,operation);
                }
                for(int fi = 1; fi <= 10; fi++){
                    List<Integer> pair = pairs.get(fi);
                    arr.append(pair.get(0));
                    arr.append(pair.get(1));
                }
                System.out.println(arr.toString());
            String s = input.next();
            arr = new StringBuffer(b);
            } else {
                // no different pairs in first 5
                break;
            }
        }
    } else {
        return;
    }
  }
  
  private static int identifyOperation(List<Integer> currentValues, List<Integer> changedValues){
      if(currentValues.get(0) == changedValues.get(0)){
          if(currentValues.get(2) == changedValues.get(2)){
              return 1;
          } else {
              return 4;
          }
      } else {
          if(currentValues.get(2) == changedValues.get(2)){
              return 3;
          } else {
              return 2;
          }
      }
  }
  
  private static void changeList(Map<Integer, List<Integer>> pairs, int operation){
      if(operation == 2){
          for (Map.Entry<Integer, List<Integer>> entry : pairs.entrySet()) {
              List<Integer> pair = entry.getValue();
              for(int i = 0; i < 2; i++){
                  if(pair.get(i) == 0){
                      pair.set(i,1);
                  } else {
                      pair.set(i,0);
                  }
              }
              entry.setValue(pair);
          }
      }
      if(operation == 3){
          for (Map.Entry<Integer, List<Integer>> entry : pairs.entrySet()) {
              List<Integer> pair = entry.getValue();
              int temp = pair.get(0);
              pair.set(0, pair.get(1));
              pair.set(1, temp);
              entry.setValue(pair);
          }
      }
      if(operation == 4){
          for (Map.Entry<Integer, List<Integer>> entry : pairs.entrySet()) {
              List<Integer> pair = entry.getValue();
              for(int i = 0; i < 2; i++){
                  if(pair.get(i) == 0){
                      pair.set(i,1);
                  } else {
                      pair.set(i,0);
                  }
              }
              entry.setValue(pair);
          }
          for (Map.Entry<Integer, List<Integer>> entry : pairs.entrySet()) {
              List<Integer> pair = entry.getValue();
              int temp = pair.get(0);
              pair.set(0, pair.get(1));
              pair.set(1, temp);
              entry.setValue(pair);
          }
      }
  }
}