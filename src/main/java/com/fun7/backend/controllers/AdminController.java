package com.fun7.backend.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import com.fun7.backend.users.*;

@RestController
class AdminController {

  private final UserRepository repository;
  private final List<String> MULTIPLAYER_COUNTRIES = new ArrayList<String>();
  AdminController(UserRepository repository) {
    this.repository = repository;
    MULTIPLAYER_COUNTRIES.add("US");
  }
  
  
  @GetMapping("/admin/users/")
  @PreAuthorize("hasAuthority('user:read')")
  List<String> all() {
    return (repository.findAll().stream().map(user -> user.getUserId()).collect(Collectors.toList()));
  }

  // User Details
  
  @GetMapping("/admin/users/{id}")
  @PreAuthorize("hasAuthority('user:read')")
  User one(@PathVariable String id) {
    
    return repository.findById(id)
      .orElseThrow(() -> new UserNotFoundException(id));
  }

  // Delete User
  
  @DeleteMapping("/admin/users/{id}")
  @PreAuthorize("hasAuthority('user:delete')")
  void deleteEmployee(@PathVariable String id) {
    repository.deleteById(id);
  }
}