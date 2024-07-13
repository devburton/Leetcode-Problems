import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;
import java.util.Arrays;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] arg) {
        int[] test = {1,1,1,2,2,3};
        System.out.println( Arrays.toString( Solution.topKFrequent( test, 2 ) ) );
    }
}
// second solution using priorityQueue

class Solution {
    public static int[] topKFrequent(int[] nums, int k) {
        int[] returnArray = new int[k];

        HashMap<Integer, Integer> formattedInput = new HashMap<>();
        for( int num : nums) {
            formattedInput.put(num, formattedInput.getOrDefault(num, 0) + 1);
        }

        PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>((a,b) -> a.getValue() - b.getValue());

        Iterator<Map.Entry<Integer, Integer>> iterator = formattedInput.entrySet().iterator();
        for(int i = 0; i < formattedInput.size(); i++) {
            pq.offer(iterator.next());
            if (pq.size() > k) {
                pq.poll();
            }
        }

        for(int i = 0; i < k; i++) {
            returnArray[i] = pq.poll().getKey();
        }
        return returnArray;
    }
}


/*
first solution sorting by entry set  
class Solution {
    public static int[] topKFrequent(int[] nums, int k) {
        int[] returnArray = new int[k];
        LinkedHashMap<Integer, Integer> formattedInput = new LinkedHashMap<>();
        for(int num : nums) {
            if (formattedInput.keySet().contains(num)) {
                formattedInput.put(num, formattedInput.get(num) + 1);
            } else {
                formattedInput.put(num, 1);
            }
        }

        List<Map.Entry<Integer, Integer>> entryList = new ArrayList<>(formattedInput.entrySet());

        Collections.sort(entryList, new Comparator<Map.Entry<Integer,Integer>>() {
            @Override
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                return o2.getValue().compareTo(o1.getValue());
            }
        });

        LinkedHashMap<Integer, Integer> result = new LinkedHashMap<>();
        for(Map.Entry<Integer, Integer> entry : entryList) {
            result.put(entry.getKey(), entry.getValue());
        }

        Iterator<Integer> iterator = result.keySet().iterator();
        for(int i = 0; i < k; i++) {
            if(iterator.hasNext()) {
                returnArray[i] = iterator.next();
            }
        }

        return returnArray;
    }
}
*/