public class App {
    public static void main(String[] args) throws Exception {
        int[] input = {3,4,5,6,1,2};
        System.out.println(findMin(input));
    }

    public static int findMin(int[] nums) {
        int l = 0, r = nums.length - 1;
        int m = (int) (0.5 * (l + r));
        if(nums[r] > nums[l]) return nums[l];
        while(l != r) {
            if(nums[m] >= nums[l]) {
                l = m;
                m = (int) (0.5 * (l + r));
            } else {
                r = m;
                m = (int) (0.5 * (l + r));
            }
            if(nums[r] > nums[l]) return nums[l];
            if(r - l == 1) return nums[r];
        }
        return nums[l];
    }
}
