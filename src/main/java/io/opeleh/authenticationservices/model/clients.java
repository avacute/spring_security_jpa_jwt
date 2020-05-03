package io.opeleh.authenticationservices.model;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;

@Entity
@Table(name="clients")
public class clients {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "client_id", nullable = false, unique = true, length = 25)
    private String clientID;

    @Column(name = "client_secret", nullable = false, length = 25)
    private String clientSecret;

    @Column(nullable = false, length = 100)
    private String location;

    @Column (nullable = false, length = 50)
    @Email
    private String email;

    @Column (nullable = false)
    private boolean isEnabled;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name = "client_resource", 
                joinColumns = @JoinColumn(name = "client_id", referencedColumnName = "id"), 
                inverseJoinColumns = @JoinColumn(name= "resource_id")
    )
    @Column(nullable = false)
    private Set <Resources> Resources;
    
    public clients() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getClientID() {
        return clientID;
    }

    public void setClientID(String clientID) {
        this.clientID = clientID;
    }

    public String getClientSecret() {
        return clientSecret;
    }

    public void setClientSecret(String clientSecret) {
        this.clientSecret = clientSecret;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isEnabled() {
        return isEnabled;
    }

    public void setEnabled(boolean isEnabled) {
        this.isEnabled = isEnabled;
    }

    public Set<Resources> getResources() {
        return Resources;
    }

    public void setResources(Set<Resources> resources) {
        Resources = resources;
    }

    

    
}