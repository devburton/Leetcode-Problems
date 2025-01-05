public class App {
    public static void main(String[] args) throws Exception {
        int[] array = {4,2,1,7};
        System.out.println(maxProfit(array));
    }

    public static int maxProfit(int[] prices) {
        int lowest = prices[0];
        int maxProfit = 0;
        for(int price : prices) {
            maxProfit = Math.max(maxProfit, price - lowest);
            lowest = Math.min(lowest, price);
        }
        return maxProfit;
    }
}