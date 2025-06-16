package DiningPhilospher;

class Chopstick {
    private final int id;

    public Chopstick(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Chopstick-" + id;
    }
}
