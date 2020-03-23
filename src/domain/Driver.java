package domain;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author stackOverflow
 */

public class Driver implements IGeneralEntity{
    private int IDCard;
    private String name;
    private String surname; //ke

    public Driver() {
    }  
    
    public Driver(int IDCard, String name, String surname) {
        this.IDCard = IDCard;
        this.name = name;
        this.surname = surname;
    }

    public int getIDCard() {
        return IDCard;
    }

    public void setIDCard(int IDCard) {
        this.IDCard = IDCard;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    @Override
    public String getTableName() {
        return "driver";
    }

    @Override
    public List<IGeneralEntity> getList(ResultSet resultSet) throws Exception {
        List<IGeneralEntity> list = new ArrayList<>();
        while (resultSet.next()) {
            int id = resultSet.getInt("idcard");
            String name = resultSet.getString("name");
            String surname = resultSet.getString("surname");
            
            list.add(new Driver(IDCard,name,surname));
        }
        return list;
    }

    @Override
    public String getValues() {
         return IDCard + ", '" + name + "', '"+ surname + "'";
    }

    @Override
    public String getAttributes() {
        return "IDCard, name, surname";
    }

    @Override
    public String setAttributes() {
        return "IDCard=" + IDCard + ", name='" + name + ",surname='"+ surname + "'";
    }

    @Override
    public String getDeleteCondition() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getUpdateCondition() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getSelectContidion() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    
    
}
