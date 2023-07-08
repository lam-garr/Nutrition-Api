package com.example.nutritionapi.controllers;

import java.util.List;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.nutritionapi.models.DiaryEntry;
import com.example.nutritionapi.models.NutritionInfo;
import com.example.nutritionapi.models.User;
import com.example.nutritionapi.security.UserPrincipal;
import com.example.nutritionapi.services.UserService;

@RestController
@RequestMapping("/api/v1/")
public class UserController {

    @Autowired
    private UserService userService;
    
    @GetMapping(path="/")
    public String getRootHome() {
        return "Welcome to nutrition api.";
    }

    @GetMapping("username")
    public String getUserId(@AuthenticationPrincipal UserPrincipal principal) {
        return principal.getUsername();
    }

    @GetMapping(path="/delete-user")
    public void deleteUser(){
        userService.deleteUser("");
        return;
    }

    @GetMapping(path="get-entries")
    public ResponseEntity<List<NutritionInfo>> getUserDiaryEntries(@AuthenticationPrincipal UserPrincipal principal) {
        return new ResponseEntity<List<NutritionInfo>>(userService.getUserDiaryEntries(principal.getUserId()), HttpStatus.OK);
    }

    /* @GetMapping(path="get-entry")
    public ResponseEntity<DiaryEntry> getUserDiaryEntry(@AuthenticationPrincipal UserPrincipal principal) {
        return new ResponseEntity<DiaryEntry>(userService.getUserDiaryEntry(principal.getUserId()), HttpStatus.OK);
    } */

    @PostMapping(path="delete-entry")
    public void deleteSingleEntryFromCollection(@RequestBody String deckIdToDelete, @AuthenticationPrincipal UserPrincipal principal) {
        //userService.deleteSingleEntryFromCollection(deckIdToDelete);
        return;
    }

    @PostMapping(path="add-to-entry")
    public void addDataToDiaryEntry(@RequestBody String item, @AuthenticationPrincipal UserPrincipal principal) {
        //userService.addDataToDiaryEntry(item, principal.getUserId());
        return;
    }

    @PostMapping(path="add-entry")
    public void addDiaryEntryToCollection(@RequestBody Object data, @AuthenticationPrincipal UserPrincipal principal) {
        //userService.addDiaryEntryToCollection(data, principal.getUserId());
        return;
    }

    @PostMapping(path="delete-from-entry")
    public void deleteDataFromDiaryEntry(@RequestBody String id, @RequestBody String deleteId, @AuthenticationPrincipal UserPrincipal principal) {
        //userService.deleteDataFromDiaryEntry(id, deleteId, principal.getUserId());
        return;
    }
}
