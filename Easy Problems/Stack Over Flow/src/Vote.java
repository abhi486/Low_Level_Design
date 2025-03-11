class Vote {
    private final User user;
    private final int value;

    public Vote(User user, int value) {
        this.user = user;
        this.value = value;
    }

    User getUser() { return user; }
    int getValue() { return value; }
}
