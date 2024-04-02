package org.example;

import java.util.*;

public class Main {

    public static List<List<Integer>> triplets(int[] num, int target) {
        List<List<Integer>> triplets = new ArrayList<>();
        Arrays.sort(num);

        for (int i = 0; i < num.length - 2; i++) {
            if (i == 0 || num[i] != num[i - 1]) {
                int left = i + 1, right = num.length - 1;
                int x = target - num[i];
                while (left < right) {
                    int y = num[left] + num[right];
                    if (y == x) {
                        triplets.add(Arrays.asList(num[i], num[left], num[right]));
                        while (left < right && num[left] == num[left + 1]) left++;
                        while (left < right && num[right] == num[right - 1]) right--;
                        left++;
                        right--;
                    } else if (y < x) {
                        left++;
                    } else {
                        right--;
                    }
                }
            }
        }
        return triplets;
    }



    public static void main(String[] args) {

        int[] nums = {1, 0, -1, 2, -1, 4};
        int target = 2;
        List<List<Integer>> result = triplets(nums, target);
        for (List<Integer> triplet : result) {
            System.out.println(triplet);
        }
    }
}



