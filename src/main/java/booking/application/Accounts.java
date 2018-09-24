package booking.application;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;


@Entity
@EnableAutoConfiguration
@Table(name="accounts")
public class Accounts implements Serializable {

		
	
	/*@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SEQUENCE2")
	@SequenceGenerator(name="SEQUENCE2", sequenceName="accounts_id_account_seq", allocationSize=1)
	@Column(name="id_account")
	private Long idAccount;*/
	
	@Id
	@Column(name="login")
	@Size(min=6, max=20)
	@NotNull
	private String login;
	
	@Column(name="password")
	@Size(min=6, max=20)
	@NotNull
	private String password;
	
	@Column(name="enabled")
	@NotNull
	private int enabled;

	@OneToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_client", nullable=false)
	@JsonBackReference(value="accounts")
	private Clients client;
	
	@OneToMany(mappedBy="role")
	@JsonManagedReference(value="roles")
	private List<Roles> role;
	
	protected Accounts() {}
	
	public Accounts(Long idAccount, String login, String password, Clients client) {
		
		/*this.idAccount = idAccount;*/
		this.login = login;
		this.password = password;
		this.client = client;
	}
	
	@Override
	public String toString() {
		
		return String.format("login='%s', password='%s', idClient=%d]", login, password, client.getIdClient());
	}

	/*public Long getIdAccount() {
		return idAccount;
	}

	public void setIdAccount(Long idAccount) {
		this.idAccount = idAccount;
	}*/

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Clients getClient() {
		return client;
	}

	public void setClient(Clients client) {
		this.client = client;
	}
	
	public int getEnabled() {
		return enabled;
	}

	public void setEnabled(int enabled) {
		this.enabled = enabled;
	}
	public List<Roles> getRole() {
		return role;
	}

	public void setRole(List<Roles> role) {
		this.role = role;
	}

}
