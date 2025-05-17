class Solution {
    public int maxSatisfaction(int[] satisfaction) {
        Arrays.sort(satisfaction);
        int n = satisfaction.length;
         int [][] dp = new int[n + 1][n + 1];
        //  for(int [] a : dp){
        //      Arrays.fill(a, -1);
        //  }

        //  return maxSatisfactionMemo(satisfaction, 0, 0, dp);
         return maxSatisfactionTab(satisfaction, 0, 0, dp);
        //  return maxSatisfactionRec(satisfaction, 0, 0);
    }


    // recursion
    private int maxSatisfactionRec(int[]satisfaction,int index,int time){
        if(index==satisfaction.length){
            return 0;
        }

        int includeDish = (satisfaction[index] * (time + 1)) + maxSatisfactionRec(satisfaction, index + 1, time + 1);
         int excludeDish = maxSatisfactionRec(satisfaction, index + 1, time);


        return Math.max(includeDish,excludeDish);
    }

    // tabualtion

    private int maxSatisfactionMemo(int[]satisfaction,int index,int time,int [][]dp){
        if(index==satisfaction.length){
            return 0;
        }

        if(dp[index][time]!=-1){
            return dp[index][time];
        }

        int includeDish = (satisfaction[index] * (time + 1)) + maxSatisfactionMemo(satisfaction, index + 1, time + 1,dp);
         int excludeDish = maxSatisfactionMemo(satisfaction, index + 1, time,dp);


        return dp[index][time]=Math.max(includeDish,excludeDish);
    }


    // tab
     private int maxSatisfactionTab(int [] satisfaction, int index, int time, int [][] dp){
         for(index = satisfaction.length; index >= 0; index--){
             for(time = index; time >=0; time--){
                 if(index == satisfaction.length)
                     continue;
            
                 int includeDish = (satisfaction[index] * (time + 1)) + dp[index + 1][time + 1];
                 int excludeDish = dp[index + 1][time];

                 dp[index][time] = Math.max(includeDish, excludeDish);
             }
         }
        
         return dp[0][0];
     }

}