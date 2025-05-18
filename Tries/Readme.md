# 🌲 Tries (Prefix Trees) in Java — DSA Series

Welcome to the **Trie** section of the DSA repository!  
Tries are powerful tree-based structures used for **efficient string and prefix-based searching** — commonly used in autocomplete, spell-check, and word dictionaries.

This folder contains Java implementations for classic Trie problems, including insert/search, prefix matching, word suggestion, and deletion.

---

## 🧠 What is a Trie?

A **Trie** (pronounced *try*) is a tree data structure where:

- Each node represents a **character**
- The path from root to a node represents a **prefix**
- Each word ends at a special marker (like `isEnd = true`)

### 📌 Basic Operations

| Operation    | Purpose                             |
|--------------|--------------------------------------|
| `insert()`   | Add a word to the Trie               |
| `search()`   | Check if a word exists               |
| `startsWith()` | Check if any word starts with prefix |
| `delete()`   | Remove a word (optional)             |

---

## 📂 Folder Structure

tries/
├── TrieNode.java
├── Trie.java
├── TrieUsageDemo.java
├── WordSearch.java
├── LongestWordWithAllPrefixes.java
├── AutoCompleteSystem.java
├── ...


---

## ✅ Problem Checklist

| ✅ | Problem Title                          | File Name                           | Description                          |
|----|----------------------------------------|-------------------------------------|--------------------------------------|
| ✔️ | Implement Trie (Insert, Search)        | `Trie.java`                         | Core Trie methods                    |
| ✔️ | Word Search in 2D Grid                 | `WordSearch.java`                   | DFS + Trie combo                     |
| ❌ | Longest Word with All Prefixes Present | `LongestWordWithAllPrefixes.java`   | Trie + BFS                           |
| ❌ | Auto-complete System                   | `AutoCompleteSystem.java`           | Trie with frequency map              |
| ❌ | Replace Words (Prefix Dictionary)      | `ReplaceWords.java`                 | Trie + Greedy                        |

Update the checklist as you add/solve more problems.

---

## 🔍 Visual Representation

Here's a simple visual of how a Trie stores `"apple"` and `"app"`:

