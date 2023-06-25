import java.util.Date;

public class Turn {
    public static boolean enableProcessOutput = Settings.ENABLE_PROCESS_OUTPUT;

    public static int threads = 0;


    public static int nodeCounter = 0;
    public static long startTime = new Date().getTime();

    public static boolean oneComplete = false;

    private final Vector2D<Integer> pos;
    private final Field field;
    private final Turn[] turns;

    private byte turnsSize;
    private final byte counter;
    private final String path;
    private final int id;

    public Turn(Vector2D<Integer> pos, Field field, byte counter, String path) {
        this.pos = pos;
        this.field = field;
        this.counter = counter;
        this.path = path;
        this.id = nodeCounter++;
        turns = new Turn[8];
        turnsSize = 0;
    }

    public void calcChildren() {
        if (enableProcessOutput) {
            System.out.printf("Calculate Node{%s}%n", id);
        }

        if (field.canJump(Vector2D.of(pos.x + 2, pos.y + 1))) {
            cnstrNext(Vector2D.of(pos.x + 2, pos.y + 1), 1);
        }
        if (field.canJump(Vector2D.of(pos.x + 2, pos.y - 1))) {
            cnstrNext(Vector2D.of(pos.x + 2, pos.y - 1), 2);
        }
        if (field.canJump(Vector2D.of(pos.x - 2, pos.y + 1))) {
            cnstrNext(Vector2D.of(pos.x - 2, pos.y + 1), 3);
        }
        if (field.canJump(Vector2D.of(pos.x - 2, pos.y - 1))) {
            cnstrNext(Vector2D.of(pos.x - 2, pos.y - 1), 4);
        }

        if (field.canJump(Vector2D.of(pos.x + 1, pos.y + 2))) {
            cnstrNext(Vector2D.of(pos.x + 1, pos.y + 2), 5);
        }
        if (field.canJump(Vector2D.of(pos.x + 1, pos.y - 2))) {
            cnstrNext(Vector2D.of(pos.x + 1, pos.y - 2), 6);
        }
        if (field.canJump(Vector2D.of(pos.x - 1, pos.y + 2))) {
            cnstrNext(Vector2D.of(pos.x - 1, pos.y + 2), 7);
        }
        if (field.canJump(Vector2D.of(pos.x - 1, pos.y - 2))) {
            cnstrNext(Vector2D.of(pos.x - 1, pos.y - 2), 8);
        }

        for (int i = 0; i < turnsSize; i++) {
            if (turns[i].field.isComplete()) {
                if (oneComplete) {
                    Thread.currentThread().interrupt();
                    return;
                }
                oneComplete = true;

                long endTime = new Date().getTime();

                enableProcessOutput = false;

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("Finished calculation");
                System.out.println("========================================");
                System.out.printf("%-18s : %-10s%n", "Time", (endTime - startTime) + "ms");
                System.out.printf("%-18s : %-10s%n", "Finish NodeID", id);
                System.out.printf("%-18s :%n", "Field");
                System.out.println(turns[i].field.toString());
                System.out.printf("%-18s : %s%n", "Algo Tree path", path);
                System.exit(0);
            }
        }

        for (int i = 0; i < turnsSize; i++) {

            turns[i].calcChildren();
            if (enableProcessOutput) {
                System.out.printf("Destroy Node{%s}%n", id);
            }
            turns[i] = null;
        }
    }

    private void cnstrNext(Vector2D<Integer> pos, int nodeID) {
        Field field = this.field.copy();
        field.setValue(pos, counter);

        final Turn turn = new Turn(pos, field, (byte) (counter + 1), path + ">" + nodeID);

        if (threads + 1 < Settings.MAX_THREADS) {
            threads++;

            new Thread(() -> {
                turn.calcChildren();
                threads--;
            }).start();
        } else {
            turns[turnsSize++] = turn;
        }
    }
}
