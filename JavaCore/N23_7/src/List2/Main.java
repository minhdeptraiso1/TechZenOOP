package List2;

import java.util.Scanner;

public class Main {

    private static final Scanner sc = new Scanner(System.in);
    private static final StaskManager<Task> taskManager = new StaskManager<>();

    public static void main(String[] args) {
        taskManager.addToQueue(new Task("Làm bài tập", 2));
        taskManager.addToQueue(new Task("Đi siêu thị", 4));
        taskManager.addToQueue(new Task("Gọi điện thoại", 1));
        taskManager.addToQueue(new Task("Dọn nhà", 3));
        taskManager.pushToStack(new Task("Làm bài tập", 2));
        taskManager.pushToStack(new Task("Đi siêu thị", 4));
        taskManager.pushToStack(new Task("Gọi điện thoại", 1));
        taskManager.pushToStack(new Task("Dọn nhà", 3));
        int choose;

        while (true) {
            do {
                System.out.println("========================================MENU CHÍNH========================================");
                System.out.println("1. Hiển thị công việc");
                System.out.println("2. Thêm mới công việc");
                System.out.println("3. Xử lý công việc");
                System.out.println("4. Khôi phục công việc (Redo)");
                System.out.println("5. Xử lý công việc ưu tiên cao nhất");
                System.out.println("9. Thoát");

                System.out.print("Mời bạn lựa chọn: ");
                try {
                    choose = Integer.parseInt(sc.nextLine());
                } catch (NumberFormatException e) {
                    choose = -1;
                }

                switch (choose) {
                    case 1:
                        displayTasks();
                        break;
                    case 2:
                        addNewTask();
                        break;
                    case 3:
                        processTask();
                        break;
                    case 4:
                        redoTask();
                        break;
                    case 5:
                        processHighestPriorityTask();
                        break;
                    case 9:
                        if (confirmExit()) {
                            System.out.println("Cảm ơn bạn đã sử dụng Task Manager!");
                            return;
                        }
                        break;
                    default:
                        System.out.println("Không hợp lệ! Vui lòng chọn từ 1-5 hoặc 9.");
                        break;
                }

            } while (choose < 1 || (choose > 5 && choose != 9));
        }
    }

    private static void displayTasks() {
        System.out.println("\n==================== HIỂN THỊ CÔNG VIỆC ====================");
        System.out.println("1. Hiển thị Stack (công việc gần nhất)");
        System.out.println("2. Hiển thị Queue (hàng đợi công việc)");
        System.out.println("3. Hiển thị công việc đã xử lý (Redo Stack)");
        System.out.print("Chọn loại hiển thị: ");

        try {
            int choice = Integer.parseInt(sc.nextLine());
            switch (choice) {
                case 1:
                    System.out.println("\n--- STACK (Công việc gần nhất) ---");
                    if (taskManager.isStackEmpty()) {
                        System.out.println("Stack rỗng!");
                    } else {
                        taskManager.showStacks();
                    }
                    break;
                case 2:
                    System.out.println("\n--- QUEUE (Hàng đợi công việc) ---");
                    if (taskManager.isStackEmpty()) {
                        System.out.println("Queue rỗng!");
                    } else {
                        taskManager.showQueue();
                    }
                    break;
                case 3:
                    System.out.println("\n--- REDO STACK (Công việc đã xử lý) ---");
                    taskManager.showStacksRedo();
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ!");
            }
        } catch (NumberFormatException e) {
            System.out.println("Vui lòng nhập số hợp lệ!");
        }
    }

    private static void addNewTask() {
        System.out.println("\n==================== THÊM MỚI CÔNG VIỆC ====================");
        System.out.println("1. Thêm vào Stack");
        System.out.println("2. Thêm vào Queue");
        System.out.print("Chọn cách thêm: ");

        try {
            int choice = Integer.parseInt(sc.nextLine());

            System.out.print("Nhập tên công việc: ");
            String name = sc.nextLine().trim();

            if (name.isEmpty()) {
                System.out.println("Tên công việc không được để trống!");
                return;
            }

            System.out.print("Nhập độ ưu tiên (số càng nhỏ càng ưu tiên): ");
            int priority = Integer.parseInt(sc.nextLine());

            Task newTask = new Task(name, priority);

            switch (choice) {
                case 1:
                    taskManager.pushToStack(newTask);
                    System.out.println("Đã thêm công việc vào Stack: " + newTask);
                    break;
                case 2:
                    taskManager.addToQueue(newTask);
                    System.out.println("Đã thêm công việc vào Queue: " + newTask);
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ!");
            }
        } catch (NumberFormatException e) {
            System.out.println("Vui lòng nhập số hợp lệ!");
        } catch (Exception e) {
            System.out.println("Có lỗi xảy ra: " + e.getMessage());
        }
    }

    private static void processTask() {
        System.out.println("\n==================== XỬ LÝ CÔNG VIỆC ====================");
        System.out.println("1. Xử lý từ Stack (LIFO - Last In First Out)");
        System.out.println("2. Xử lý từ Queue (FIFO - First In First Out)");
        System.out.print("Chọn cách xử lý: ");

        try {
            int choice = Integer.parseInt(sc.nextLine());

            switch (choice) {
                case 1:
                    if (taskManager.isStackEmpty()) {
                        System.out.println("Stack rỗng! Không có công việc để xử lý.");
                    } else {
                        Task processedTask = taskManager.popFromStack();
                        System.out.println("Đã xử lý công việc từ Stack: " + processedTask);
                    }
                    break;
                case 2:
                    if (taskManager.isStackQueue()) {
                        System.out.println("Queue rỗng! Không có công việc để xử lý.");
                    } else {
                        Task processedTask = taskManager.pollFromQueue();
                        System.out.println("Đã xử lý công việc từ Queue: " + processedTask);
                    }
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ!");
            }
        } catch (NumberFormatException e) {
            System.out.println("Vui lòng nhập số hợp lệ!");
        } catch (Exception e) {
            System.out.println("Có lỗi xảy ra: " + e.getMessage());
        }
    }

    private static void redoTask() {
        System.out.println("\n==================== KHÔI PHỤC CÔNG VIỆC ====================");
        taskManager.redo();
    }

    private static void processHighestPriorityTask() {
        System.out.println("\n==================== XỬ LÝ CÔNG VIỆC ƯU TIÊN CAO NHẤT ====================");

        if (taskManager.isQueueEmpty()) {
            System.out.println("Không có công việc nào trong queue.");
            return;
        }

        // Tìm độ ưu tiên cao nhất (priority nhỏ nhất)
        int highestPriority = Integer.MAX_VALUE;
        for (Task t : taskManager.getQueues()) {
            if (t.getPriority() < highestPriority) {
                highestPriority = t.getPriority();
            }
        }

        // Duyệt lại để xử lý task có độ ưu tiên cao nhất
        StaskManager<Task> temp = new StaskManager<>();
        boolean removed = false;

        while (!taskManager.isQueueEmpty()) {
            Task current = taskManager.pollFromQueue();
            if (!removed && current.getPriority() == highestPriority) {
                System.out.println("Đã xử lý công việc ưu tiên cao nhất: " + current);
                removed = true;
            } else {
                temp.addToQueue(current);
            }
        }

        // Gán lại queue từ temp
        taskManager.setQueues(temp.getQueues());
    }

    private static boolean confirmExit() {
        System.out.print("Bạn có chắc chắn muốn thoát (Y/N)? ");
        String confirm = sc.nextLine().trim().toLowerCase();
        return confirm.equals("y") || confirm.equals("yes");
    }
}
