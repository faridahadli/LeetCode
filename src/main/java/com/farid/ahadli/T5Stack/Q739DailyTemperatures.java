package com.farid.ahadli.T5Stack;

import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Deque;

public class Q739DailyTemperatures {
    /*
    "waiting for something greater/smaller → monotonic stack, store only the index."
     */

    public int[] dailyTemperatures(int[] temperatures) {
        int[] answer = new int[temperatures.length];
        Deque<Integer[]> stack = new ArrayDeque<>();
        for (int i = 0; i < temperatures.length; i++) {
            while (!stack.isEmpty() && stack.peek()[0] < temperatures[i]) {
                Integer [] temperaturePositionArr = stack.pop();
                answer[temperaturePositionArr[1]] = i - temperaturePositionArr[1];
            }
            stack.push(new Integer[]{temperatures[i], i});
        }
        return answer;
    }

    // Cleaner version. Just stoning the idx is enough. We dont need
//    Deque<Integer> stack = new ArrayDeque<>();
//for (int i = 0; i < temperatures.length; i++) {
//        while (!stack.isEmpty() && temperatures[stack.peek()] < temperatures[i]) {
//            int idx = stack.pop();
//            answer[idx] = i - idx;
//        }
//        stack.push(i);
//    }

}

