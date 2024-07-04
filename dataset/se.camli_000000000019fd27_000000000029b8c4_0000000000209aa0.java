import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

//     owner: sedatcamli
//     04.04.2020
public class Solution {
    public static void main(String[] args){
        Solution s = new Solution();
        s.start();
    }

    public void start(){
        Scanner scanIn = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int numberOfTestCases = scanIn.nextInt();
        for (int i = 1; i <= numberOfTestCases; i++) {
            int N = scanIn.nextInt();
            int K = scanIn.nextInt();
            int[][] matris =findASolution(N,K);
            if(matris[0][0] == 0){
                System.out.println("Case #"+i+": IMPOSSIBLE");
            } else{
                System.out.println("Case #"+i+": POSSIBLE");
                for(int j = 0; j<matris.length;j++){
                    StringBuilder sb = new StringBuilder();
                    for(int k = 0 ; k<matris[j].length; k++){
                        sb.append(matris[j][k]);
                        if(k!=matris[j].length-1){
                            sb.append(" ");
                        }
                    }
                    System.out.println(sb.toString());
                }
            }
        }
    }

    public int[][] findASolution(int N, int K){
        if(N%2 == 0){
            if(K%N ==0){
                return generateMatrisFromSpecificIndex(N,K);
            } else if(betweenMinMaxValues(N,K)){
                return generateEvenMatrisFromSpecificIndex(N,K);
            }
        } else{//odd tek
            if(K%N ==0 && K<=N*N){
                return generateMatrisFromSpecificIndex(N,K);
            } else if(K==(N*(N+1)/2)){
                return generateOddMatrisSequently(N);
            }
        }
        return new int[N][N];
    }

    public Set<Integer> findDigits(int N, int K){
        K = K/2;
        Random r = new Random();
        Integer sum = 0;
        Set<Integer> selected = new HashSet<>();
        do{
            selected = new HashSet<>();
            while(selected.size()!= N/2){
                Integer randInt = r.nextInt(N)+1;
                selected.add(randInt);
            }
            sum = 0;
            Iterator<Integer> iterator = selected.iterator();
            while(iterator.hasNext()){
                sum+=iterator.next();
            }
        } while(sum!=K);
        return selected;
    }


    public boolean betweenMinMaxValues(int N, int K){
        K = K/2;
        int min = 0;
        for(int i=0;i<N/2;i++){
            min+=(i+1);
        }
        int max = 0;
        for(int i=N;i>N/2;i--){
            max+=i;
        }
        return K>min && K<max;
    }

    public int[][] generateEvenMatrisFromSpecificIndex(int N, int K){
        Set<Integer> selecteds = findDigits(N,K);
        Set<Integer> unselected = new HashSet<>();
        for(int i = 1; i<=N; i++){
            if(!selecteds.contains(i)){
                unselected.add(i);
            }
        }
        CycleList startPoint = generateCycleListWithSet(selecteds,unselected);
        CycleList currentPoint = startPoint;
        int[][] matris = new int[N][N];
        for(int i=0;i<N;i++){
            for(int j = 0 ; j< N; j++){
                matris[i][j]=currentPoint.value;
                currentPoint = currentPoint.next;
            }
            currentPoint=currentPoint.next;
        }
        return matris;
    }

    public int[][] generateMatrisFromSpecificIndex(int N, int K){
        int startIndex = (K/N)-1;
        CycleList startPoint = generateCycleList(N);
        CycleList currentPoint = startPoint.getAt(startIndex);
        int[][] matris = new int[N][N];
        for(int i=0;i<N;i++){
            for(int j = 0 ; j< N; j++){
                matris[i][j]=currentPoint.value;
                if(j!=N-1){
                    currentPoint = currentPoint.next;
                }
            }
        }
        return matris;
    }

    public int[][]  generateOddMatrisSequently(int N){
        CycleList startPoint = generateCycleList(N);
        CycleList currentPoint = startPoint;
        int[][] matris = new int[N][N];
        for(int i=0;i<N;i++){
            for(int j = 0 ; j< N; j++){
                matris[i][j]=currentPoint.value;
                currentPoint = currentPoint.next;
            }
            currentPoint=currentPoint.next;
        }
        return matris;
    }

    public CycleList generateCycleListWithSet(Set<Integer> selected, Set<Integer> unselected){
        CycleList startPoint = null;
        CycleList currentPoint = null;
        Iterator<Integer> iSelected, iUnselected;
        iSelected = selected.iterator();
        iUnselected = unselected.iterator();
        for(int i=0;iSelected.hasNext() && iUnselected.hasNext();i++){
            CycleList cycle = new CycleList(i++,iSelected.next());
            CycleList cycle2 = new CycleList(i,iUnselected.next());
            cycle.next = cycle2;
            if(i==1){
                startPoint = cycle;
                currentPoint = cycle2;
            } else{
                currentPoint.setNext(cycle);
                currentPoint = cycle2;
            }
            if(!iSelected.hasNext() && !iUnselected.hasNext()){
                cycle2.setNext(startPoint);
            }
        }
        return startPoint;
    }

    public CycleList generateCycleList(int N){
        CycleList startPoint = null;
        CycleList currentPoint = null;
        for(int i=0;i<N;i++){
            CycleList cycle = new CycleList(i,i+1);
            if(i==0){
                    startPoint = cycle;
                currentPoint = cycle;
            } else{
                currentPoint.setNext(cycle);
                currentPoint = cycle;
            }
            if(i==N-1){
                cycle.setNext(startPoint);
            }
        }
        return startPoint;
    }

    class CycleList{
        int index;
        Integer value;
        CycleList next;

        CycleList(int index, Integer value){
            this.index = index;
            this.value = value;
        }

        void setNext(CycleList next){
            this.next = next;
        }

        CycleList getAt(int index){
            CycleList current = this;
            for(;;){
                if(current.index == index){
                return current;
            } else{
                current = current.next;
            }
            }
        }
    }
}