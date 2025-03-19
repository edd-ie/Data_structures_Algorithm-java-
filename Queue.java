public class Queue {
    private int[] queue;
    private int front;
    private int rear;

    public Queue(int size) {
        queue = new int[size];
        front = -1;
        rear = 0;
    }

    public void enqueue(int data) {
        if (rear == queue.length) {
            rear = 0;
        }

        if(rear == front){
            System.out.println("Queue is full");
        }
        else {
            if (front == -1) {
                front = 0;
            }
            queue[rear] = data;
            rear++;
        }
    }

    public int dequeue() {
        int data = -1;
        if (front == -1) {
            System.out.println("Queue is empty");
        } else {
            data = queue[front];
            queue[front] = 0;
            if (front == rear) {
                front = -1;
                rear = 0;
            } else {
                front++;
            }
        }

        return data;
    }

    public int peek() {
        if (front == -1) {
            System.out.println("Queue is empty");
            return -1;
        }
        return queue[front];
    }

    public int size() {
        if (front == -1) {
            return 0;
        }
        if (rear >= front) {
            return rear - front;
        }
        return (queue.length - front) + rear;
    }
}
