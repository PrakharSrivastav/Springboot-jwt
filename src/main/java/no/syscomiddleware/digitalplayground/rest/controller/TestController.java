package no.syscomiddleware.digitalplayground.rest.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/test", produces = "application/json", consumes = "application/json")
public final class TestController {

    @GetMapping
    public ResponseEntity<Boolean> getResponse() {
        return ResponseEntity.ok(true);
    }
}
