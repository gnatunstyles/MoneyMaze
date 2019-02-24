public class Cell {
    private boolean isNumber;
    private boolean isOpen;
    private boolean isStart;
    private boolean isFinish;
    private boolean iWasHere;

    private int money;

    Cell(String symbol) {
        this.iWasHere = false;
        this.isFinish = false;
        this.isStart = false;
        this.isNumber = false;
        this.isOpen = false;

        switch (symbol) {
            case "o":
                this.isOpen = true;
                break;
            case "w":
                this.isOpen = false;
                break;
            case "F":
                this.isFinish = true;
                break;
            case "S":
                this.isStart = true;
                break;
            default:
                this.isNumber = true;
                this.money = Integer.parseInt(symbol);
        }
    }

    public boolean isNumber() {
        return isNumber;
    }

    public boolean isOpen() {
        return isOpen;
    }

    public int getMoney() {
        return money;
    }

    public boolean isiWasHere() {
        return iWasHere;
    }

    public boolean isStart() {
        return isStart;
    }

    public boolean isFinish() {
        return isFinish;
    }

    public void setiWasHere(boolean iWasHere) {
        this.iWasHere = iWasHere;
    }

    @Override
    public String toString() {
        if (isNumber) {
            return "Money: " + money;
        } else {
            if (isStart) {
                return "Is start";
            }
            if (isFinish) {
                return "Is finish";
            }
            return "isOpen: " + isOpen;
        }
    }
}
