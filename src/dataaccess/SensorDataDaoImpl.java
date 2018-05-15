package dataaccess;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

public class SensorDataDaoImpl implements SensorDataDao {
	private static final String SELECT_ALL = "SELECT * FROM SENSORDATA";
	private static final String SELECT_ONE_RECORD = "SELECT * FROM SENSORDATA WHERE ID = ?";
	private static final String INSERT_SQL = "INSERT INTO SENSORDATA VALUES (?, ?, ?, ?)";
	private static final String COUNT_RECORD = "SELECT COUNT(*) FROM SENSORDATA";
	private static final String SELECT_TEMP = "SELECT TEMPERATURE FROM SENSORDATA WHERE ID = ?";
	
	private final JdbcTemplate jdbcTemplate;
	
	public SensorDataDaoImpl(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	private void prepareStatement(PreparedStatement ps, SensorData sensorData) throws SQLException {
        ps.setInt(1, sensorData.getId());
        ps.setTimestamp(2, new Timestamp(new Date().getTime()));
        ps.setDouble(3, sensorData.getTemperature());
        ps.setDouble(4, sensorData.getHumidity());
    } 

	@Override
	public List<SensorData> getAllSensorData() {
		return jdbcTemplate.query(SELECT_ALL, BeanPropertyRowMapper.newInstance(SensorData.class));
	}

	@Override
	public SensorData getSensorData(Integer id) {
		return jdbcTemplate.queryForObject(SELECT_ONE_RECORD, BeanPropertyRowMapper.newInstance(SensorData.class), id);
	}

	@Override
	public void insert(Collection<SensorData> listOfData) {
		jdbcTemplate.batchUpdate(INSERT_SQL, listOfData, listOfData.size(), this::prepareStatement);
	}

	@Override
	public int countRecord() {
		return jdbcTemplate.queryForObject(COUNT_RECORD, Integer.class);
	}

	@Override
	public double selectTemp(Integer id) {
		return jdbcTemplate.queryForObject(SELECT_TEMP, Double.class, id);
	}
}
