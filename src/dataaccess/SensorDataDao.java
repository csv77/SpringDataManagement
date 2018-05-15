package dataaccess;

import java.util.Collection;
import java.util.List;

public interface SensorDataDao {
	
	public void insert(Collection<SensorData> listOfData);
	
	public List<SensorData> getAllSensorData();
	
	public SensorData getSensorData(Integer id);
	
	public int countRecord();
	
	public double selectTemp(Integer id);
}
