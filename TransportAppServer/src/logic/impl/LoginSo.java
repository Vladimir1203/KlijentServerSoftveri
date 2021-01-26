/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic.impl;

import domain.IGeneralEntity;
import domain.User;
import logic.SystemOperation;

/**
 *
 * @author stackOverflow
 */
public class LoginSo extends SystemOperation{

    IGeneralEntity objekat;
    
    public LoginSo() {
    }

    
    public LoginSo(User user) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected void operation() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public IGeneralEntity getObjekat() {
        return objekat;
    }
    
    
    
}
