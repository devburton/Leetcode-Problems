import java.util.HashSet;
import java.util.Iterator;

public class App {
    public static void main(String[] args) throws Exception {
        int[] nums = { 4, 1, 2, 1, 2, 5, 5 };
        System.out.println(singleNumber(nums));
    }

    public static int singleNumber(int[] nums) {
        int total = 0;
        for (int n : nums) {
            total ^= n;
        }
        return total;
    }

    // public static int singleNumber(int[] nums) {
    // String contains = "";
    // int total = 0;
    // for(int n : nums) {
    // if(contains.contains("_" + n + "_")) {
    // total -= n;
    // } else {
    // contains += "_" + n + "_";
    // total += n;
    // }
    // }
    // return total;
    // }

    // public static int singleNumber(int[] nums) {
    // HashSet<Integer> set = new HashSet<>();
    // for(int n : nums) {
    // if(set.contains(n)) set.remove(n);
    // else set.add(n);
    // }
    // Iterator<Integer> iterator = set.iterator();
    // return iterator.next();
    // }
}