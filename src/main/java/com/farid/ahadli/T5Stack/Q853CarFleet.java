package com.farid.ahadli.T5Stack;

import java.util.*;

public class Q853CarFleet {

    class PostionVelocity {
        double position;
        double speed;

        PostionVelocity(double position, double speed) {
            this.position = position;
            this.speed = speed;
        }

    }


    private LinkedList<PostionVelocity> fillPositionVelocityList(int[] position, int[] speed) {
        LinkedList<PostionVelocity> positionVelocities = new LinkedList<>();
        for (int i = 0; i < position.length; i++) {
            positionVelocities.add(new PostionVelocity(position[i], speed[i]));
        }
        positionVelocities.sort((a, b) -> (int) (b.position - a.position));
        return positionVelocities;
    }

    private double calculateMeetPoint(PostionVelocity a, PostionVelocity b) {
        double time = (a.position - b.position) / (b.speed - a.speed);
        return a.position + (a.speed * time);
    }

    public int carFleet(int target, int[] position, int[] speed) {
        Deque<PostionVelocity> positionVelocities = fillPositionVelocityList(position, speed);
        Deque<PostionVelocity> fleetStack = new LinkedList<>();
        int fleet = 0;
        while (!positionVelocities.isEmpty()) {
            fleetStack.push(positionVelocities.pop());
            if (fleetStack.size() == 2) {
                PostionVelocity firstOfFleet = fleetStack.pop();
                PostionVelocity secondOfFleet = fleetStack.pop();
                if(secondOfFleet.speed>=firstOfFleet.speed){
                    fleetStack.push(firstOfFleet);
                    fleet++;
                    continue;
                }
                double meetPoint = calculateMeetPoint(firstOfFleet, secondOfFleet);
                if (meetPoint > target) {
                    fleetStack.push(firstOfFleet);
                    fleet++;
                } else {
                    fleetStack.push(secondOfFleet);
                }
            }
        }
        return fleet + fleetStack.size();
    }

    public static void main(String[] args) {
        Q853CarFleet q = new Q853CarFleet();

        System.out.println(q.carFleet(13,new int []{10,2,5,7,4,6,11}, new int[]{7,5,10,5,9,4,1} ));
    }

    // best answer
//    public int carFleet(int target, int[] position, int[] speed) {
//        int n = position.length;
//        Integer[] indices = new Integer[n];
//        for (int i = 0; i < n; i++) indices[i] = i;
//
//        Arrays.sort(indices, (a, b) -> position[b] - position[a]);
//
//        Deque<Double> stack = new ArrayDeque<>();
//        for (int i : indices) {
//            double time = (double)(target - position[i]) / speed[i];
//            if (stack.isEmpty() || time > stack.peek()) {
//                stack.push(time);
//            }
//        }
//        return stack.size();
//    }
}
