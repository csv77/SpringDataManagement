package dataaccess;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

public class SensorDataDaoImpl implements SensorDataDao {
	private static final String SELECT_ALL = "select * from sensordata";
//	private static final String SELECT_ONE_RECORD = "select * from sensordata where id = ?";
	
	private final DataSource dataSource;
	
	public SensorDataDaoImpl(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	@Override
	public List<SensorData> getAllSensorData() {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		return jdbcTemplate.query(SELECT_ALL, BeanPropertyRowMapper.newInstance(SensorData.class));
	}

	@Override
	public SensorData getSensorData(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

}
