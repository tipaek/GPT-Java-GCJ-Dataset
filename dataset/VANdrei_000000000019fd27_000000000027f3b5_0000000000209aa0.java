import java.util.*;

public class Solution {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Integer noOfCases = scanner.nextInt();

        for (Integer caz = 0; caz < noOfCases; caz++) {

            Integer n = scanner.nextInt();
            Integer sum = scanner.nextInt();
            String caseString = "Case #" + (caz + 1) + ": ";
            if(n%2==0){
                caseString+="IMPOSSIBLE";
                System.out.println(caseString);
                
            }else {
                Integer calculatedSum = n*(n+1)/2;
                if(calculatedSum!=sum){
                    caseString+="IMPOSSIBLE";
                    System.out.println(caseString);
                   
                }
                else {
                    Queue<Integer> queue= new LinkedList<>();

                    for(int i = 1;i<=n;i++){
                        queue.add(i);
                    }
                    caseString+="POSSIBLE";
                    System.out.println(caseString);
                    for(int i=0;i<n;i++){
                        String line="";
                        for(Integer in:queue){
                            line+=in.toString()+" ";
                        }
                        System.out.println(line);

                        Integer removed=queue.remove();
                        queue.add(removed);

                    }
                }
            }

        }

    }
}