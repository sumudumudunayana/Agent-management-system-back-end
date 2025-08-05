package edu.sliit.datastructure; // or your actual package

import edu.sliit.dto.User;

import java.util.ArrayList;
import java.util.List;

public class UserQueue {
    private UserNode front;
    private UserNode rear;

    public UserQueue() {
        front = null;
        rear = null;
    }

    // Add agent at the end of the queue
    public void enqueue(User user) {
        UserNode newNode = new UserNode(user);
        if (rear == null) {
            front = rear = newNode;
        } else {
            rear.setNext(newNode);
            rear = newNode;
        }
    }

    // Remove agent from front of the queue
    public User dequeue() {
        if (front == null) {
            return null; // empty queue
        }
        UserNode temp = front;
        front = front.getNext();

        if (front == null) {
            rear = null;
        }
        temp.setNext(null);
        return temp.getData();
    }

    // Search agent by ID in the queue, return Agent or null
        public User searchById(Integer id) {
        UserNode current = front;
        while (current != null) {
            if (current.getData().getId().equals(id)) {
                return current.getData();
            }
            current = current.getNext();
        }
        return null;
    }

    // Insertion sort by agentDate (ascending)
    public void sortByDate() {
        if (front == null || front.getNext() == null) {
            return; // 0 or 1 element, already sorted
        }

        UserNode sorted = null;  // new sorted list head

        while (front != null) {
            UserNode current = front;
            front = front.getNext();
            current.setNext(null);

            if (sorted == null || compareDates(current.getData().getUserDate(), sorted.getData().getUserDate()) < 0) {
                // Insert at start
                current.setNext(sorted);
                sorted = current;
            } else {
                // Insert in middle or end
                UserNode search =   sorted;
                while (search.getNext() != null && compareDates(search.getNext().getData().getUserDate(), current.getData().getUserDate()) <= 0) {
                    search = search.getNext();
                }
                current.setNext(search.getNext());
                search.setNext(current);
            }
        }
        front = sorted;

        rear = front;
        if (rear != null) {
            while (rear.getNext() != null) {
                rear = rear.getNext();
            }
        }
    }

    // Helper to compare date strings (yyyy-MM-dd format)
    private int compareDates(String d1, String d2) {
        if (d1 == null && d2 == null) return 0;
        if (d1 == null) return 1;   // null considered greater, so goes to end
        if (d2 == null) return -1;
        return d1.compareTo(d2);
    }

    // Return all agents as list (for displaying, etc)
    public List<User> getAllUsers() {
        List<User> list = new ArrayList<>();
        UserNode current = front;
        while (current != null) {
            list.add(current.getData());
            current = current.getNext();
        }
        return list;
    }
}
