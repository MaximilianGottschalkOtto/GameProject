public class Server {

    public static void main(String[] args) {
        System.out.println("!MEIN QUIZ GAME!");
        SocketServer socketServer = new SocketServer();
        socketServer.runServer();
    }


}
