package api.demo.APIDemo.model;

import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown=true)
public class Result {
	
	private int count;
	private String next;
	@JsonProperty("results")
	private ArrayList<Person> result;
	
	public Result() {
	
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public String getNext() {
		return next;
	}

	public void setNext(String next) {
		this.next = next;
	}

	public ArrayList<Person> getResult() {
		return result;
	}

	public void setResult(ArrayList<Person> result) {
		this.result = result;
	}

	@Override
	public String toString() {
		return "Result: " + count + ", next=" + next + ", result=" + result;
	}
	
	

}
