
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.*;
import java.util.stream.Collectors;

public class Solution {

    public static void main (String[] args){

        Scanner input = new Scanner(System.in);
        int total = Integer.parseInt(input.nextLine());
        for (int cases =1; cases<=total; cases++){

            String[] inputs = input.nextLine().split(" ");
            int nPies = Integer.parseInt(inputs[0]);
            int totalDiners = Integer.parseInt(inputs[1]);

            List<Pie> pies = new ArrayList<>();
            String[] angles = input.nextLine().split(" ");
            for (int i=0; i<nPies; i++){
                pies.add(new Pie(Double.valueOf(angles[i])));
            }
            pies.sort(Comparator.naturalOrder());


            outputAnswer(cases, check(nPies, totalDiners, pies,0));
        }
    }

    public static int check (int noOfPies, int totalDiners, List<Pie> pies, int cut){


        int longerChain = 1;
        int max = 1;
        int index =0;
        for (int i =1; i<pies.size(); i++){
            DecimalFormat df = new DecimalFormat("#.#########");
            df.setRoundingMode(RoundingMode.CEILING);
            if (df.format(pies.get(i).value).compareTo(df.format(pies.get(i-1).value))==0){
                longerChain++;
               // System.out.println("Entered");

                if(longerChain > max){
                    max = longerChain;
                    index =i;
                }
            } else{

                longerChain=1;
            }
        }


        //System.out.println("Max "+max);
        //System.out.println("total "+totalDiners);
        //System.out.println(pies);
        if (max >= totalDiners)
            return cut;
        else {
            int position = checkIfMultiplesExist(pies, pies.get(index).value, index);
            if(position ==-1){
                if(index<pies.size()-1){
                    List<Pie> newPies = pies.get(index+1).subtractPie(pies.get(index).value);
                pies.remove(index+1);
                pies.add(index+1,newPies.get(0));
                pies.add(index+1,newPies.get(1));
                cut++;
                pies.sort(Comparator.naturalOrder());
                } else {
                    List<Pie> newPies = pies.get(index).dividePie(totalDiners);
                    pies.remove(index);
                    pies.add(index,newPies.get(0));
                    pies.add(index,newPies.get(1));
                    cut++;
                    pies.sort(Comparator.naturalOrder());
                }


            } else {
                List<Pie> newPies = pies.get(position).subtractPie(pies.get(index).value);
                pies.remove(position);
                pies.add(position,newPies.get(0));
                pies.add(position,newPies.get(1));
                cut++;
                pies.sort(Comparator.naturalOrder());
            }
            return check(noOfPies,totalDiners,pies, cut);
        }
    }

    public static int checkIfMultiplesExist(List<Pie> pies, double value , int after){
        int position =-1;
        for (int i=after+1; i<pies.size(); i++){
            if (pies.get(i).value % value==0){
                position = i;
                break;
            }

        }
        return position;
    }

    public static <T> void outputAnswer ( int cases, T answer){
        System.out.printf("Case #%d: %s\n", cases, answer);
    }

}

class Pie implements Comparable<Pie>{
    double value;

    public Pie(double v){
        this.value = v;
    }

    public double getValue() {
        return value;
    }

    public List<Pie> subtractPie(double by){
        List<Pie> pies = new ArrayList<>();
        double other = value-by;
        pies.add(new Pie(other));
        pies.add(new Pie(value-other));
        return pies;
    }

    public List<Pie> dividePie(double by){
        List<Pie> pies = new ArrayList<>();
        double other = value/by;
        pies.add(new Pie(other));
        pies.add(new Pie(value-other));
        return pies;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Pie)) return false;
        Pie pie = (Pie) o;
        return Double.compare(pie.value, value) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public String toString() {
        return "Pie{" +
                "value=" + value +
                '}';
    }

    @Override
    public int compareTo(Pie o) {
        return Double.compare(value, o.value);
    }
}
