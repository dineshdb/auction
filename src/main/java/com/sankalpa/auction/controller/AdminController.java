package com.sankalpa.auction.controller;

import com.sankalpa.auction.model.Admin;
import com.sankalpa.auction.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
public class AdminController {

    @Autowired
    private AdminService adminService;

    @GetMapping("/admins")
    public @ResponseBody Set<Admin> getAllAdmins(){
        return adminService.getAllAdmins();
    }

    @GetMapping("/admins/{adminId}")
    public @ResponseBody Admin getAdmin(@PathVariable Long adminId){
        return adminService.getAdmin(adminId);
    }

    @PostMapping("/admins")
    public @ResponseBody Admin addAdmin(@RequestBody Admin newAdmin){
        return adminService.addAdmin(newAdmin);
    }

    @PutMapping("/admins")
    public @ResponseBody Admin updateAdmin(@RequestBody Admin updatedAdmin){
        return adminService.updateAdmin(updatedAdmin);
    }

    @DeleteMapping("/admins/{adminId}")
    public void deleteAdmin(@PathVariable Long adminId){
        adminService.deleteAdmin(adminId);
    }
}
