package dataaccess;

import java.util.List;

public interface SensorDataDao2 {
	public SensorData2 store(SensorData2 sensorData2);
	
	public void delete(Integer id);
	
	public SensorData2 getSensorData(Integer id);
	
	public List<SensorData2> getAllSensorData();
	
	public Double getTemperature(Integer id);
}
