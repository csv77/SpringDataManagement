package dataaccess;

import java.util.Collection;
import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcDaoSupport;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;

public class SensorDataDaoImpl extends NamedParameterJdbcDaoSupport implements SensorDataDao {
	private static final String SELECT_ALL = "SELECT * FROM SENSORDATA";
	private static final String SELECT_ONE_RECORD = "SELECT * FROM SENSORDATA WHERE ID = ?";
	private static final String INSERT_SQL = "INSERT INTO SENSORDATA VALUES (:id, :date, :temperature, :humidity)";
	private static final String COUNT_RECORD = "SELECT COUNT(*) FROM SENSORDATA";
	private static final String SELECT_TEMP = "SELECT TEMPERATURE FROM SENSORDATA WHERE ID = ?";
	
//	private void prepareStatement(PreparedStatement ps, SensorData sensorData) throws SQLException {
//        ps.setInt(1, sensorData.getId());
//        ps.setTimestamp(2, new Timestamp(new Date().getTime()));
//        ps.setDouble(3, sensorData.getTemperature());
//        ps.setDouble(4, sensorData.getHumidity());
//    } 

	@Override
	public List<SensorData> getAllSensorData() {
		return getJdbcTemplate().query(SELECT_ALL, BeanPropertyRowMapper.newInstance(SensorData.class));
	}

	@Override
	public SensorData getSensorData(Integer id) {
		return getJdbcTemplate().queryForObject(SELECT_ONE_RECORD, BeanPropertyRowMapper.newInstance(SensorData.class), id);
	}

	@Override
	public void insert(Collection<SensorData> listOfData) {
		SqlParameterSource[] sources = listOfData.stream()
				.map(l -> new BeanPropertySqlParameterSource(l))
				.toArray(size -> new SqlParameterSource[size]);
		getNamedParameterJdbcTemplate().batchUpdate(INSERT_SQL, sources);
	}

	@Override
	public int countRecord() {
		return getJdbcTemplate().queryForObject(COUNT_RECORD, Integer.class);
	}

	@Override
	public double selectTemp(Integer id) {
		return getJdbcTemplate().queryForObject(SELECT_TEMP, Double.class, id);
	}
}