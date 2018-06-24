package dataaccess;

import java.util.Date;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

	public static void main(String[] args) {
//		ApplicationContext context = new AnnotationConfigApplicationContext(SensorDataConfiguration.class);
//		
//		SensorDataDao sensorDataDao = context.getBean(SensorDataDao.class);
//		List<SensorData> sensorDataList = sensorDataDao.getAllSensorData();
//		sensorDataList.forEach(System.out::println);
//		
//		System.out.println("\nOnly one record:\n" + sensorDataDao.getSensorData(5) + "\n\n");
//		
//		sensorDataList = new ArrayList<>();
//		sensorDataList.add(new SensorData(11, new Date(), 42.5, 72.35));
//		sensorDataList.add(new SensorData(12, new Date(), 32.2, 63.51));
//		sensorDataList.add(new SensorData(13, new Date(), 27.8, 52.4));
//		
//		sensorDataDao.insert(sensorDataList);
//		
//		sensorDataList = sensorDataDao.getAllSensorData();
//		sensorDataList.forEach(System.out::println);
//		
//		System.out.println("\nNumber of records in database: " + sensorDataDao.countRecord() + "\n");
//		
//		System.out.println("The temperature of 7th record is: " + sensorDataDao.selectTemp(7));
		
		ApplicationContext context = new AnnotationConfigApplicationContext(SensorDataConfiguration2.class);
		
		SensorDataDao2 sensorDataDao2 = context.getBean(SensorDataDao2.class);
		List<SensorData2> sensorData2List = sensorDataDao2.getAllSensorData();
		
		sensorData2List.forEach(System.out::println);
		
		System.out.println("\nOnly one record:\n" + sensorDataDao2.getSensorData(5) + "\n\n");
		
		SensorData2 sensorData2 = new SensorData2();
		sensorData2.setDate(new Date());
		sensorData2.setTemperature(42.5);
		sensorData2.setHumidity(72.35);
		
		sensorDataDao2.store(sensorData2);
		
		sensorData2List = sensorDataDao2.getAllSensorData();
		sensorData2List.forEach(System.out::println);
		
		System.out.println("\nThe 6th temperature is: " + String.format("%.2f", sensorDataDao2.getTemperature(6)));
		
		((AnnotationConfigApplicationContext)context).close();
	}
}
