/*
 * Remove Duplicates From Linked List
You're given the head of a Singly Linked List whose nodes are in sorted order with respect to their values. Write a function that returns a modified version of the Linked List that doesn't contain any nodes with duplicate values. The Linked List should be modified in place (i.e., you shouldn't create a brand new list), and the modified Linked List should still have its nodes sorted with respect to their values.

Each LinkedList node has an integer value as well as a next node pointing to the next node in the list or to None / null if it's the tail of the list.

Sample Input
linkedList = 1 -> 1 -> 3 -> 4 -> 4 -> 4 -> 5 -> 6 -> 6 // the head node with value 1
Sample Output
1 -> 3 -> 4 -> 5 -> 6 // the head node with value 1
 */
import java.util.*;

class Program {
    // This is an input class. Do not edit.
    public static class LinkedList {
        public int value;
        public LinkedList next;

        public LinkedList(int value) {
            this.value = value;
            this.next = null;
        }
    }

    public LinkedList removeDuplicatesFromLinkedList(LinkedList linkedList) {
        // Start from the head
        LinkedList currentNode = linkedList;

        // Traverse the list
        while (currentNode != null) {
            // Move next node pointer forward as long as duplicates exist
            LinkedList nextNode = currentNode.next;
            while (nextNode != null && nextNode.value == currentNode.value) {
                nextNode = nextNode.next;
            }

            // Link current node to the next distinct node
            currentNode.next = nextNode;

            // Move forward
            currentNode = nextNode;
        }

        // Return the head (unchanged)
        return linkedList;
    }
}
