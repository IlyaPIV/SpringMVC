package my.springcourse.mvc.dao;

import my.springcourse.mvc.models.Person;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PersonMapper implements RowMapper<Person> {

    @Override
    public Person mapRow(ResultSet rs, int rowNum) throws SQLException {
        Person person = new Person();

        person.setId(rs.getInt("id"));
        person.setAge(rs.getInt("age"));
        person.setEmail(rs.getString("email"));
        person.setName(rs.getString("name"));

        return person;
    }
}
