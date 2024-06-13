n, m, p = map(int, input().split())
result = 0
for t in range(0,p):
    i, j, k = map(int, input().split())
    result =(result + (n-i+1) * i * j * (m-j+1) * k) % 998244353
print(result)
