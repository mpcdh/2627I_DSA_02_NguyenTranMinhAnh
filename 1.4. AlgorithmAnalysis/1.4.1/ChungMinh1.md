## Chứng minh $P(n) = \frac{n(n-1)(n-2)}{6}$
### Bước 1: Mệnh đề cơ sở (với $n=3$)
- Với $n=3$, từ 3 phần tử ta chỉ có duy nhất 1 cách chọn ra tập hợp 3 phần tử.
- Áp dụng công thức: $\frac{3(3-1)(3-2)}{6} = 1$
- Mệnh đề đúng với $n=3$
### Bước 2: Giả thiết quy nạp
Giả sử công thúc đúng với $n = k$ $(k\geq3)$.  
Số bộ 3 phần tử được chọn từ k phần tử: $P(k) = \frac{k(k-1)(k-2)}{6}$
### Bước 3: Bước quy nạp (chứng minh đúng với $n=k+1$)
Ta cần chứng minh công thức đúng với $k+1$ phần tử: $P(k+1) = \frac{(k+1)k(k-1)}{6}$  

**Chứng minh:**  
Xét một tập hợp $S$ gồm $k + 1$ phần tử. Giả sử ta tách 1 phần tử bất kỳ ra, gọi là phần tử $X$. Tập hợp $k$ phần tử còn lại gọi là $S'$.  
Các bộ 3 phần tử được chọn từ tập hợp $S$ sẽ thuộc vào 2 trường hợp không trùng nhau:  
1. **Trường hợp 1: Bộ 3 phần tử không chứa phần tử X**
- Tất cả 3 phần tử này đều được chọn từ tập $S'$ (gồm $k$ phần tử).
- Theo giả thiết quy nạp, số cách chọn ở trường hợp này là $P(k) = \frac{k(k-1)(k-2)}{6}$
2. **Trường hợp 2: Bộ 3 phần tử có chứa phần tử $X$.**
- Do đã có sẵn phần tử $X$, ta chỉ cần chọn thêm 2 phần tử nữa từ $k$ phần tử còn lại trong $S'$.
- Số cách chọn 2 phần tử từ $k$ phần tử là: $\frac{k(k-1)}{2}$  

Tổng số bộ 3 phần tử chọn được từ $k + 1$ phần tử là: $P(k+1) = P(k) + \frac{k(k-1)}{2}$  
Thay công thức $P(k)$ từ giả thiết quy nạp vào: $P(k+1) = \frac{k(k-1)(k-2)}{6} + \frac{k(k-1)}{2}$  
Quy đồng mẫu số chung là 6: $P(k+1) = \frac{k(k-1)(k-2) + 3k(k-1)}{6}$  
Đặt nhân tử chung $k(k-1)$ ra ngoài: $P(k+1) = \frac{k(k-1) \cdot [(k-2) + 3]}{6} = \frac{k(k-1)(k+1)}{6} = \frac{(k+1)k(k-1)}{6}$  
Công thức đúng với $n=k+1$ (đpcm).

