package br.com.phdigitalcode.erp_auth.infra.entity;

import java.io.Serializable;
import java.util.List;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "user")
public class User implements Serializable {
	private static final long serialVersionUID = 1L;
//	@GenericGenerator(name = "UUID", strategy = "org.hibernate.id.uuid.UuidGenerator")
	@GeneratedValue(strategy = GenerationType.UUID)
	@Column(columnDefinition = "varchar(36)")
	private UUID id;
	private String userName;
	private String fullName;
	private String password;
	private Boolean accountNonExpired;
	private Boolean accountNonLocked;
	private Boolean credentialsNonExpired;
	private Boolean enabled;
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "user_permission", 
				joinColumns = {@JoinColumn(name = "id_user")},
				inverseJoinColumns = {@JoinColumn(name="id_permission" )})
	private List<User> users;
	private List<Permission> permission;

}
