class Deque:
    def __init__(self):
        self.items = []

    def push(self, value):
        self.items.append(value)

    def popleft(self):
        if not self.items:
            raise IndexError("pop from an empty deque")
        return self.items.pop(0)

    def pop(self):
        if not self.items:
            raise IndexError("pop from an empty deque")
        return self.items.pop()

    def __len__(self):
        return len(self.items)

    def __str__(self):
        return str(self.items)
    
    def is_empty(self):
        return self.__len__() == 0
    
    def peek(self):
        return self.items[-1]
    
n, k=map(int, input().split())
lst =[int(i) for i in input().split()]
q = Deque()
ans = []
for i in range(k):
    while (not q.is_empty()) and (lst[i]>= lst[q.peek()]):
        q.pop()
    q.push(i)
print(lst[q.items[0]])

for i in range(k,n):        ### simulate every move of the window
    while (not q.is_empty()) and (lst[i]>= lst[q.peek()]):      #
        q.popleft()
    q.push(i)

    while q.items[0]<= i- k:
    # if q.items[0] <= i-k:
        q.popleft()
    print(lst[q.items[0]])

# left, right = 0, k-1
# for i in range(k, n):
#     q.popleft()
