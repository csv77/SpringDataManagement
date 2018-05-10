package dataaccess;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext(SensorDataConfiguration.class);
		
		SensorDataDao sensorDataDao = context.getBean(SensorDataDao.class);
		List<SensorData> sensorDataList = sensorDataDao.getAllSensorData();
		sensorDataList.forEach(System.out::println);
		
		((AnnotationConfigApplicationContext)context).close();
	}
}
