import java.util.Random;
import java.util.Scanner;


public class Homework4 {
    // X O

    static String[][] field;
    public static  String DOT_X = ("X");
    public static  String DOT_ZERO = ("O");
    public static void main(String[] args) {

        initField();
        showField();

        while (!checkWin()){
            movePlayer();
            showField();
            movePC();
            showField();
        }
    }


    //создать поле
    public static void initField() {
        field = new String[3][3];
        for (int i = 0; i < field.length; i++)
            for (int j = 0; j < field.length; j++)
                field[i][j] = ".";
    }

    //вывести поле
    public static void showField() {

        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field.length; j++) {
                System.out.print(field[i][j] + " ");
            }
            System.out.println();
        }
    }

    //игрок ходит

    public static void movePlayer() {
        System.out.println("Введите координаты");
        Scanner sc = new Scanner(System.in);

        boolean isNotFinishedMove = true;

        while (isNotFinishedMove) {
            try {
                int x = sc.nextInt() - 1;
                int y = sc.nextInt() - 1;
                if (x >= 0 && x <= field.length && y >= 0 && y <= field.length) {
                    if (!field[x][y].equals("X") && !field[x][y].equals("O")) {
                        field[x][y] = "X";
                        isNotFinishedMove = false;
                    } else {
                        System.out.println("Тут уже сделан ход");
                    }
                } else {
                    System.out.println("Вы ушли за пределы поля");
                }
            } catch (Exception e){
                System.out.println("Вы ввели не правильное значение");
            }
        }
    }

    //проверка ходов с помощью циклов
    public static boolean checkWin() {
        int countFreeSpace = 0;

        for (String[] arr: field)
            for (String elem: arr)
                if (elem.equals("."))
                    countFreeSpace += 1;

        for (int x = 0; x < 3; x++)
            if ((field[x][0] == DOT_X && field[x][1] == DOT_X && field[x][2] == DOT_X) ||
                    (field[0][x] == DOT_X && field[1][x] == DOT_X && field[2][x] == DOT_X)
                    || (field[0][0] == DOT_X && field[1][1] == DOT_X && field[2][2] == DOT_X) ||
                    (field[2][0] == DOT_X && field[1][1] == DOT_X && field[0][2] == DOT_X)) {
                System.out.println("Игрок победил!");
                return true;
            } else if ((field[x][0] == DOT_ZERO && field[x][1] == DOT_ZERO && field[x][2] == DOT_ZERO) ||
                    (field[0][x] == DOT_ZERO && field[1][x] == DOT_ZERO && field[2][x] == DOT_ZERO)
                    || (field[0][0] == DOT_ZERO && field[1][1] == DOT_ZERO && field[2][2] == DOT_ZERO) ||
                    (field[2][0] == DOT_ZERO && field[1][1] == DOT_ZERO && field[0][2] == DOT_ZERO)) {
                System.out.println("Компьютер победил!");
                return true;
            }
            else if (countFreeSpace == 0){
                System.out.println("Ничья");
                return true;
            }
        return false;
    }

    public static boolean isFieldFull(){
        for (int x = 0; x < 3; x++)
            for (int y = 0; y < 3; y++)
                if (field[x][y] == ".");
                return false;
    }

    //ответ компьютера
    public static void movePC(){
        Random random = new Random();
        boolean isNotFinishedMove = true;
        while (isNotFinishedMove){
            int x = random.nextInt(field.length);
            int y = random.nextInt(field.length);
            if (x >= 0 && x < 3 && y >= 0 && y < 3) {
                if (!field[x][y].equals("X") && !field[x][y].equals("O")) {
                    field[x][y] = "O";
                    isNotFinishedMove = false;
                }
            }
            System.out.println("Компьютер сделал ход");
        }
    }
}























