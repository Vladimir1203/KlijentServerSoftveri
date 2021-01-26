/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import domain.IGeneralEntity;
import java.util.List;

/**
 *
 * @author stackOverflow
 */
public interface IDatabaseBroker {
    
    int sacuvaj(IGeneralEntity entity) throws Exception;
    void obrisi(IGeneralEntity entity) throws Exception;
    void izmeni(IGeneralEntity entity) throws Exception;
    List<IGeneralEntity> vratiPoUslovu(IGeneralEntity entity) throws Exception;
    IGeneralEntity vratiPoId(IGeneralEntity entity) throws Exception;
    List<IGeneralEntity> vratiSve(IGeneralEntity entity) throws Exception;
    
}
