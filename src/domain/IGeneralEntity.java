package domain;

import java.io.Serializable;
import java.sql.ResultSet;
import java.util.List;

/**
 *
 * @author Vladimir1203
 */
public interface IGeneralEntity extends Serializable{
    
    public String getTableName();

    public List<IGeneralEntity> getList(ResultSet resultSet) throws Exception;

    public String getValues();

    public String getAttributes();

    public String setAttributes();

    public String getDeleteCondition();
    
    public String getUpdateCondition();
    
     public String getSelectContidion();
}
