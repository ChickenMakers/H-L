public class Client_controller {
    Client_controller() {
        server = new Server();
    }
    public Server server;

    public void EnterClient(int numOfClients, String teamName) {
        Clients client = new Clients(numOfClients, teamName, this.server);
    }
}


