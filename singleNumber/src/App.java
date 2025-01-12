import java.util.HashSet;
import java.util.Iterator;

public class App {
    public static void main(String[] args) throws Exception {
        int[] nums = {4,1,2,1,2};
        System.out.println(singleNumber(nums));
    }

    public static int singleNumber(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for(int n : nums) {
            if(set.contains(n)) set.remove(n);
            else set.add(n);
        }
        Iterator<Integer> iterator = set.iterator();
        return iterator.next();
    }
}
