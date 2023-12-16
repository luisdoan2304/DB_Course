package course.luisDoan.data;

import java.util.Date;

public class Course {
	private int id;
	private String name;
	private Date begin;
	private Date end;
	private float fee;
	
	public Course() {}
	
	
	
	public Course(String name, Date begin, Date end, float fee) {
		super();
		this.name = name;
		this.begin = begin;
		this.end = end;
		this.fee = fee;
	}



	public Course(int id, String name, Date begin, Date end, float fee) {
		super();
		this.id = id;
		this.name = name;
		this.begin = begin;
		this.end = end;
		this.fee = fee;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getBegin() {
		return begin;
	}

	public void setBegin(Date begin) {
		this.begin = begin;
	}

	public Date getEnd() {
		return end;
	}

	public void setEnd(Date end) {
		this.end = end;
	}

	public float getFee() {
		return fee;
	}

	public void setFee(float fee) {
		this.fee = fee;
	}



	@Override
	public String toString() {
		return "Course [name=" + name + ", begin=" + begin + ", end=" + end + ", fee=" + fee + "]";
	}
	
	
}
