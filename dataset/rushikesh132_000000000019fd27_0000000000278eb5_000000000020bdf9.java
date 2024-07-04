import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(reader.readLine());
        StringBuilder buffer=new StringBuilder();
        for(int i=1;i<=t;i++){
            int n=Integer.parseInt(reader.readLine());
            List<Integer> ca=IntStream.range(0,1441).boxed().collect(Collectors.toList());
            List<Integer> ja=IntStream.range(0,1441).boxed().collect(Collectors.toList());
            while(n-->0){
                int[] se= Arrays.stream(reader.readLine().trim().split(" ")).mapToInt(Integer::parseInt).toArray();
                if((ca.contains(se[0]))&&(ca.contains(se[1]))){
                    for(int j=se[0]-1;j<se[1];j++)
                        ca.remove(Integer.valueOf(String.valueOf(j)));
                    buffer.append("C");
                }else if((ja.contains(se[0]))&&(ja.contains(se[1]))){
                    for(int j=se[0]-1;j<se[1];j++)
                        ja.remove(Integer.valueOf(String.valueOf(j)));
                    buffer.append("J");
                }else{
                    buffer.setLength(0);
                    buffer.append("IMPOSSIBLE");
                    break;
                }
            }
            System.out.println("Case #"+i+": "+buffer.toString());
            buffer.setLength(0);
        }
    }
}
