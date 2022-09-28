import java.util.Scanner;

public class HammingCode {

    static int checker4args(char a1, char a2, char a3, char a4) {
        return (Integer.parseInt(a1 + "") +
                Integer.parseInt(a2 + "") +
                Integer.parseInt(a3 + "") +
                Integer.parseInt(a4 + "")) % 2;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        char[] message = input.nextLine().toCharArray();
        int[] checkSum = new int[3];

        checkSum[0] = checker4args(message[0], message[2], message[4], message[6]);
        checkSum[1] = checker4args(message[1], message[2], message[5], message[6]);
        checkSum[2] = checker4args(message[3], message[4], message[5], message[6]);

        System.out.print("Синдром последовательности: ");
        for (int i = 2; i >= 0; i--) System.out.print(checkSum[i] + " ");

        int error = checkSum[2] * 4 + checkSum[1] * 2 + checkSum[0] - 1;
        if (error == -1) System.out.println("\nСообщение верно");
        else {
            System.out.println("\nОшибка в бите: " + (error + 1));

            message[error] = message[error] == '1' ? '0' : '1';

            System.out.print("Исправленная последовательность: ");
            for (char i : message) System.out.print(i);

            System.out.println("\nИсправленные информационные биты: " + message[2] + message[4] + message[5] + message[6]);
        }
    }

}
