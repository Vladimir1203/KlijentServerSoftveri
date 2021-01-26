/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

import database.impl.DatabaseBroker;
import domain.IGeneralEntity;
import java.util.LinkedList;
import java.util.Map;
import validation.Validator;

/**
 *
 * @author Pocerc
 */
public abstract class SystemOperation {
    protected Validator validator;
    protected DatabaseBroker dbbr;
    protected IGeneralEntity odo;
    protected LinkedList<IGeneralEntity> lista;
    protected boolean ret;
    protected Map<String,Object> mapa;

    public SystemOperation() {
        dbbr=new DatabaseBroker();
    }

    public boolean isRet() {
        return ret;
    }

    public void setRet(boolean ret) {
        this.ret = ret;
    }
    
    
    
    protected void checkPreconditions() throws Exception{
        if(validator!=null){
            validator.validate(odo);
        }
    }
    
    protected void connectStorage() throws Exception{
        //getDbbr().connect();
    }
    
    protected void disconnectStorage() throws Exception{
       // getDbbr().disconnect();
    }
    
    protected abstract void operation()throws Exception;
    
    public void execute() throws Exception{
        connectStorage();
        checkPreconditions();
        try {
            operation();
            //getDbbr().commit();
        } catch (Exception ex) {
            //getDbbr().rollback();
            throw ex;
        }finally{
            disconnectStorage();
        }
    }

   /* public IGeneralEntity getDomainObject() {
        return getOdo();
    }*/

    /**
     * @return the dbbr
     */
   /* public IGeneralEntity getDbbr() {
       // return dbbr;
    }
   */
    
    /**
     * @param dbbr the dbbr to set
     */
    public void setDbbr(IGeneralEntity dbbr) {
        //this.dbbr = dbbr;
    }

    public void execute(IGeneralEntity iGeneralEntity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * @return the odo
     */
    /*public DomainObject getOdo() {
        return odo;
    }//*/

    /**
     * @param odo the odo to set
     */
   /* public void setOdo(DomainObject odo) {
        this.odo = odo;
    }

    public LinkedList<DomainObject> getLista() {
        return lista;
    }

    public void setLista(LinkedList<DomainObject> lista) {
        this.lista = lista;
    }*/
}
