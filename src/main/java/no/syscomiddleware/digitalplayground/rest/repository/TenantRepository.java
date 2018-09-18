package no.syscomiddleware.digitalplayground.rest.repository;

import no.syscomiddleware.digitalplayground.rest.model.Tenant;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TenantRepository extends JpaRepository<Tenant, String> {

    Tenant findByTenant(String tenant);

    Optional<Tenant> findById(String id);

}
