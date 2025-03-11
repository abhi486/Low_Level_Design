class Tag {
    private final int id;
    private final String tagName;

    public Tag(String tagName) {
        id = Helpers.generateId();
        this.tagName = tagName;
    }

    public int getId() { return id; }
    public String getTag() { return tagName; }
}
