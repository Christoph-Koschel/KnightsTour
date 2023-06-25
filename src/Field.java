public class Field {
    private final byte[][] field;

    public Field() {
        field = new byte[Settings.FIELD_SIZE][Settings.FIELD_SIZE];
    }

    private Field(byte[][] field) {
        this.field = field;
    }

    public void setValue(Vector2D<Integer> pos, byte value) {
        field[pos.x][pos.y] = value;
    }

    public boolean canJump(Vector2D<Integer> pos) {
        return pos.x >= 0 && pos.x < Settings.FIELD_SIZE && pos.y >= 0 && pos.y < Settings.FIELD_SIZE && this.field[pos.x][pos.y] == 0;
    }

    public boolean isComplete() {
        for (int i = 0; i < Settings.FIELD_SIZE; i++) {
            for (int k = 0; k < Settings.FIELD_SIZE; k++) {
                if (field[i][k] == 0) {
                    return false;
                }
            }
        }

        return true;
    }

    public Field copy() {
        byte[][] cpy = new byte[Settings.FIELD_SIZE][Settings.FIELD_SIZE];

        for (int i = 0; i < Settings.FIELD_SIZE; i++) {
            System.arraycopy(field[i], 0, cpy[i], 0, Settings.FIELD_SIZE);
        }

        return new Field(cpy);
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();

        for (int i = 0; i < Settings.FIELD_SIZE; i++) {
            for (int k = 0; k < Settings.FIELD_SIZE; k++) {
                builder.append(String.format("%-2s", field[i][k])).append(" ");
            }
            builder.append("\n");
        }

        return builder.toString();
    }
}
