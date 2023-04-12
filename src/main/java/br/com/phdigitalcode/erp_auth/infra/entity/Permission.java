package br.com.phdigitalcode.erp_auth.infra.entity;

import java.io.Serializable;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Entity
@EqualsAndHashCode
public class Permission implements Serializable {
	private static final long serialVersionUID = 1L;
//	@GenericGenerator(name = "UUID", strategy = "org.hibernate.id.uuid.UuidGenerator")
	@GeneratedValue(strategy = GenerationType.UUID)
	@Column(name="id_user",columnDefinition = "varchar(36)")
	private UUID id;
	private String description;

}
