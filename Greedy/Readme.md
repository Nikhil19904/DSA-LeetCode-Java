# ⚡ Greedy Algorithms in Java — DSA Series

Welcome to the **Greedy Algorithms** section!  
Greedy algorithms build up a solution piece by piece, always choosing the next step that offers the most immediate benefit.

---

## 🧠 What is a Greedy Algorithm?

A Greedy algorithm makes a **locally optimal choice** at each step with the hope that these choices lead to a globally optimal solution.

---

## 📂 Folder Structure

greedy/
├── ActivitySelection.java
├── FractionalKnapsack.java
├── JobScheduling.java
├── MinimumPlatforms.java
├── HuffmanCoding.java
└── README.md

pgsql
Copy
Edit

---

## ✅ Common Greedy Problems

| Problem Name              | File Name               | Technique                     |
|--------------------------|-------------------------|-------------------------------|
| Activity Selection       | `ActivitySelection.java` | Sort by finish time           |
| Fractional Knapsack      | `FractionalKnapsack.java`| Sort by value/weight ratio    |
| Job Scheduling           | `JobScheduling.java`     | Sort by deadline or profit    |
| Minimum Number of Platforms | `MinimumPlatforms.java` | Sort intervals and use two pointers |
| Huffman Coding           | `HuffmanCoding.java`     | Greedy tree building          |

---

## 🔑 Greedy Algorithm Template

```java
public class ActivitySelection {
    public static int maxActivities(int[] start, int[] finish) {
        int n = start.length;
        int count = 1;
        int lastFinish = finish[0];

        for (int i = 1; i < n; i++) {
            if (start[i] > lastFinish) {
                count++;
                lastFinish = finish[i];
            }
        }
        return count;
    }
}
