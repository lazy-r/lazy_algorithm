package leetcode.simple;

import java.util.Arrays;

public class Solution_122 {
    public int maxProfit(int[] prices) {
//        if (prices.length <= 1){
//            return 0;
//        }
        /**
         * 用于记录每天不同交易次数的两种状态的最大利润情况
         *          profit[第几天][是否持有股票]
         */
        int[][] profit = new int[prices.length][2];

        int noneStatus = 0;
        int ownStatus = 1;

        profit[0][noneStatus] = 0;
        profit[0][ownStatus] = buy(0, prices[0]);


        for (int day = 1; day < profit.length; day++) {
            /**
             * 当前未持有股票的情况
             *                  1、前一天未持有，今天观望
             *                  2、前一天持有，今天卖出
             */
            profit[day][noneStatus] = Math.max(
                                                    // 前一天未持有，今天观望
                                                    rest(profit[day - 1][noneStatus]),
                                                    // 前一天持有，今天卖出
                                                    sell(profit[day - 1][ownStatus], prices[day]));
            /**
             * 当前持有股票的情况
             *                  1、前一天未持有，今天买入
             *                  2、前一天持有，今天观望
             */
            profit[day][ownStatus] = Math.max(
                                                    // 前一天未持有，今天买入
                                                    buy(profit[day - 1][noneStatus], prices[day]),
                                                    // 前一天持有，今天观望
                                                    rest(profit[day - 1][ownStatus])
                                                );



        }





        // 初始化

        return Math.max(profit[profit.length - 1][0], profit[profit.length - 1][1]);


    }

    /**
     * 买入
     * @param fund 当前资金
     * @param price 股票价格
     * @return
     */
    private int buy(int fund, int price) {
        return  fund - price;
    }

    /**
     * 卖出
     * @param fund 当前资金
     * @param price 股票价格
     * @return
     */
    private int sell(int fund, int price) {
        return fund + price;
    }

    /**
     * 观望
     * @param fund 当前资金
     * @return
     */
    private int rest(int fund) {
        return fund;
    }

    public static void main(String[] args) {
        System.out.println(new Solution_122().maxProfit(new int[]{1}));
    }
}
