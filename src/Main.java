import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        /**
         * @문제
         * 세준이는 양수와 +, -, 그리고 괄호를 가지고 길이가 최대 50인 식을 만들었다.
         * 그리고 나서 세준이는 괄호를 모두 지웠다.
         * 그리고 나서 세준이는 괄호를 적절히 쳐서 이 식의 값을 최소로 만들려고 한다.
         * 괄호를 적절히 쳐서 이 식의 값을 최소로 만드는 프로그램을 작성하시오.
         *
         * @입력
         * 첫째 줄에 식이 주어진다.
         * 식은 ‘0’~‘9’, ‘+’, 그리고 ‘-’만으로 이루어져 있고,
         * 가장 처음과 마지막 문자는 숫자이다.
         * 그리고 연속해서 두 개 이상의 연산자가 나타나지 않고,
         * 5자리보다 많이 연속되는 숫자는 없다.
         * 수는 0으로 시작할 수 있다.
         *
         * @출력
         * 첫째 줄에 정답을 출력한다.
         *
         * @입력예시
         * 55-50+40
         *
         * (55-50)+40 = 45 (X)
         * 55(-50+40) = 50 (X)
         * 55-(50+40) = 35 (O)
         * 최소값을 출력 해야 하므로 '-' 뒤에 가장 큰값을 만들도록 괄호를 삽입 해야 한다.
         * 55-50+40+20-10 => 55-(50+40+20)-10 => 다음 마이너스가 나오기 전에 괄호를 닫아야 함.
         *
         * @출력예시
         * -35
         */
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        String[] numsByMinus = input.split("-");

        final int result = new Greedy(numsByMinus).caculate();
        System.out.printf("%d", result);
    }
}


class Greedy {
    private String[] numsByMinus;

    Greedy(String[] numsByMinus) {
        this.numsByMinus = numsByMinus;
    }

    public int caculate() {
        int result = 0;
        for(int i = 0; i < numsByMinus.length; i++) {
            String[] numbsByPlus = numsByMinus[i].split("\\+");
            int totalByPlusUnit = 0;
            for (String numByPlus : numbsByPlus) {
                totalByPlusUnit += Integer.parseInt(numByPlus);
            }

            if(i == 0) {
                result = totalByPlusUnit;
                continue;
            }
            result -= totalByPlusUnit;
        }

        return result;
    }
}