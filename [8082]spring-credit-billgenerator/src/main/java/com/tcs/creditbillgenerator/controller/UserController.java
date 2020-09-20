//package com.tcs.creditbillgenerator.controller;
//
//import java.util.List;
//
//import com.tcs.creditbillgenerator.entity.Purchase;
//import com.tcs.creditbillgenerator.entity.Users;
//import com.tcs.creditbillgenerator.service.UserService;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.DeleteMapping;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.PutMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RestController;
//
//@RestController
//public class UserController {
//
//    @Autowired
//    private UserService userService;
//
//	public void setUserService(UserService userService) {
//		this.userService = userService;
//	}
//
//    @GetMapping("/users")
//    public List<Users> getAllUsers() {
//        return userService.getAllUsers();
//    }
//
//    @GetMapping("/users/{id}")
//    public Users getUsersById(@PathVariable Integer id) {
//        return userService.getUserById(id);
//    }
//
//    @PostMapping("/users")
//    public void createUser(@RequestBody Users user) {
//        userService.createUser(user);
//    }
//
//    @PutMapping("/users/{id}")
//    public void updateUser(@PathVariable Integer id, @RequestBody Users user) {
//        userService.updateUser(id, user);
//    }
//
//    @DeleteMapping("/users/{id}")
//    public void deleteUser(@PathVariable Integer id) {
//        userService.deleteUser(id);
//    }
//
//    @PostMapping("/users/{id}/addpurchase")
//    public void addPurchase(@PathVariable Integer id, @RequestBody Purchase purchase) {
//        userService.addPurchase(id, purchase);
//    }
//
//    @DeleteMapping("/users/{id}/deletepurchase/{purchase_id}")
//    public void deletePurchase(@PathVariable Integer id, @PathVariable Integer purchase_id) {
//        userService.deletePurchase(id, purchase_id);
//    }
//}
