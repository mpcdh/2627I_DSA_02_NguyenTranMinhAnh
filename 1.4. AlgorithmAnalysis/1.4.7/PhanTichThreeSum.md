## Thuật toán: ThreeSum
### 1. Mô hình chi phí
Số lần các phép toán cơ bản thực thi chính bằng số lượng tập hợp con 3 phần tử chọn từ $N$ phần tử, ký hiệu là $\binom{N}{3}$: 
$\binom{N}{3} = \frac{N(N - 1)(N - 2)}{3!} = \frac{N^3 - 3N^2 + 2N}{6}$  
#### A. Phép toán số học
Mỗi lần kiểm tra một bộ ba, thuật toán thực hiện 2 phép cộng
- Phép cộng 1: $arr[i] + arr[j]$
- Phép cộng 2: $(arr[i] + arr[j]) + arr[k]$

Tổng số phép cộng: $2 \times \binom{N}{3} = \frac{N^3 - 3N^2 + 2N}{3} \sim \frac{1}{3}N^3$
#### B. Phép toán so sánh
Mỗi bộ ba cần 1 phép so sánh kết quả tổng với $0$ (hoặc kiểm tra điều kiện == 0):  
Tổng số phép so sánh: $1 \times \binom{N}{3} = \frac{N^3 - 3N^2 + 2N}{6} \sim \frac{1}{6}N^3$
#### C. Tổng số thao tác
Tổng số thao tác: $\frac{1}{2} N^3$
### 2. Đánh giá độ phức tạp thời gian: $$\Theta(N^3)$$