package com.example.PatchDemo.demo;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.fge.jsonpatch.JsonPatch;
import com.github.fge.jsonpatch.JsonPatchException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
public class PatchController {

    ArrayList<User> users = new ArrayList<>(Arrays.asList(new User(1,"Utkarsh","8896525920"),
            new User(2,"Raman","9415848556"),
            new User(3,"Ramesh","9450887128")));

    ObjectMapper objectMapper = new ObjectMapper();

    @PatchMapping(value = "/{id}", consumes = "application/json-patch+json")
    public ResponseEntity<?> applyPatch(@PathVariable Integer id, @RequestBody JsonPatch jsonPatch){
        try {
            User user = users.get(id);
            User userPatched = applyPatchToCustomer(jsonPatch, user);
            users.set(id,userPatched);
            return ResponseEntity.ok(userPatched);
        } catch (JsonPatchException | JsonProcessingException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    private User applyPatchToCustomer(
            JsonPatch patch, User targetCustomer) throws JsonPatchException, JsonProcessingException {
        JsonNode patched = patch.apply(objectMapper.convertValue(targetCustomer, JsonNode.class));
        return objectMapper.treeToValue(patched, User.class);
    }

    @RequestMapping("/fetch")
    public List<User> fetchUsers(){
        return users;
    }

}
