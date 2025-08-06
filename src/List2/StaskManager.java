package List2;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class StaskManager<E> {
    Stack<E> stacks = new Stack<>();
    Stack<E> stacksRedo = new Stack<>();
    Queue<E> queues = new LinkedList<>();

    // Hiển thị các collection
    public void showStacksRedo() {
        if (stacksRedo.isEmpty()) {
            System.out.println("Redo Stack rỗng!");
            return;
        }
        for (E element : stacksRedo) {
            System.out.println(element);
        }
    }

    public void showStacks() {
        if (stacks.isEmpty()) {
            System.out.println("Stack rỗng!");
            return;
        }
        for (E element : stacks) {
            System.out.println(element);
        }
    }

    public void showQueue() {
        if (queues.isEmpty()) {
            System.out.println("Queue rỗng!");
            return;
        }
        for (E element : queues) {
            System.out.println(element);
        }
    }

//Hướng dẫn: Tạo các method addToQueue(), peekQueue(), pollFromQueue(), isQueueEmpty()

    public void addToQueue(E element) {
        queues.offer(element);
    }

    public E peekQueue() {
        return queues.peek();
    }

    public E pollFromQueue() {
        return queues.poll();
    }

    public boolean isStackQueue() {
        return queues.isEmpty();
    }


    public void pushToStack(E element) {
        stacks.push(element);
    }

    public E peekStack() {
        return stacks.peek();
    }

    public E popFromStack() {
        if (!stacks.isEmpty()) {
            E task = stacks.peek();
            stacksRedo.push(task);
            return stacks.pop();
        }
        return null;
    }

    public boolean isQueueEmpty() {
        return queues.isEmpty();
    }

    public boolean isStackEmpty() {
        return stacks.isEmpty();
    }

    public Queue<E> getQueues() {
        return queues;
    }

    public void setQueues(Queue<E> queues) {
        this.queues = queues;
    }

    public void redo() {
        if (stacksRedo.empty()) {
            System.out.println("Không có công việc để khôi phục");
            return;
        }
        E task = stacksRedo.pop();
        stacks.push(task);
        System.out.println("Đã khôi phục công việc: " + task);
    }
}