/* 1052. Grumpy Bookstore Owner

Medium
Topics: Sliding Window
There is a bookstore owner that has a store open for n minutes. You are given an integer array customers of length n where customers[i] is the number of the customers that enter the store at the start of the ith minute and all those customers leave after the end of that minute.

During certain minutes, the bookstore owner is grumpy. You are given a binary array grumpy where grumpy[i] is 1 if the bookstore owner is grumpy during the ith minute, and is 0 otherwise.

When the bookstore owner is grumpy, the customers entering during that minute are not satisfied. Otherwise, they are satisfied.

The bookstore owner knows a secret technique to remain not grumpy for minutes consecutive minutes, but this technique can only be used once.

Return the maximum number of customers that can be satisfied throughout the day.



Example 1:

Input: customers = [1,0,1,2,1,1,7,5], grumpy = [0,1,0,1,0,1,0,1], minutes = 3

Output: 16

Explanation:

The bookstore owner keeps themselves not grumpy for the last 3 minutes.

The maximum number of customers that can be satisfied = 1 + 1 + 1 + 1 + 7 + 5 = 16.

Example 2:

Input: customers = [1], grumpy = [0], minutes = 1

Output: 1 */

public class Grumpy_Bookstore_Owner {
    public int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
        int sCust= 0;
        int count=0;
        if(customers.length== minutes) {
            for (int i = 0; i < customers.length; i++) {
                count += customers[i];
            }
            return count;
        }
        for(int i=0; i<customers.length; i++){
            if(grumpy[i]== 0){
                sCust+=customers[i];
            }
        }
        int last= minutes;
        int maxCount= 0;

        for(int i=0; i<last; i++){
            if(grumpy[i]==1){
                maxCount+=customers[i];
            }
        }
        count=maxCount;
        for(int i=last; i<customers.length; i++){
            if(grumpy[i-last]==1) maxCount-=customers[i- last];
            if(grumpy[i]==1) maxCount+=customers[i];
            count= Math.max(maxCount,count);
        }
        count+=sCust;
        return count;
    }
}
