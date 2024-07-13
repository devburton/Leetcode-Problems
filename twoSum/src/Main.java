import java.util.HashMap;

public class Main {
  public static void main(String[] args) {
    int[] test = { 3,4,5,6 };
    int[] returnValue = Solution.twoSum(test, 7);
    for (int value : returnValue) {
      System.out.println(value);
    }
  }
}

class Solution {
  public static int[] twoSum(int[] nums, int target) {
    int[] returnArray = new int[2];
    HashMap<Integer, Integer> map = new HashMap<>();
    for (int i = 0; i < nums.length; i++) {
      int complement = target - nums[i];
      if(map.containsKey(nums[i])) {
        returnArray[0] = map.get(nums[i]);
        returnArray[1] = i;
        return returnArray;
      }
      map.put(complement, i);
    }

    return returnArray;
  }
}