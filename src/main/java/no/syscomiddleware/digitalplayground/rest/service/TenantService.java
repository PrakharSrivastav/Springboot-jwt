package no.syscomiddleware.digitalplayground.rest.service;

import no.syscomiddleware.digitalplayground.rest.model.Tenant;

public interface TenantService {
    Tenant findByTenant(String tenant);
    Tenant findById(String id);
    Boolean save(Tenant tenant);
}
