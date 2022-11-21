class Contact {
    protected String name;
    protected long phoneNumber;

    protected Contact(long phoneNumber, String name) {
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return "имя " + name + " телефон " + phoneNumber;
    }
}
