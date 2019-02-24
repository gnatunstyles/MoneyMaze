import java.util.Scanner;

public class Main {

    static boolean checkN(int n, int length) {
        return n == length;
    }

    static boolean checkM(int m, int length) {
        return m == length;
    }

    static boolean checkIncorrectStart(Cell[][] cells) {
        boolean foundStart = false;

        for (Cell[] cell : cells) {
            for (Cell cell1 : cell) {
                if (cell1.isStart()) {
                    if (foundStart) {
                        System.err.println("Start more one");
                        return true;
                    }

                    foundStart = true;
                }
            }
        }

        if (!foundStart) {
            System.err.println("Start not found");
            return true;
        }

        return false;
    }

    static boolean checkIncorrectFinish(Cell[][] cells) {
        boolean foundFinish = false;

        for (Cell[] cell : cells) {
            for (Cell cell1 : cell) {
                if (cell1.isFinish()) {
                    if (foundFinish) {
                        System.err.println("Incorrect input");
                        return true;
                    }

                    foundFinish = true;
                }
            }
        }

        if (!foundFinish) {
            System.err.println("Finish not found");
            return true;
        }

        return false;
    }

    static boolean checkPathFinder(PathFinder pathFinder) {
        if (pathFinder.getPath().equals("")) {
            System.err.println("Deadlock");
            return true;
        }

        return false;
    }

    public static void main(String[] args) {
        int n = 3;
        int m = 4;

        Scanner in = new Scanner(System.in);

        System.out.print("Input a name of file: ");
        String fileName = in.nextLine();

        String file = FileReaderLocal.readFile(fileName);

        n += n - 1;
        m += m - 1;

        String[] lines = file.split("\n");

        if (!checkN(n, lines.length)) {
            System.err.println("N is incorrect");
            return;
        }

        Cell[][] cells = new Cell[n][m];

        for (int i = 0; i < n; i++) {
            String[] symbolsInLine = lines[i].split(" ");

            if (!checkM(m, symbolsInLine.length)) {
                System.err.println("M is incorrect");
                return;
            }

            for (int j = 0; j < m; j++) {
                cells[i][j] = new Cell(symbolsInLine[j]);
            }
        }

//        Debug

//        for (int i = 0; i < n; i++) {
//            for (int j = 0; j < m; j++) {
//                System.out.println(i + " " + j);
//                System.out.println(cells[i][j]);
//            }
//        }

        int iStart = -1, jStart = -1;

        if (checkIncorrectStart(cells) || checkIncorrectFinish(cells)) {
            return;
        }

        for (int i = 0; i < cells.length; i++) {
            for (int j = 0; j < cells[i].length; j++) {
                if (cells[i][j].isStart()) {
                    iStart = i;
                    jStart = j;
                }
            }
        }

        PathFinder pathFinder = new PathFinder(n, m, cells);

        pathFinder.findPath(iStart, jStart, 0, "");

        if (checkPathFinder(pathFinder)) {
            return;
        }

        System.out.println("Money: " + pathFinder.getMoney());
        System.out.println("Path: " + pathFinder.getPath());
    }
}
