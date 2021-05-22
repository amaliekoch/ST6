package ST6.handler;
import java.sql.ResultSet;
import java.sql.SQLException;

import ST6.controller.QuestionnaireCtrl;
import ST6.database.*;
import ST6.model.*;
import ST6.model.PatientProfileModel;


public class PatientProfileInsertHandler implements Queryable {

    @Override
    public void processResultSet(ResultSet rs) throws SQLException {
        while(rs.next()){
        }
    }

      // kommandoen til SQL databasen 
      @Override
      public String returnSqlQuery() {
          //String sqlStatement = "SELECT * FROM `PInfo` WHERE `cprNumber` = 1304081203"; // CPR-nummer fra databasen er her tastet manuelt. 
         String sqlStatement = "INSERT INTO `PInfo` (`cprNumber`,`name`,`gender`,`age`); VALUES (" +QuestionnaireCtrl.nyPatient.getCprNumber()+","+QuestionnaireCtrl.nyPatient.getName()+","+QuestionnaireCtrl.nyPatient.getGender()+","+QuestionnaireCtrl.nyPatient.getAge()+")"; 
          return sqlStatement;
      }
}
