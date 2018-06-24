package dataaccess;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class SensorDataDao2Impl implements SensorDataDao2 {
	
	private final SessionFactory sessionFactory;
	
	public SensorDataDao2Impl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Transactional
	public SensorData2 store(SensorData2 sensorData2) {
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(sensorData2);
		return sensorData2;
	}

	@Transactional
	public void delete(Integer id) {
		Session session = sessionFactory.getCurrentSession();
		SensorData2 sensorData2 = session.get(SensorData2.class, id);
		session.delete(sensorData2);
	}

	@Transactional
	public SensorData2 getSensorData(Integer id) {
		Session session = sessionFactory.getCurrentSession();
		return session.get(SensorData2.class, id);
	}

	@Transactional
	public List<SensorData2> getAllSensorData() {
		Session session = sessionFactory.getCurrentSession();
		return session.createQuery("from SensorData2", SensorData2.class).list();
	}

	@Transactional
	public Double getTemperature(Integer id) {
		Session session = sessionFactory.getCurrentSession();
		return session.createQuery("select temperature from SensorData2 S where S.id = " + id, Double.class).getSingleResult();
	}
}
