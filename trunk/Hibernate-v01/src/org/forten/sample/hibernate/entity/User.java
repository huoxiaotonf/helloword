package org.forten.sample.hibernate.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

// 声明这个类是一个Hibernate可以识别的实体类
@Entity
// 声明这个类要被映射到后台的哪张表上，如果类名和表名一致，可以省略@Table后括号以及其中的配置
// 如果不一致则必须使用name属性指定此类要映射到的数据表的名称
@Table(name = "test_user")
public class User implements Serializable {
	private static final long serialVersionUID = -7385672097438707766L;
	
	// 声明这个属性是表中的主键
	@Id
	// 把成员变量映射到数据表中的某个字段上，如果名称一致，可以省略name属性的配置
	// 如果主键列名叫id，以下Column可以省略
	@Column(name = "id")
	private int id;
	@Column(name = "name")
	private String name;
	@Column(name = "age")
	private int age;
	@Column(name = "email")
	private String email;

	public User() {
		super();
	}

	public User(String name, int age, String email) {
		super();
		this.name = name;
		this.age = age;
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getId() {
		return id;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (id != other.id)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", age=" + age
				+ ", email=" + email + "]";
	}
}
