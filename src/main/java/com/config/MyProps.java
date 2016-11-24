package com.config;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "myProps")
public class MyProps {
	
	private String simpleProp;
	private String[] arrayProps;
	private List<Map<String, String>> listProp1 = new ArrayList<>(); 
	private List<String> listProp2 = new ArrayList<>(); 
	private Map<String, String> mapProps = new HashMap<>();

	public String getSimpleProp() {
		return simpleProp;
	}

	public void setSimpleProp(String simpleProp) {
		this.simpleProp = simpleProp;
	}

	public List<Map<String, String>> getListProp1() {
		return listProp1;
	}

	public List<String> getListProp2() {
		return listProp2;
	}

	public String[] getArrayProps() {
		return arrayProps;
	}

	public void setArrayProps(String[] arrayProps) {
		this.arrayProps = arrayProps;
	}

	public Map<String, String> getMapProps() {
		return mapProps;
	}

	public void setMapProps(Map<String, String> mapProps) {
		this.mapProps = mapProps;
	}
}
