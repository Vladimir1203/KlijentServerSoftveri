/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package transfer;

import java.io.Serializable;
import util.ResponseStatus;

/**
 *
 * @author student1
 */
public class ResponseObject implements Serializable{
    private Object data;
    private Exception exception;
    private ResponseStatus status;

    public ResponseObject(Object data, Exception exception, ResponseStatus status) {
        this.data = data;
        this.exception = exception;
        this.status = status;
    }
    

    public ResponseObject() {
    }

    public ResponseObject(Object data, Exception exception) {
        this.data = data;
        this.exception = exception;
    }

    public Exception getException() {
        return exception;
    }

    public void setException(Exception exception) {
        this.exception = exception;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public ResponseStatus getStatus() {
        return status;
    }

    public void setStatus(ResponseStatus status) {
        this.status = status;
    }
    
    
}
