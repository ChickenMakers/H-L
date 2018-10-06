public class Seats {
    private int N = 4;
    private Clients Seats_structure[][] = null;

    void  Seats(int N) {
        this.N = N;
        this.makeMatrix(this.N);
    }
    void  Seats() {
        this.makeMatrix(this.N);
    }

    private void makeMatrix(int N) {
        this.Seats_structure = new Clients[N][N];
        this.initMatrix();
    }

    private void initMatrix() {
        for (int row = 0; row < ; row++) {
            for (int col = 0; col < ; col++) {
                this.Seats_structure[row][col] = null;
            }
        }
    }
    public Clients[][] getSeatState() {
        Clients[][] Seats_copy = new Clients[this.N][this.N];
        for (int row = 0; row < ; row++) {
            for (int col = 0; col < ; col++) {
                Seats_copy[row][col] = this.Seats_structure[row][col];
            }
        }
        return Seats_copy;
    }
    public int getTableCount() {
        return this.N * this.N;
    }

}
