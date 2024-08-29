# LRU Cache

## What is an LRU Cache?

An LRU (Least Recently Used) Cache is a data structure designed to manage a fixed amount of data. It keeps the most recently accessed items readily available while evicting the least recently used items when the cache is full. This approach ensures that frequently accessed data is quickly retrievable, enhancing overall system performance.

## Key Operations

The LRU Cache supports two main operations:

### Get
- **Description**: Retrieves the value associated with a key.
- **Behavior**: Updates the key's usage to mark it as recently accessed.

### Put
- **Description**: Adds or updates the value for a key.
- **Behavior**: If the cache exceeds its capacity, the least recently used item is removed to make space for the new or updated entry.

## Implementation Details 1

To implement an efficient LRU Cache, we use a combination of two data structures:

### HashMap
- **Purpose**: Provides fast access to cache entries.
- **Usage**: Allows for O(1) time complexity for both the `get` and `put` operations by storing key-value pairs.

### Doubly Linked List
- **Purpose**: Maintains the order of access.
- **Usage**: Allows for quick updates to the most recently used items by providing O(1) time complexity for moving nodes within the list. Each node in the list represents a cache entry and is linked to both its previous and next nodes.

## Implementation Details 2

- The LRUCache2 class uses LinkedHashMap with access order enabled (true). This allows the map to maintain the order of access, so when an entry is accessed or added, it is moved to the end of the list.
- The removeEldestEntry method is overridden to ensure that the cache does not exceed its capacity. When the size of the map exceeds the specified capacity, the oldest entry (the least recently used) is removed.

## Example Usage

Here is a conceptual example to illustrate how an LRU Cache might work:

1. **Initialization**: Create an LRU Cache with a fixed capacity, say 3.
2. **Put Operations**:
   - `Put(1, "A")` - Cache: `[1: "A"]`
   - `Put(2, "B")` - Cache: `[1: "A", 2: "B"]`
   - `Put(3, "C")` - Cache: `[1: "A", 2: "B", 3: "C"]`
3. **Get Operations**:
   - `Get(1)` - Accesses key `1`, Cache becomes: `[2: "B", 3: "C", 1: "A"]`
4. **Put Operation**:
   - `Put(4, "D")` - Cache is full, evicts key `2` (least recently used). Cache becomes: `[3: "C", 1: "A", 4: "D"]`

## Summary

An LRU Cache is a powerful data structure for managing a fixed size cache efficiently, ensuring that frequently accessed items are readily available while efficiently handling cache eviction.




