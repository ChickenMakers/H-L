public class Seats {
    private int N = 4;
    private Clients Seats_structure[][] = null;

    Seats(int N) {
        this.N = N;
        this.makeMatrix(this.N);
    }
    Seats() {
        this.makeMatrix(this.N);
    }

    private void makeMatrix(int N) {
        this.Seats_structure = new Clients[N][N];
        this.initMatrix();
    }

    private void initMatrix() {
        for (int row = 0; row < this.N; row++) {
            for (int col = 0; col < this.N; col++) {
                this.Seats_structure[row][col] = null;
            }
        }
    }
    public Clients[][] getSeatState() {
//        Clients[][] Seats_copy = new Clients[this.N][this.N];
//        for (int row = 0; row < this.N; row++) {
//            for (int col = 0; col < this.N; col++) {
//                Seats_copy[row][col] = this.Seats_structure[row][col];
//            }
//        }
//        return Seats_copy;
        return this.Seats_structure;
    }
    public void cleanTable(int row , int col){
        this.Seats_structure[row][col] = null;
    }
    public int getN(){
        return this.N;
    }
    public int getTableCount() {
        return this.N * this.N;
    }
    public boolean isNullElement(int row, int col) {
        return this.Seats_structure[row][col] == null;
    }
}
