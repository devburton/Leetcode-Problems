import java.util.Arrays;
class Solution {

    public static void main(String[] args) {
        int[] nums = {1,2,4,6};
        System.out.println(Arrays.toString(productExceptSelf(nums)));
    }

    public static int[] productExceptSelf(int[] nums) {
        int product = 1;
        int zeroCounter = 0;
        for(int num : nums) {
            if(num != 0) product *= num;
            else zeroCounter++;
        }
        int[] returnArray = new int[nums.length];
        for(int i = 0; i < nums.length; i++) {
            if (zeroCounter >= 2 ) {
                return returnArray;
            } else if(zeroCounter == 1) {
                if(nums[i] == 0) {
                    returnArray[i] = product;
                    return returnArray;
                }
            } else {
                returnArray[i] = product / nums[i];
            }
        }
        return returnArray;
    }
}  
