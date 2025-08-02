# Bài 06: Abstract Class, Interface

## Dò bài cũ

1. Kế thừa và đặc điểm của kế thừa
2. Từ khóa `final`
3. Tính đa hình

---

## 1. Kế thừa

**Khái niệm:**  
Là cơ chế cho phép lớp con sử dụng lại các đặc điểm và hành vi đã được định nghĩa ở lớp cha.

**Mục đích:**

- Tái sử dụng mã nguồn.

**Mối quan hệ:**

- Giữa lớp cha và lớp con là *is-a*.

**Lưu ý:**

- Lớp cha: `super class`, `parent class`, `base class`
- Lớp con: `subclass`, `child class`, `derived class`

**Đặc điểm:**

- Lớp con không kế thừa constructor của lớp cha.
- Lớp con không truy cập được các thành phần `private` của lớp cha.
- Java không hỗ trợ đa kế thừa lớp.

---

## 2. Từ khóa `final`

### `final` dùng cho:

- **Biến**: tạo hằng số không thể thay đổi giá trị.
- **Phương thức**: không cho lớp con ghi đè (`override`).
- **Lớp**: không cho phép lớp khác kế thừa (lớp "vô sinh").

---

## 3. Tính đa hình (Polymorphism)

**Khái niệm:**  
Một đối tượng có thể có nhiều hành vi khác nhau tùy vào ngữ cảnh.

### a. Overriding (Ghi đè)

- Định nghĩa lại phương thức của lớp cha cho phù hợp với lớp con.
- Xảy ra khi có quan hệ *is-a*.
- Đa hình **runtime**.

### b. Overloading (Nạp chồng)

- Cùng tên phương thức, nhưng khác tham số truyền vào.
- Xảy ra **trong cùng một lớp**.
- Đa hình **compile-time**.

---

## 4. Tính trừu tượng (Abstraction)

**Khái niệm:**  
Ẩn chi tiết xử lý, chỉ hiển thị tính năng cho người dùng.

- Người dùng chỉ quan tâm kết quả, không cần biết cách triển khai.

**Trong Java:**  
Được thực hiện thông qua:

- `abstract class`
- `interface`

---

## 5. Abstract Class

**Khái niệm:**  
Là lớp có tính trừu tượng cao, không thể tạo được đối tượng trực tiếp.

### Lợi ích:

- Không muốn tạo đối tượng cụ thể.
- Có một số phương thức chưa xác định cụ thể.
- Sử dụng mà không quan tâm đối tượng đó thuộc lớp nào.

### Tính chất:

- Không thể tạo đối tượng từ abstract class.
- Có thể chứa **thuộc tính**, **method bình thường**, và **method abstract**.
- Nếu có `abstract method` thì class bắt buộc phải là `abstract`.
- Không thể kết hợp với `final`.
- Có thể kế thừa từ abstract class khác mà không cần override.

---

## 6. Interface

**Khái niệm:**  
Là bản thiết kế của một lớp.  
Quy định các hành vi chung mà lớp triển khai phải thực hiện.  
(dùng từ khóa `implements`)

### Tính chất:

- Không thể tạo đối tượng.
- Các trường đều là `public static final`.
- Các phương thức là `public abstract`.
- Không có constructor.
- Có thể kế thừa từ nhiều interface khác (đa kế thừa interface).

---

## 7. Interface trong Java 8+

Java 8 giới thiệu thêm:

- **Default method**:
    - Có thân phương thức.
    - Cho phép ghi đè.
- **Static method**:
    - Có thân phương thức.
    - Không cho phép ghi đè.
    - Gọi bằng tên interface.

---

**THANK YOU**
