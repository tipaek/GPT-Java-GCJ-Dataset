import java.util.*;
import java.io.*;

public class Solution {

    public static void main(String[] args) {
        ppr();
    }

    public static void ppr() {
        Scanner scanner = new Scanner(new BufferedInputStream(System.in));
        int t = scanner.nextInt();

        ArrayList<String> outputs = new ArrayList<String>();

        for(int i = 0; i < t; i++) {
            String output ="";

            LinkedList<Entry> entries = new LinkedList<Entry>();
            HashMap<Integer, Entry> entriesTranslator = new HashMap<Integer, Entry>();
            LinkedList<Entry> cameronEntries = new LinkedList<Entry>();
            LinkedList<Entry> jamieEntries = new LinkedList<Entry>();

            int n = scanner.nextInt();

            for(int j = 0; j < n; j++) {
                int start = scanner.nextInt();
                int end = scanner.nextInt();

                Entry newEntry = new Entry(start, end);
                entries.add(newEntry);
                entriesTranslator.put(j, newEntry);
            }

            entries.sort(new EntryComparator());

            boolean lastGivenCameron = true;

            for(int j = 0; j < n; j++) {
                Entry actEntry = entries.get(j);
                int start = actEntry.getStart();
                int end = actEntry.getEnd();
                if(lastGivenCameron && (cameronEntries.isEmpty() || cameronEntries.getLast().getEnd() <= start)) {
                    actEntry.setPerson('C');
                    cameronEntries.add(actEntry);
                } else if(!lastGivenCameron && (jamieEntries.isEmpty() || jamieEntries.getLast().getEnd() <= start)) {
                    actEntry.setPerson('J');
                    jamieEntries.add(actEntry);
                } else if(lastGivenCameron && cameronEntries.getLast().getEnd() > start && (jamieEntries.isEmpty() || jamieEntries.getLast().getEnd() <= start)) {
                    lastGivenCameron = false;
                    jamieEntries.add(actEntry);
                    actEntry.setPerson('J');
                } else if(!lastGivenCameron && jamieEntries.getLast().getEnd() > start && (cameronEntries.isEmpty() || cameronEntries.getLast().getEnd() <= start)) {
                    lastGivenCameron = true;
                    cameronEntries.add(actEntry);
                    actEntry.setPerson('C');
                } else {
                    output = "IMPOSSIBLE";
                    break;
                }
            }

            if(output.isEmpty()) {
                for(int j = 0; j < n; j++) {
                    output += entriesTranslator.get(j).getPerson();
                }
            }



            outputs.add(output);
        }

        for(int i = 0; i < t; i++) {
            System.out.println("Case #" + (i + 1) + ": " + outputs.get(i));
        }
    }
}

class Entry {
    private int start;
    private int end;
    private char person;

    Entry(int start, int end) {
        this.start = start;
        this.end = end;
    }

    public int getStart() {
        return start;
    }

    public int getEnd() {
        return end;
    }

    public void setPerson(char p) {
        this.person = p;
    }

    public char getPerson() {
        return person;
    }
}

class EntryComparator implements Comparator<Entry> {

    @Override
    public int compare(Entry o1, Entry o2) {
        if(o1.getStart() == o2.getStart()) {
            if(o1.getEnd() == o2.getEnd()) {
                return 0;
            } else if(o1.getEnd() > o2.getEnd()) {
                return 1;
            } else {
                return -1;
            }
        } else if(o1.getStart() > o2.getStart()){
            return 1;
        } else {
            return -1;
        }
    }

}