package co.grandcircus.demo.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import co.grandcircus.jdbcintro.entity.Grade;

// Repository annotation allows spring to create a RoomsDao and use
// it with @Autowired in our controller
@Repository
public class GradesDao {

	@Autowired
	private JdbcTemplate jdbc;

	public List<Grade> findAll() {
		String sql = "SELECT * FROM grade";
		// .query returns a List
		// RowMapper converts the SLQ table results to Room objects, matching the field names
		return jdbc.query(sql, new BeanPropertyRowMapper<>(Grade.class));
	}

	public Grade findById(Long id) {
		// ? leaves a "blank" called a parameter to fill in later
		String sql = "SELECT * FROM grade WHERE id = ?";
		// .queryForObject returns a single object
		// the value(s) for ? params are specified at the end...
		return jdbc.queryForObject(sql, new BeanPropertyRowMapper<>(Grade.class), id);
	}

	public void create(Grade grade) {
		String sql = "INSERT INTO grade (name, type, score, total) VALUES (?, ?, ?,?)";
		// .update is used for any modification (INSERT, UPDATE, DELETE)
		// the value(s) for ? params are specified at the end...
		jdbc.update(sql, grade.getName(), grade.getType(), grade.getScore(),grade.getTotal());
	}

	public void update(Grade grade) {
		String sql = "UPDATE grade SET name = ?, type = ?, score = ?, total = ? WHERE id = ?";
		jdbc.update(sql, grade.getName(), grade.getType(),
				grade.getScore(), grade.getTotal(),grade.getId());
	}

	public void delete(Long id) {
		String sql = "DELETE FROM grade WHERE id = ?";
		jdbc.update(sql, id);
	}

}