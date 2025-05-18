# 🔍 Binary Search in Java — DSA Series

Welcome to the **Binary Search** section!  
Binary Search is a fundamental algorithm used to efficiently find an element in a **sorted array** or search space.

---

## 🧠 What is Binary Search?

Binary Search works by repeatedly dividing the search interval in half:

- Start with the whole array.
- Compare the target with the middle element.
- If equal, return the index.
- If target is less, search the left half.
- If target is greater, search the right half.
- Repeat until the target is found or the search space is empty.

---

## 📂 Folder Structure

binary_search/
├── BinarySearchIterative.java
├── BinarySearchRecursive.java
├── FindFirstAndLastPosition.java
├── SearchInsertPosition.java
└── README.md

pgsql
Copy
Edit

---

## ✅ Common Binary Search Problems

| Problem Name                 | File Name                    | Notes                            |
|-----------------------------|------------------------------|----------------------------------|
| Basic Binary Search          | `BinarySearchIterative.java` | Iterative approach                |
| Recursive Binary Search      | `BinarySearchRecursive.java` | Recursive approach                |
| Find First and Last Position| `FindFirstAndLastPosition.java` | Modified binary search            |
| Search Insert Position      | `SearchInsertPosition.java`  | Where to insert if not found      |

---

## 🔑 Binary Search Template (Iterative)

```java
public int binarySearch(int[] nums, int target) {
    int left = 0, right = nums.length - 1;
    while (left <= right) {
        int mid = left + (right - left) / 2;
        if (nums[mid] == target) return mid;
        else if (nums[mid] < target) left = mid + 1;
        else right = mid - 1;
    }
    return -1;  // Not found
}
