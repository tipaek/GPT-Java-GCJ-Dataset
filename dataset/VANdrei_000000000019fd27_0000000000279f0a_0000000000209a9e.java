import java.util.*;

public class Solution {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String[] a =scanner.nextLine().split(" ");
        Integer noOfCases = Integer.parseInt(a[0]);
        Integer B = Integer.parseInt(a[1]);
        for (Integer caz = 0; caz < noOfCases; caz++) {


            //String caseString = "Case #" + (caz + 1) + ": ";
            //Integer noActivities = scanner.nextInt();
            ArrayList<Integer> sir= new ArrayList<>();
            for(int i=0;i<B;i++){
                sir.add(i%2);
            }
            for(int querry=0;querry<150;querry++){

                if(B==10){
                    for(int bit=1;bit<=B;bit++){
                        System.out.println(bit);
                        System.out.flush();
                        sir.set(bit-1,scanner.nextInt());
                    }
                    break;
                }
            }
            String guess="";
            for(Integer bit:sir){
                guess+=bit.toString();
            }
            System.out.println(guess);
            System.out.flush();
            byte answer=scanner.nextByte();
            assert (answer=='Y');
        }
        
    }
}