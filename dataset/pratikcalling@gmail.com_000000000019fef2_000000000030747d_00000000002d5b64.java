
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class Solution {

    List<Integer> sortedRanks = new LinkedList<>();
    
    public static void main(String[] args) {

        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int noOfCases = in.nextInt();

        for (int caseNo = 1; caseNo <= noOfCases; ++caseNo) {
            int R = in.nextInt();
            int S = in.nextInt();
            in.nextLine();

            Solution solution = new Solution();
            Status status = solution.calculate(R, S);

            System.out.println("Case #" + caseNo + ": "+status.shufflePatterns.toString().split("\\R").length+"\r\n"+status.shufflePatterns.toString());
        }
    }

    public Status calculate (int R, int S) {
        Queue<Status> queue = new LinkedList<>();
        List<String> deck = new LinkedList<>();

        for(int s=1;s<=S;s++) {
            for(int r=1;r<=R;r++) {
                deck.add(r+" "+s);
            }
        }

        for(int r=1;r<=R;r++) {
            for(int s=1;s<=S;s++) {
                sortedRanks.add(r);
            }
        }

        queue.add(new Status(deck, new StringBuilder()));

        while(!queue.isEmpty()) {
            List<Status> tempList = new LinkedList<>();

            while(!queue.isEmpty()) {
                Status status = queue.poll();
                for(int aIndex=1;aIndex<=R*S;aIndex++) {
                    for(int bIndex=aIndex+1;bIndex<=R*S;bIndex++) {
                        Status newStatus = shuffle(aIndex, bIndex-aIndex, new Status(status));
                        if(isSorted(newStatus.deck)) {
                            return newStatus;
                        }
                        tempList.add(newStatus);
                    }
                }
            }
            queue.addAll(tempList);
        }

        return null;
    }

    public Status shuffle (int aIndex, int bIndex, Status status) {

        List<String> deck = status.deck;
        StringBuilder shufflePatterns = status.shufflePatterns;
        List<String> newDeck = new LinkedList<>();

        List<String> deckA = deck.subList(0, aIndex);
        List<String> deckB = deck.subList(aIndex, aIndex+bIndex);
        List<String> deckC = deck.subList(aIndex+bIndex,deck.size());

        newDeck.addAll(deckB);
        newDeck.addAll(deckA);
        newDeck.addAll(deckC);

        return new Status(newDeck,shufflePatterns.append(String.valueOf(aIndex)+" "+String.valueOf(bIndex)+"\r\n"));
    }

    public boolean isSorted(List<String> deck) {
        return deck.stream()
                .map(card -> Integer.parseInt(card.split(" ")[0]))
                .collect(Collectors.toList())
        .equals(sortedRanks);
    }

    public class Status {
        List<String> deck;
        StringBuilder shufflePatterns;

        public Status(List<String> deck,StringBuilder shufflePatterns) {
            this.deck=deck;
            this.shufflePatterns=shufflePatterns;
        }

        public Status(Status status) {
            this.deck=new LinkedList<>(status.deck);
            this.shufflePatterns=new StringBuilder(status.shufflePatterns);
        }
    }
}