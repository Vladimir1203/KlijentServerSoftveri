package controller;

import domain.User;
import domain.Vehicle;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import sesija.Sesija;
import transfer.RequestObject;
import transfer.ResponseObject;
import util.Operation;
import util.ResponseStatus;

public class CommunicationController {
    private static CommunicationController instance;
    private Socket socket;

    private CommunicationController() throws IOException {
        socket = new Socket("localhost", 9000);
        ObjectOutputStream outSocket = new ObjectOutputStream(socket.getOutputStream());
        ObjectInputStream inSocket = new ObjectInputStream(socket.getInputStream());
        Sesija.getSesija().setSocket(socket);
        Sesija.getSesija().setOos(outSocket);
        Sesija.getSesija().setOis(inSocket);
        System.out.println("Klijent se povezao");
    }
    
    public static CommunicationController getInstance() throws IOException {
        if(instance == null)
            instance = new CommunicationController();
        return instance;
    }

    public static void setInstance(CommunicationController aInstance) {
        instance = aInstance;
    }


    public CommunicationController(Socket socket) {
        this.socket = socket;
    }

    public Socket getSocket() {
        return socket;
    }

    public void setSocket(Socket socket) {
        this.socket = socket;
    }

    private void sendRequest(RequestObject request) throws IOException {
        Sesija.getSesija().getOos().writeObject(request);
    }
    
        private ResponseObject receiveResponse() throws IOException, ClassNotFoundException {
        ResponseObject response = (ResponseObject) Sesija.getSesija().getOis().readObject();
        return response;
    }

    
    public Object saveVehicle(Vehicle v) throws IOException, ClassNotFoundException, Exception {
        RequestObject request = new RequestObject();
        request.setData(v);
        request.setOperation(Operation.SAVE_VEHICLE);
        sendRequest(request);
        ResponseObject response = receiveResponse();
        if (response.getException() != null) {
            throw response.getException();
        }
        return (Vehicle) response.getData();
        
    }

       public User login(User user) throws Exception{
        RequestObject request = new RequestObject();
        request.setData(user);
        request.setOperation(Operation.LOGIN);
        sendRequest(request);
        ResponseObject response = receiveResponse();
        System.out.println(response.getStatus() + " " + response.getData());
        if(response.getStatus() == ResponseStatus.SUCCESS){
            System.out.println("Usao u SUCCESS");
            return (User)response.getData();
        }else{
            System.out.println("Usao u ERROR");
            throw response.getException();
        }
        
    }
 
    
}