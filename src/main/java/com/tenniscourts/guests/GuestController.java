package com.tenniscourts.guests;

import com.tenniscourts.config.BaseRestController;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value = "/admin/guests")
@Api(value = "API REST Guests administration")
public class GuestController extends BaseRestController {

    @Autowired
    GuestService guestService;

    @ApiOperation(value = "Get a User List", httpMethod = "GET", produces = "application/json")
    @GetMapping(value = "/find", produces = "application/json")
    public List<Guest> guestList() {

        return guestService.findAll();
    }

    @ApiOperation(value = "Get a User by Id", httpMethod = "GET", produces = "application/json")
    @GetMapping(value = "/findById/{id}", produces = "application/json")
    public ResponseEntity<GuestDTO> findById(@PathVariable Long id) {
        return ResponseEntity.ok(guestService.findById(id));
    }

    @ApiOperation(value = "Get a User by name", httpMethod = "GET", produces="application/json")
    @GetMapping(value = "/findByName/{name}", produces = "application/json")
    public List<Guest> findByName(@PathVariable String name) {
        List<Guest> list = guestService.findByName(name);
        return list;
    }

    @ApiOperation(value = "Add a new guest user", httpMethod = "POST", consumes="application/json", produces = "application/json")
    @PostMapping(value = "/create", produces = "application/json")
    public ResponseEntity<Guest> insert(@RequestBody Guest guest) {
        Guest obj = guestService.insert(guest);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).body(obj);
    }

    @ApiOperation(value = "Delete a guest user", httpMethod = "DELETE")
    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        guestService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @ApiOperation(value = "Edit a guest user", httpMethod = "PATCH")
    @PatchMapping(value = "/edit/{id}")
    public ResponseEntity<Void> edit(@PathVariable Long id, @RequestBody Guest guest ) {
        guestService.edit(id, guest);
        return ResponseEntity.noContent().build();
    }
}
