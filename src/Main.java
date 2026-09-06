import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        List<String> todos = new ArrayList<>();
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
                        todos.add(todo);
                        System.out.println("할 일이 추가되었습니다.");
                        break;
                    case "2":
                    case "3":
                    case "4":
                        System.out.println("아직 구현되지 않은 기능입니다.");
                        break;
                    default:
                        System.out.println("0부터 4까지의 메뉴 번호를 입력해주세요.");
                }
            }
        }
    }
}
