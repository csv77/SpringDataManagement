package dataaccess;

import java.util.Date;

public class SensorData {
	private Integer id;
	private Date date;
	private Double temperature;
	private Double humidity;
	
	public SensorData() {
	}

	public SensorData(Integer id, Date date, Double temperature, Double humidity) {
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
