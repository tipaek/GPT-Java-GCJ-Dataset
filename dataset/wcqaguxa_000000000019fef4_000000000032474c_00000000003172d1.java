import java.util.*;

public class Solution {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int cases = scanner.nextInt();
        for (int i = 1; i <= cases; i++) {
            int n = scanner.nextInt();
            int dinners = scanner.nextInt();
            ArrayList<Slice> slices = new ArrayList<>();
            //add all slices to the arraylist so that you know
            for (int j = 0; j < n; j++) {
                long size = scanner.nextLong();
                Slice check = new Slice(size);
                int index = slices.indexOf(check);
                if (index>=0) {
                    slices.get(index).add();
                } else {
                    slices.add(check);
                }
            }

            int cuts = Solution.solve(slices, dinners);
            System.out.println("Case #"+1+": "+cuts);
        }
    }

    static int solve(ArrayList<Slice> slices, int dinners) {
        // check if there is exactly one size
        for (int j = 0; j < slices.size(); j++) {
            if (slices.get(j).amount >= dinners) {
                return 0;
            }
        }
        //check for each slicesize, how many other cuts you need to make to satisfy the customers with this size
        for (int i = 0; i < slices.size(); i++) {
            for (int j = i+1; j < slices.size(); j++) {
                slices.get(i).addSlice(slices.get(j));
            }
        }
        Collections.sort(slices, new CompareAmount());
        // for a bigger slice, see if
        if (dinners == 2) {
            for (int i = 0 ; i < slices.size(); i++) {
                Slice slice = slices.get(i);
                if (slice.size % 2 == 0) {
                    return 1;
                }
                if (slice.multiplicates.size()+slice.biggers.size() > 0) {
                    return 1;
                }
            }
            return 2;
        }
        if (dinners == 3) {
            //2 the same size
            for (int i = 0; i < slices.size(); i++) {
                Slice slice = slices.get(i);
                if (slice.amount == 2 && (slice.biggers.size() + slice.multiplicates.size()) > 0) {
                    return 1;
                }
            }
            // no the same size, but one multiplicate
            for (int i = 0; i < slices.size(); i++) {
                Slice slice = slices.get(i);
                if (slice.amount == 1 && slice.multiplicates.size() > 0) {
                    Slice check = new Slice(slice.size * 2);
                    if (slice.multiplicates.contains(check)) {
                        return 1;
                    }
                }
            }
            //no the same size, but 1 diivisible by 3, or 1 divisible by 2
            for (int i = 0; i < slices.size(); i++) {
                Slice slice = slices.get(i);
                if (slice.size % 3 == 0) {
                    return 2;
                }
                if (slice.size % 2 == 0  && (slice.biggers.size() + slice.multiplicates.size()) > 0) {
                    return 2;
                }
            }
        }
        return 3;
    }
}

class CompareAmount implements Comparator<Slice> {

    @Override
    public int compare(Slice o1, Slice o2) {
        int one = Integer.compare(o2.amount, o1.amount);
        if (one != 0) {
            return one;
        }
        return Long.compare(o1.size, o2.size);
    }
}

//keep track of Slices that are bigger and slices that are exactly multiplicands?
class Slice {
    long size;
    int amount;
    LinkedList<Slice> multiplicates;
    LinkedList<Slice> biggers;

    Slice(long size) {
        this.size = size;
        this.amount = 1;
        multiplicates = new LinkedList<>();
        biggers = new LinkedList<>();
    }

    void add() {
        amount++;
    }

    void addSlice(Slice other) {
        if (other.size > this.size) {
            if (other.size % this.size == 0) {
                this.multiplicates.add(other);
            } else {
                this.biggers.add(other);
            }
        } else {
            if (this.size % other.size == 0) {
                other.multiplicates.add(this);
            } else {
                other.biggers.add(this);
            }
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Slice slice = (Slice) o;
        return size == slice.size;
    }

    @Override
    public int hashCode() {
        return Objects.hash(size);
    }
}