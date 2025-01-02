public class App {
    public static void main(String[] args) throws Exception {
        int[] array = {4,2,1,7};
        System.out.println(maxProfit(array));
    }

    public static int maxProfit(int[] prices) {
        int leftPointer = 0;
        int rightPointer = 1;
        int maxProfit = 0;
        if(prices.length < 2) {
            return 0;
        }
        while(prices[rightPointer] < prices[leftPointer]) {
            leftPointer = rightPointer;
            rightPointer += 1;
        }
        while(rightPointer < prices.length) {
            int potentialProfit = prices[rightPointer] - prices[leftPointer];
            if(potentialProfit > maxProfit) maxProfit = potentialProfit;
            if(rightPointer + 1 < prices.length && prices[rightPointer + 1] < prices[leftPointer]) {
                leftPointer = rightPointer + 1;
                rightPointer = rightPointer + 2;
            }
            else  rightPointer += 1;
        }
        return maxProfit;
    }
}
