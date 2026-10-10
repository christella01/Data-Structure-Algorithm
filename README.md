# Week 3 Assignment: Build Your Own Data Structures

## Description

This project implements core data structures and algorithms using Java.

## How to Run

Open the project folder in VS Code.

Compile all Java files:

    javac *.java

Run the demonstration:

    java Main

## Part 1: Custom Singly Linked List

The linked list uses nodes that store data and a reference to the next node.

| Method | Time Complexity | Extra Space |
|---|---|---|
| addFirst | O(1) | O(1) |
| addLast | O(1) | O(1) |
| removeFirst | O(1) | O(1) |
| get | O(n) | O(1) |
| size | O(1) | O(1) |
| isEmpty | O(1) | O(1) |
| reverse | O(n) | O(1) |
| findMiddle | O(n) | O(1) |
| display | O(n) | O(1) |

Real-world use: Linked lists can be used to manage sequences of items and
to build other data structures.

## Part 2: Stack and Queue

| Method | Time Complexity | Extra Space |
|---|---|---|
| push | O(1) | O(1) |
| pop | O(1) | O(1) |
| peek | O(1) | O(1) |
| isEmpty | O(1) | O(1) |
| Stack size | O(1) | O(1) |
| enqueue | O(1) | O(1) |
| dequeue | O(1) amortized | O(1) per operation amortized |
| Queue peek | O(1) amortized | O(1) per operation amortized |
| Queue isEmpty | O(1) | O(1) |
| isBalanced | O(n) | O(n) |

One queue operation can take O(n) when items must move between stacks,
but each item moves at most once in each direction, giving O(1)
amortized time per enqueue/dequeue operation.

Real-world use: Stacks support undo operations and bracket checking.
Queues are useful for scheduling requests and background jobs.

## Part 3: Arrays and Strings

| Method | Time Complexity | Extra Space |
|---|---|---|
| rotateRight | O(n) | O(1) |
| reverseArray | O(n) | O(1) |
| isAnagram | O(n) | O(1) |
| twoSumSorted | O(n) | O(1) |

The anagram method uses a fixed-size character frequency array, so its
auxiliary space is constant with respect to input length.

Real-world use: Array algorithms are useful in data processing,
text validation, and efficient searching.

## Part 4: LRU Cache

| Method | Time Complexity | Extra Space |
|---|---|---|
| LRUCache constructor | O(1) | O(1) initially |
| removeNode | O(1) | O(1) |
| addToFront | O(1) | O(1) |
| moveToFront | O(1) | O(1) |
| get | O(1) expected | O(1) |
| put | O(1) expected | O(1) |
| size | O(1) | O(1) |
| containsKey | O(1) expected | O(1) |
| display | O(n) | O(1) |

Real-world use: LRU caches store recently used information to reduce
repeated database queries, API calls, and expensive computations.

## Design Notes

- MyLinkedList is generic and uses custom nodes.
- MyStack is built using MyLinkedList.
- MyQueue uses two stacks.
- ArrayStringUtils contains array and string algorithms.
- LRUCache uses a HashMap and a custom doubly linked list.
- Main demonstrates all assignment parts.
- Java collections are not used to implement the custom linked list,
  stack, or queue.