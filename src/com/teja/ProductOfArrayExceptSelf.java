package com.teja;

/**
 * Created by MohanN on 5/2/2020
 *
 * This problem was recently asked by Amazon:
 *
 * You are given an array of integers. Return an array of the same size where the element at each index is the product of all the elements in the original array except for the element at that index.
 *
 * For example, an input of [1, 2, 3, 4, 5] should return [120, 60, 40, 30, 24].
 *
 * You cannot use division in this problem.
 *
 */

/*
public class ProductOfArrayExceptSelf {

    public static void main(String[] arg) {
        double[] given = {1, 2, 3, 4, 5};
        double[] result = new double[given.length];

        double maxRes = 1;

        for(double value : given) {
            maxRes *= value;
        }

        System.out.println("Result Array is ");
        for(int i=0; i<given.length; i++) {
            double res = divide(Math.abs(maxRes),Math.abs(given[i]));
            result[i] = getExactResult(maxRes,given[i],res);
            System.out.print(Math.round(result[i]) + ", ");
        }
    }

    private static double getExactResult(double num, double den, double res) {
        if( (num>0 && den <0) || (num<0 && den>0) )
            return res*-1;
        else
            return res;
    }

    private static double divide(double dividend, double divisor) {
        double quo = 1;
        while(dividend - divisor > 0) {
            dividend = dividend - divisor;
            quo++;
        }
        return quo;
    }

}
*/

public class ProductOfArrayExceptSelf {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4};
        int[] result = new ProductOfArrayExceptSelf().productExceptSelf(nums);
        for (int r : result) System.out.print(r + " ");
    }

    public int[] productExceptSelf(int[] nums) {
        int[] result = new int[nums.length];
        for (int i = 0, temp = 1, l = nums.length; i < l; i++) {
            result[i] = temp;
            temp *= nums[i];
        }
        for (int i = nums.length - 1, temp = 1; i >= 0; i--) {
            result[i] = result[i] * temp;
            temp *= nums[i];
        }
        return result;
    }
}