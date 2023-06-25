public class Vector2D<T> {
    public final T x;
    public final T y;

    public Vector2D(T x, T y) {

        this.x = x;
        this.y = y;
    }

    public static <T> Vector2D<T> of(T x, T y) {
        return new Vector2D<T>(x, y);
    }
}
