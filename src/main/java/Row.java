public enum Row {
    UP(0),
    MIDDLE(1),
    DOWN(2);

    private final int index;

    private Row(int index) {
        this.index = index;
    }

    public int getIndex() {
        return index;
    }
}
