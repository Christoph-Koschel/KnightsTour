public class Main {
    public static void main(String[] args) {
        Field field = new Field();
        field.setValue(Vector2D.of(0, 0), (byte) 1);

        Turn turn = new Turn(Vector2D.of(0, 0), field, (byte) 2, "Root");
        turn.calcChildren();
    }
}
