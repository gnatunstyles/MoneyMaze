import org.junit.Test;


import static org.junit.Assert.*;

public class MainTest {

    @Test
    public void checkN() {
        boolean firstActual = Main.checkN(5, 5);
        boolean firstExpected = true;
        assertEquals(firstExpected, firstActual);


        boolean secondActual = Main.checkN(4, 5);
        boolean secondExpected = false;
        assertEquals(secondExpected, secondActual);
    }

    @Test
    public void checkM() {
        boolean firstActual = Main.checkN(5, 5);
        boolean firstExpected = true;
        assertEquals(firstExpected, firstActual);


        boolean secondActual = Main.checkN(4, 5);
        boolean secondExpected = false;
        assertEquals(secondExpected, secondActual);
    }

    @Test
    public void checkIncorrectStart() {
        int n = 3;
        int m = 4;

        String fileName = "test-incorrect-start-1.txt";

        String file = FileReaderLocal.readFile(fileName);

        String[] lines = file.split("\n");

        n += n - 1;
        m += m - 1;

        Cell[][] cells = new Cell[n][m];

        for (int i = 0; i < n; i++) {
            String[] symbolsInLine = lines[i].split(" ");
            for (int j = 0; j < m; j++) {
                cells[i][j] = new Cell(symbolsInLine[j]);
            }
        }

        boolean firstActual = Main.checkIncorrectStart(cells);
        boolean firstExpected = false;

        assertEquals(firstExpected, firstActual);

        fileName = "test-incorrect-start-2.txt";

        file = FileReaderLocal.readFile(fileName);

        lines = file.split("\n");

        cells = new Cell[n][m];

        for (int i = 0; i < n; i++) {
            String[] symbolsInLine = lines[i].split(" ");
            for (int j = 0; j < m; j++) {
                cells[i][j] = new Cell(symbolsInLine[j]);
            }
        }

        boolean secondActual = Main.checkIncorrectStart(cells);
        boolean secondExpected = true;

        assertEquals(secondExpected, secondActual);
    }

    @Test
    public void checkIncorrectFinish() {
        int n = 3;
        int m = 4;

        String fileName = "test-incorrect-finish-1.txt";

        String file = FileReaderLocal.readFile(fileName);

        String[] lines = file.split("\n");

        n += n - 1;
        m += m - 1;

        Cell[][] cells = new Cell[n][m];

        for (int i = 0; i < n; i++) {
            String[] symbolsInLine = lines[i].split(" ");
            for (int j = 0; j < m; j++) {
                cells[i][j] = new Cell(symbolsInLine[j]);
            }
        }

        boolean firstActual = Main.checkIncorrectFinish(cells);
        boolean firstExpected = false;

        assertEquals(firstExpected, firstActual);

        fileName = "test-incorrect-finish-2.txt";

        file = FileReaderLocal.readFile(fileName);

        lines = file.split("\n");

        cells = new Cell[n][m];

        for (int i = 0; i < n; i++) {
            String[] symbolsInLine = lines[i].split(" ");
            for (int j = 0; j < m; j++) {
                cells[i][j] = new Cell(symbolsInLine[j]);
            }
        }

        boolean secondActual = Main.checkIncorrectFinish(cells);
        boolean secondExpected = true;

        assertEquals(secondExpected, secondActual);
    }

    @Test
    public void checkPathFinder() {
        int n = 3;
        int m = 4;

        String fileName = "test-incorrect-path-finder-1.txt";

        n += n - 1;
        m += m - 1;

        String file = FileReaderLocal.readFile(fileName);

        String[] lines = file.split("\n");

        Cell[][] cells = new Cell[n][m];

        for (int i = 0; i < n; i++) {
            String[] symbolsInLine = lines[i].split(" ");

            for (int j = 0; j < m; j++) {
                cells[i][j] = new Cell(symbolsInLine[j]);
            }
        }

        int iStart = -1, jStart = -1;

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

        boolean firstActual = Main.checkPathFinder(pathFinder);
        boolean firstExpected = false;

        assertEquals(firstExpected, firstActual);

        fileName = "test-incorrect-path-finder-2.txt";

        file = FileReaderLocal.readFile(fileName);

        lines = file.split("\n");

        cells = new Cell[n][m];

        for (int i = 0; i < n; i++) {
            String[] symbolsInLine = lines[i].split(" ");

            for (int j = 0; j < m; j++) {
                cells[i][j] = new Cell(symbolsInLine[j]);
            }
        }

        iStart = -1;
        jStart = -1;

        for (int i = 0; i < cells.length; i++) {
            for (int j = 0; j < cells[i].length; j++) {
                if (cells[i][j].isStart()) {
                    iStart = i;
                    jStart = j;
                }
            }
        }

        pathFinder = new PathFinder(n, m, cells);

        pathFinder.findPath(iStart, jStart, 0, "");

        boolean secondActual = Main.checkPathFinder(pathFinder);
        boolean secondExpected = true;

        assertEquals(secondExpected, secondActual);
    }
}
