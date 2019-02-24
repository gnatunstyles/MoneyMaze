public class PathFinder {
    private int money;
    private String path;
    private int n, m;
    private Cell[][] cells;

    PathFinder(int n, int m, Cell[][] cells) {
        this.money = 0;
        this.path = "";

        this.n = n;
        this.m = m;

        this.cells = cells;
    }

    public int getMoney() {
        return money;
    }

    public String getPath() {
        return path;
    }

    void findPath(int i, int j, int currentMoney, String currentPath) {
//        Debug

//        System.out.println(currentPath);
//        System.out.println("I: " + i + "; " + "J: " + j);

        // проверяем если переданная ячейка число то прибовляем деньги
        if (cells[i][j].isNumber()) {
            currentMoney += cells[i][j].getMoney();
        }

        // у нас класс PF хранит две переменных money и path
        // это типо финальные значения
        if (cells[i][j].isFinish()) {
            // проверяем если путь пустой (ну первый найденый путь),
            // на тот случай если денег отрицательное колличество
            if (this.path.equals("")) {
                // записываем деньги и путь в PF и выходим из рекурсии
                this.money = currentMoney;
                this.path = currentPath;

                return;
            } else {
                // если у нас не первый путь и
                // если денег больше то записываем деньги и путь и выходим из рекурсии
                if (currentMoney > this.money) {
                    this.money = currentMoney;
                    this.path = currentPath;

                    return;
                }
            }
        }

        this.cells[i][j].setiWasHere(true); // ставим отметку что мы были тут

        // здесь проверяем можем ли мы пойти вверх вправо вниз влево
//      // если да то вызываем findPath но уже с той ячейкой в которую перешли

        if ((i - 2 >= 0) && this.cells[i - 1][j].isOpen() && !this.cells[i - 2][j].isiWasHere()) {
            findPath(i - 2, j, currentMoney, currentPath + "Up ");
        }

        if ((j + 2 <= m) && this.cells[i][j + 1].isOpen() && !this.cells[i][j + 2].isiWasHere()) {
            findPath(i, j + 2, currentMoney, currentPath + "Right ");
        }

        if ((i + 2 <= n) && this.cells[i + 1][j].isOpen() && !this.cells[i + 2][j].isiWasHere()) {
            findPath(i + 2, j, currentMoney, currentPath + "Down ");
        }

        if ((j - 2 >= 0) && this.cells[i][j - 1].isOpen() && !this.cells[i][j - 2].isiWasHere()) {
            findPath(i, j - 2, currentMoney, currentPath + "Left ");
        }

        this.cells[i][j].setiWasHere(false); // снимаем флаг так как мы можем опять попасть на эту ячейку но другим путём
    }
}
