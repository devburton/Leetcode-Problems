import java.util.HashSet;

public class Main {
    public static void main(String[] args) {
        int[] nums = {0,3,2,5,4,6,1,1};
        System.out.println(Solution.longestConsecutive(nums)); 
    }
}

class Solution {
    public static int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet<Integer>();
        int longestConsecutive = 0;
        for(int num : nums) {
            set.add(num);
        }
        for(int num : set) {
            int setLength = 1;
            if(!set.contains(num - 1)) {
                boolean finishedSet = false;
                int counter = 1;
                while(!finishedSet) {
                    if(set.contains(num + counter)) {
                        counter++;
                        setLength++;
                    } else {
                        finishedSet = true;
                    }

                }

            }
            longestConsecutive = Math.max(longestConsecutive, setLength);
        }
        return longestConsecutive;
    }
}