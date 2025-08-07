# Tính kế thừa
+ là cơ chết cho phép lơớp con có thể sử dụng lại các đặc điểm và hành vi đã được địn
nghĩa ở lớp cha
+ mục đích 
  + là để tái sử dụng mã nguồn
+ko hỗ trợ đa kế thừa ( 1 lớp con ko có nhiều hơn 1 lớp cha)
## Overload
+ cùng tên nhưng khác tham số
+ vd
  + public static int add(int a, int b){return a+b}
  + public static int add(int a, int b , int c){return a+b+c}
  + đang gi đè lên phương thức add
+ xảy ra trong cùng 1 class
## override
+ gi đè phương thức / phủ nhận 
+ @: annotation : kí hiệu + override
+ dk : trùng tên phương thức với lớp cha ,cuùng tham số,cùng kiểu trả về
+ định nghĩa lại phương thức lớp cha sao cho phù hợp với lớp con
+ xảy ra trong quan hệ kế thừa
## final
+ đi với biến
  + hằng số
+ đi với phương thức
  + ko cho gi đè
+ đi với lớp cha
  + ko cho kế thừa(vô sinh)
+ cách dùng final + biến/phương thức/class



