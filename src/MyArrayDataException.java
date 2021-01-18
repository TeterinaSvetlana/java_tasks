public class MyArrayDataException extends NumberFormatException {

    private int row;
    private int column;

    public MyArrayDataException(String message, int row, int col) {
        super(message);
        this.row = row;
        this.column = col;
    }


}
