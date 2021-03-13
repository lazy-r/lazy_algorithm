package leetcode.simple;

import java.util.Arrays;
import java.util.Map;

/**
 * 买卖股票的最佳时机
 */
public class Solution_121 {
    public int maxProfit(int[] prices) {
        /**
         * 用于记录每天两种状态的最大利润情况
         *      profit[第几天][是否持有股票]
         */
        int[][] profit = new int[prices.length][2];

        // 不持有股票的状态
        int noneStatus = 0;
        // 持有股票的状态
        int ownStatus = 1;


        // 初始化 profit
        profit[0][noneStatus] = rest(0);
        profit[0][ownStatus] = buy(0, prices[0]);

        for (int day = 1; day < profit.length; day++) {
            /**
             * 若今天不持有股票，则因为
             *                      1、昨天没持有股票，今天观望
             *                      2、昨天持有股票，今天卖出
             * 最终取两种状态的最大值
             */
            profit[day][noneStatus] = Math.max(
                                                // 昨天没持有股票，今天观望
                                                rest(profit[day - 1][noneStatus]),
                                                // 昨天持有股票，今天卖出
                                                sell(profit[day - 1][ownStatus], prices[day]));
            /**
             * 若今天持有股票，则因为
             *                      1、昨天没持有股票，今天买入
             *                      2、昨天持有股票，今天观望
             * 最终取两种状态的最大值
             */
            profit[day][ownStatus] = Math.max(
                                                // 昨天没持有股票，今天买入
                                                buy(0, prices[day]),
                                                // 昨天持有股票，今天观望
                                                rest(profit[day - 1][ownStatus]));
        }



        // 最终最大利润，取最后一天的两种状态的最大值
        return Math.max(profit[profit.length - 1][noneStatus], profit[profit.length - 1][ownStatus]);
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

}
