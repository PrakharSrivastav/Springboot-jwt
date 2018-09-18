package no.syscomiddleware.digitalplayground.rest.service.impl;

import no.syscomiddleware.digitalplayground.rest.model.Tenant;
import no.syscomiddleware.digitalplayground.rest.repository.TenantRepository;
import no.syscomiddleware.digitalplayground.rest.service.TenantService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
public class TenantServiceImpl implements UserDetailsService, TenantService {
    private Logger logger = LoggerFactory.getLogger(TenantServiceImpl.class);
    private TenantRepository tenantRepository;

    @Autowired
    public TenantServiceImpl(TenantRepository tenantRepository) {
        this.tenantRepository = tenantRepository;
    }

    @Override
    public Tenant findByTenant(final String t) {
        return this.tenantRepository.findByTenant(t);
    }

    @Override
    public Tenant findById(final String id) {
        return this.tenantRepository.findById(id).orElse(null);
    }

    @Override
    public Boolean save(final Tenant tenant) {
        try {
            this.tenantRepository.save(tenant);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public UserDetails loadUserByUsername(final String username) throws UsernameNotFoundException {
        final Tenant tenant = this.tenantRepository.findByTenant(username);
        if (tenant == null) {
            throw new UsernameNotFoundException(username);
        }
        logger.info("The tenant is {}", tenant.getTenant());
        return new User(tenant.getTenant(), tenant.getPassword(), Collections.emptyList());
    }
}
