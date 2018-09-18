package no.syscomiddleware.digitalplayground.rest.controller;

import no.syscomiddleware.digitalplayground.rest.model.Tenant;
import no.syscomiddleware.digitalplayground.rest.service.TenantService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping(value = "/tenant",produces = "application/json", consumes = "application/json")
public final class TenantController {

    private Logger logger = LoggerFactory.getLogger(TenantController.class);
    private TenantService tenantService;
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    public TenantController(TenantService tenantService, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.tenantService = tenantService;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }


    @PostMapping("/sign-up")
    public void signup(@RequestBody Tenant tenant) {
        logger.info("Hello");
        tenant.setId(UUID.randomUUID().toString());
        tenant.setPassword(bCryptPasswordEncoder.encode(tenant.getPassword()));
        this.tenantService.save(tenant);
    }
}
