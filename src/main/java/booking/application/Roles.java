package booking.application;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.ManyToAny;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@EnableAutoConfiguration
@Table(name="roles")
public class Roles implements Serializable{

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SEQUENCE6")
	@SequenceGenerator(name="SEQUENCE6", sequenceName="accounts_id_role_seq", allocationSize=1)
	@Column(name="id_role")
	private Long idRole;
	
	@Column(name="role")
	@NotNull
	private String role;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="login")
	@JsonBackReference(value="roles")
	private Accounts account;

	public Long getIdRole() {
		return idRole;
	}

	public void setIdRole(Long idRole) {
		this.idRole = idRole;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public Accounts getAccount() {
		return account;
	}

	public void setAccount(Accounts account) {
		this.account = account;
	}
	
	
	
}
