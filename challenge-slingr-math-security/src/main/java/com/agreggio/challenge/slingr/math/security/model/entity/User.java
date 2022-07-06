package com.agreggio.challenge.slingr.math.security.model.entity;

import com.agreggio.challenge.slingr.math.security.model.enums.UserRole;
import lombok.*;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;


@Entity
@Table(name = "user_table")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor(force = true, access = AccessLevel.PUBLIC)
@EntityListeners(AuditingEntityListener.class)
public class User extends Audit {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false)
	private Long id;

	private String firstName;

	private String userName;

	private String lastName;

	private String password;

	@Column(name = "role")
	@Enumerated(EnumType.STRING)
	private UserRole userRole;


	public User(String firstName, String userName, String lastName, String password, UserRole userRole) {
		this.firstName = firstName;
		this.userName = userName;
		this.lastName = lastName;
		this.password = password;
		this.userRole = userRole;
	}


}
