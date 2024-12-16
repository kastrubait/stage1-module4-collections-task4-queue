package com.epam.collections.queue;

import java.util.*;

public class ArrayDequeCreator extends PriorityQueue<String> {
    public ArrayDeque<Integer> createArrayDeque(Queue<Integer> firstQueue, Queue<Integer> secondQueue) {

        ArrayDeque<Integer> deque = new ArrayDeque<>();

        deque.add(Objects.requireNonNull(firstQueue.poll()));
        deque.add(Objects.requireNonNull(firstQueue.poll()));
        deque.add(secondQueue.poll());
        deque.add(secondQueue.poll());

        while (!firstQueue.isEmpty() || !secondQueue.isEmpty()) {
            // Player 1's turn
            if (!firstQueue.isEmpty()) {
                firstQueue.offer(deque.pollLast());
                if (!firstQueue.isEmpty()) deque.add(firstQueue.poll());
                if (!firstQueue.isEmpty()) deque.add(firstQueue.poll());
            }

            // Player 2's turn
            if (!secondQueue.isEmpty()) {
                secondQueue.offer(deque.pollLast());
                if (!secondQueue.isEmpty()) deque.add(secondQueue.poll());
                if (!secondQueue.isEmpty()) deque.add(secondQueue.poll());
            }
        }

        return deque;
    }
}
