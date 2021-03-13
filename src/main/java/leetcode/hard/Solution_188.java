package leetcode.hard;

public class Solution_188 {
    public int maxProfit(int k, int[] prices) {
        if (prices.length <= 1) {
            return 0;
        }
        /**
         * 用于记录每天不同交易次数的两种状态的最大利润情况
         *          profit[第几天][卖出次数][是否持有股票]
         */
        int[][][] profit = new int[prices.length][k + 1][2];

        // 不持有股票的状态
        int noneStatus = 0;
        // 持有股票的状态
        int ownStatus = 1;


        // 初始化
        for (int i = 0; i < profit.length; i++) {
            for (int j = 0; j < profit[i].length; j++) {
                profit[i][j][noneStatus] = Integer.MIN_VALUE;
                profit[i][j][ownStatus] = Integer.MIN_VALUE;
            }
        }
        profit[0][k][noneStatus] = 0;
        profit[0][k][ownStatus] = buy(0, prices[0]);

        for (int day = 1; day < profit.length; day++) {
            for (int time = k; time >= 0; time--) {
                /**
                 * 当天的 卖出次数 只能进行到前一天 拥有股票的 最小次数减一
                 */
                if (profit[day - 1][time + 1 <= k ? time + 1 : k][ownStatus] != Integer.MIN_VALUE) {
                    /**
                     * 当前未持有股票的情况
                     *                  1、前一天未持有，今天观望（前一天的卖出次数和今天一样）
                     *                  2、前一天持有，今天卖出（前一天的卖出次数比今天多一）
                     */
                    if (time < k) {
                        profit[day][time][noneStatus] = Math.max(
                                rest(profit[day - 1][time][noneStatus]),
                                sell(profit[day - 1][time + 1][ownStatus], prices[day])
                        );
                    } else {
                        profit[day][time][noneStatus] = rest(profit[day - 1][time][noneStatus]);
                    }


                    // 当前一天的 相同的卖出次数 解锁了，才可以进行今天的持有股票情况判断
                    if (profit[day - 1][time][ownStatus] != Integer.MIN_VALUE || profit[day - 1][time][noneStatus] != Integer.MIN_VALUE) {
                        /**
                         * 当前持有股票的情况
                         *                  1、前一天未持有，今天买入（前一天的卖出次数和今天一样）
                         *                  2、前一天持有，今天观望（前一天的卖出次数和今天一样）
                         */
                        profit[day][time][ownStatus] = Math.max(
                                buy(profit[day - 1][time][noneStatus], prices[day]),
                                rest(profit[day - 1][time][ownStatus])
                        );
                    }
                }

            }


        }

        int maxProfit = Integer.MIN_VALUE;
        for (int time = 0; time < profit[profit.length - 1].length; time++) {
            for (int status = 0; status < 2; status++) {
                maxProfit = maxProfit > profit[profit.length - 1][time][status] ? maxProfit : profit[profit.length - 1][time][status];
            }
        }


        return maxProfit;
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
