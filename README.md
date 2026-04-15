# Ailbekov-Maxat_SE-2534_ADS_Assignment-2
This repository contains custom implementations of fundamental physical and logical data structures in Java. This project was developed as part of the "Algorithms and Data Structures" course (Assignment 2).

## 📝 Description
The primary goal of this project is to understand the inner workings of core data structures by building them from scratch. The project strictly adheres to the rule of **not using any built-in classes from `java.util.*`** (with the sole exception of the `Iterator` interface).

The repository consists of two main parts:
1. **Physical Data Structures:** Custom implementations of dynamic arrays and doubly linked lists.
2. **Logical Data Structures:** Stack, Queue, and Min-Heap built on top of the physical structures using the principle of composition to ensure strict access rules (LIFO, FIFO, etc.).

## ✨ Features & Implemented Structures

### Physical Structures (implementing custom `MyList<T>` interface)
* **`MyArrayList<T>`**: A dynamic array that automatically resizes itself when capacity is reached. Includes an $O(N^2)$ bubble sort implementation.
* **`MyLinkedList<T>`**: A strictly **Doubly Linked List** with `head` and `tail` references, allowing $O(1)$ time complexity for adding/removing elements at both ends.

### Logical Structures
* **`MyStack<T>`**: Follows LIFO (Last-In-First-Out) principle.
* **`MyQueue<T>`**: Follows FIFO (First-In-First-Out) principle.
* **`MyMinHeap<T>`**: A complete binary tree structure where the parent is always less than or equal to its children, providing $O(1)$ access to the minimum element. Includes `heapify` and `traverseUp` mechanics.

## 🏗️ Architectural Decisions

To strictly follow the assignment requirement that *"Each of these three classes should share only their own functionalities"*, the logical structures were built using **Composition rather than Inheritance**:
* **Stack & Queue** use `MyLinkedList` under the hood. This provides true $O(1)$ performance for `push`, `pop`, `enqueue`, and `dequeue` operations without exposing forbidden methods like `add(index)` to the end-user.
* **Min-Heap** uses `MyArrayList` under the hood. This allows efficient $O(1)$ access to elements via mathematical index calculations (`2i+1`, `2i+2`, `(i-1)/2`) required for maintaining the heap property.

## 🚀 Getting Started

### Prerequisites
* Java Development Kit (JDK) 8 or higher.

### Running the tests
1. Clone the repository to your local machine.
2. Open the project in your preferred IDE (IntelliJ IDEA, Eclipse, etc.) or navigate to the directory via the terminal.
3. Compile the Java files:
   ```bash
   javac *.java
4. Run the Main class to see the tests in action:
   ```bash
   java Main

## 👤 Author
#### Me: [@Ailbekov-Maksat](https://github.com/HappyGamerKZ)
