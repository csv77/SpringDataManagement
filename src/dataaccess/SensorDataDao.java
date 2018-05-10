package dataaccess;

import java.util.List;

public interface SensorDataDao {
	
	public List<SensorData> getAllSensorData();
	
	public SensorData getSensorData(Integer id);
}
