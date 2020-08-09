package com.teja;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by MohanN on 5/2/2020
 * This problem was recently asked by Amazon:
 *
 * Given two arrays, write a function to compute their intersection - the intersection means the numbers that are in both arrays.
 *
 * Example 1:
 *
 * Input: nums1 = [1,2,2,1], nums2 = [2,2]
 * Output: [2]
 *
 * Example 2:
 *
 * Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * Output: [9,4]
 *
 * Note:
 * Each element in the result must be unique.
 * The result can be in any order.
 *
 */

public class IntersectionOfArrays {

    public static void main(String []arg) {
        int[] b = {1,5,4};
        int[] a = {2,2,3};

        System.out.println("Intersection of two arrays is " + intersection(a,b));
    }

    private static String intersection(int[] a, int[] b) {
        if(a.length >= b.length) {
            return findIntersection(a,b);
        } else
            return findIntersection(b,a);
    }

    private static String findIntersection(int[] big, int[] small) {
        List<Integer> result = new ArrayList<>();
        HashMap<Integer, List<Integer>> hash = new HashMap<>();

        for (int value : big) {
            int index = value % big.length;
            if(hash.get(index) == null || hash.get(index).isEmpty()) {
                List<Integer> data = new LinkedList<>();
                data.add(value);
                hash.put(index, data);
            } else {
                List<Integer> data = hash.get(index);
                data.add(value);
                hash.put(index, data);
            }
        }

        for(int value : small) {
            int index = value % big.length;
            if(hash.get(index) != null && hash.get(index).contains(value) && !result.contains(value))
                result.add(value);
        }

        return result.toString();
    }
}
