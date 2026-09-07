import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        List<Todo> todos = new ArrayList<>();
        try (Scanner scanner = new Scanner(System.in)) {
            while (true) {
                System.out.println("\n=== Todo CLI ===");
                System.out.println("1. 할 일 추가");
                System.out.println("2. 할 일 목록 조회");
                System.out.println("3. 할 일 완료 처리");
                System.out.println("4. 할 일 삭제");
                System.out.println("0. 종료");
                System.out.print("메뉴를 선택하세요: ");

                if (!scanner.hasNextLine()) {
                    System.out.println("\n프로그램을 종료합니다.");
                    return;
                }

                String input = scanner.nextLine().trim();
                switch (input) {
                    case "0":
                        System.out.println("프로그램을 종료합니다.");
                        return;
                    case "1":
                        System.out.print("할 일을 입력하세요: ");
                        if (!scanner.hasNextLine()) {
                            System.out.println("\n프로그램을 종료합니다.");
                            return;
                        }
                        String todo = scanner.nextLine().trim();
                        if (todo.isEmpty()) {
                            System.out.println("할 일 내용을 입력해주세요.");
                            break;
                        }
                        todos.add(new Todo(todo));
                        System.out.println("할 일이 추가되었습니다.");
                        break;
                    case "2":
                        printTodos(todos);
                        break;
                    case "3":
                        printTodos(todos);
                        if (todos.isEmpty()) {
                            break;
                        }
                        System.out.print("완료할 할 일 번호를 입력하세요: ");
                        if (!scanner.hasNextLine()) {
                            System.out.println("\n프로그램을 종료합니다.");
                            return;
                        }
                        int number;
                        try {
                            number = Integer.parseInt(scanner.nextLine().trim());
                        } catch (NumberFormatException e) {
                            System.out.println("올바른 숫자 번호를 입력해주세요.");
                            break;
                        }
                        if (number < 1 || number > todos.size()) {
                            System.out.println("1부터 " + todos.size() + "까지의 번호를 입력해주세요.");
                            break;
                        }
                        Todo selectedTodo = todos.get(number - 1);
                        if (selectedTodo.completed) {
                            System.out.println("이미 완료된 할 일입니다.");
                            break;
                        }
                        selectedTodo.completed = true;
                        System.out.println("할 일이 완료되었습니다.");
                        break;
                    case "4":
                        printTodos(todos);
                        if (todos.isEmpty()) {
                            break;
                        }
                        System.out.print("삭제할 할 일 번호를 입력하세요: ");
                        if (!scanner.hasNextLine()) {
                            System.out.println("\n프로그램을 종료합니다.");
                            return;
                        }
                        int deleteNumber;
                        try {
                            deleteNumber = Integer.parseInt(scanner.nextLine().trim());
                        } catch (NumberFormatException e) {
                            System.out.println("올바른 숫자 번호를 입력해주세요.");
                            break;
                        }
                        if (deleteNumber < 1 || deleteNumber > todos.size()) {
                            System.out.println("1부터 " + todos.size() + "까지의 번호를 입력해주세요.");
                            break;
                        }
                        todos.remove(deleteNumber - 1);
                        System.out.println("할 일이 삭제되었습니다.");
                        break;
                    default:
                        System.out.println("0부터 4까지의 메뉴 번호를 입력해주세요.");
                }
            }
        }
    }

    private static void printTodos(List<Todo> todos) {
        if (todos.isEmpty()) {
            System.out.println("등록된 할 일이 없습니다.");
            return;
        }
        for (int i = 0; i < todos.size(); i++) {
            Todo todo = todos.get(i);
            String status = todo.completed ? "[o]" : "[ ]";
            System.out.println((i + 1) + ". " + status + " " + todo.title);
        }
    }

    private static class Todo {
        private final String title;
        private boolean completed;

        private Todo(String title) {
            this.title = title;
        }
    }
}
