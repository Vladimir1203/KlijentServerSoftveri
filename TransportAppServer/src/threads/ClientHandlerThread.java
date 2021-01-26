package threads;

import controller.Controller;
import domain.IGeneralEntity;
import domain.Vehicle;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import transfer.RequestObject;
import transfer.ResponseObject;
import util.Operation;
import util.ResponseStatus;

/**
 *
 * @author stackOverflow
 */
public class ClientHandlerThread extends Thread{
    private Socket socket;
    private final ObjectInputStream in;
    private final ObjectOutputStream oos;

    public ClientHandlerThread(Socket socket) throws IOException{
        this.socket = socket;
        this.oos = new ObjectOutputStream(socket.getOutputStream());
        this.in = new ObjectInputStream(socket.getInputStream());        
    }

    public Socket getSocket() {
        return socket;
    }

    public void setSocket(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        RequestObject request;
        ResponseObject response = new ResponseObject();
        while (!socket.isClosed()) {
            try {
                request = receiveRequest();

                switch (request.getOperation()) {
                    case Operation.SAVE_VEHICLE:
                        response = saveVehicle(request);
                        break;
                    case Operation.LOGIN:
                        try{
                            IGeneralEntity objekat = Controller.getController().pronadjiKorisnika((IGeneralEntity)request.getData());           
                            response.setData(objekat);
                            response.setStatus(ResponseStatus.SUCCESS);
                            sendResponse(response);
                        }catch(Exception e){
                            response.setException(e);
                            response.setStatus(ResponseStatus.ERROR);
                            sendResponse(response);
                        }
                        
                        break;
                    
                        
                }
            } catch (IOException | ClassNotFoundException ex) {
                ex.printStackTrace();
            }
        }
    }

    public RequestObject receiveRequest() throws IOException, ClassNotFoundException {
        return (RequestObject) in.readObject();
    }
    
    public void sendResponse(ResponseObject ro) throws IOException{
        oos.writeObject(ro);
        oos.flush();
    }

    private ResponseObject saveVehicle(RequestObject request) {
        ResponseObject response = new ResponseObject();
        Vehicle vehicle = (Vehicle) request.getData();
        try{
        IGeneralEntity general = controller.Controller.getController().saveVehicle(vehicle);
        response.setData(general);
        }
        catch(Exception e){
            response.setException(e);
        }
        return response;
    }
}
