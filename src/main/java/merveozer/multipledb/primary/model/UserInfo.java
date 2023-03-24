package merveozer.multipledb.primary.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Data
@Table(name = "user_info")
@AllArgsConstructor
@NoArgsConstructor
public class UserInfo {
	@Id
	@Column(name = "id")
	private int id;
	
	@Column(name = "name")
	private String userName;

}
