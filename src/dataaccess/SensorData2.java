package dataaccess;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "sensordata")
public class SensorData2 {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	
	@Column(name = "date", nullable = false)
	private Date date;
	
	@Column(name = "temperature", nullable = false)
	private Double temperature;
	
	@Column(name = "humidity", nullable = false)
	private Double humidity;
	
	public SensorData2() {
	}

	public SensorData2(Integer id, Date date, Double temperature, Double humidity) {
		this.id = id;
		this.date = date;
		this.temperature = temperature;
		this.humidity = humidity;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public void setTemperature(Double temperature) {
		this.temperature = temperature;
	}

	public void setHumidity(Double humidity) {
		this.humidity = humidity;
	}

	public Integer getId() {
		return id;
	}

	public Date getDate() {
		return date;
	}

	public Double getTemperature() {
		return temperature;
	}

	public Double getHumidity() {
		return humidity;
	}
	
	@Override
	public String toString() {
		return "index: " + this.id + 
				"\tdate: " + this.date.toString() +
				"\ttemperature: " + String.format("%.2f", this.temperature) + " C°" +
				"\thumidity: " + String.format("%.2f", this.humidity) + " %";
	}
}