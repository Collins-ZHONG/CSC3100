def reverse_queue(queue):
    if not queue:
        return
    q1 = []
    while len(queue) > 0:
        for i in range(len(queue)-1):
            queue.append(queue[0])
            queue = queue[1:]
        q1.append(queue[0])
        queue = queue[1:]
    
    return q1

# Example
queue = [1, 2, 3, 4, 5]
print(reverse_queue(queue))  # Output: [5, 4, 3, 2, 1]
