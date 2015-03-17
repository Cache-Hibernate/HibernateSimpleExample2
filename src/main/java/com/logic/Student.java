package main.java.com.logic;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Student")
public class Student {

	private long id;
	private String name;
    private long age;
	private University university;

	public Student() {
	}

	public Student(String name, long age, University university) {
		this.name       = name;
        this.age        = age;
		this.university = university;
	}

	@Id
    @GeneratedValue(generator="increment")
    @GenericGenerator(name="increment", strategy = "increment")
	@Column(name = "id")
	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	@Column(name = "name", nullable = false, length = 100)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

    @Column(name="age")
    public Long getAge(){
        return age;
    }

    public void setAge(Long age){
        this.age = age;
    }

	@ManyToOne(cascade = CascadeType.ALL)
	public University getUniversity() {
		return this.university;
	}

	public void setUniversity(University university) {
		this.university = university;
	}

}