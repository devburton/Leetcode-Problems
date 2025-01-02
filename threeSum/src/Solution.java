import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Set;
import java.util.List;
import java.util.ArrayList;
import java.util.HashSet; 

class Solution {

    public static void main(String[] args) {
        int[] ints = {-1,0,1,2,-1,-4};
        System.out.println(threeSum(ints));

    }

    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> finalList = new ArrayList<List<Integer>>();
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();

        for(int i = 0; i < nums.length; i++) {
            if(map.containsKey(nums[i])) {
                map.get(nums[i]).add(i);
            } else {
                ArrayList<Integer> list = new ArrayList<Integer>();
                list.add(i);
                map.put(nums[i], list);
            }
        }
        /*for(Map.Entry<Integer, ArrayList<Integer>> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue().toString());
        }*/
        for(int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if(map.containsKey(-1 * (nums[i] + nums[j]))) {
                    ArrayList<Integer> matchingVals = map.get(-1 * (nums[i] + nums[j]));
                    for(Integer val : matchingVals) {
                        if (i == j || i == val || j == val) break;
                        ArrayList<Integer> addList = new ArrayList<>();
                        addList.add(nums[i]);
                        addList.add(nums[j]);
                        addList.add(nums[val]);
                        finalList.add(addList);    
                    }
                }
            }
        }
        // System.out.println("got here");
        for (List<Integer> list : finalList) {
            Collections.sort(list);
            // System.out.println(list.toString());
        }
        for(int i = 0; i < finalList.size(); i++) {
            for(int j = i + 1; j < finalList.size(); j++) {
                if (finalList.get(i).toString().equals(finalList.get(j).toString())) {
                    finalList.remove(j);
                    j--;
                }
            }
        }
        // System.out.println("got here as well");

        // for (List<Integer> list : finalList) {
        //     Collections.sort(list);
        //     System.out.println(list.toString());
        // }

        return finalList;
    }
}

    /*public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> returnList = new ArrayList<List<Integer>>();
        Arrays.sort(nums);
        outerloop: for(int i = 0; i < nums.length - 1; i++) {
            int n = nums[i];
            int start = i + 1;
            int end = nums.length - 1;
            boolean foundValue = false;
            while(!foundValue && !(start == end)) {
                if((nums[start] + nums[end]) == -n) {
                    List<Integer> list = new ArrayList<>();
                    list.add(n);
                    list.add(nums[start]);
                    list.add(nums[end]);
                    foundValue = true;
                    if(nums[i] <= nums[start] && nums[start] <= nums[end]) {
                        for(List<Integer> testList : returnList) {
                            if(nums[i] == testList.get(0) && nums[start] == testList.get(1) && nums[end] == testList.get(2)) continue outerloop;
                        }
                        returnList.add(list);
                    }
                }
                if(nums[start] + nums[end] > -n) end--;
                if(nums[start] + nums[end] < -n) start++;

            }
        }
        return returnList;
    }*/