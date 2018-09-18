package no.syscomiddleware.digitalplayground.rest.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Tenant {
    @Id
    private String id;
    private String tenant;
    private String password;

    public Tenant() {}

    public String getId() {return id;}

    public void setId(String id) {this.id = id;}

    public String getTenant() { return tenant;}

    public void setTenant(String tenant) { this.tenant = tenant; }

    public String getPassword() { return password; }

    public void setPassword(String password) { this.password = password; }
}
