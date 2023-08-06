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

import com.example.nutritionapi.models.AddItemReq;
import com.example.nutritionapi.models.DateReq;
import com.example.nutritionapi.models.DeleteDiaryReq;
import com.example.nutritionapi.models.DeleteEntryItemReq;
import com.example.nutritionapi.models.DiaryEntry;
import com.example.nutritionapi.models.NutrInfoReq;
import com.example.nutritionapi.models.NutritionInfo;
import com.example.nutritionapi.models.SignupReq;
import com.example.nutritionapi.models.SortCriteriaReq;
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

    @PostMapping(path="/sign-up")
    public void addUser(@RequestBody SignupReq newUserInfo) {
        //userService.addUser(newUserInfo.getUsername(), newUserInfo.getPassword());
        return;
    }

    @GetMapping(path="/delete-user")
    public void deleteUser(@AuthenticationPrincipal UserPrincipal principal){
        userService.deleteUser(principal.getUsername());
        return;
    }

    @GetMapping(path="get-entries")
    public ResponseEntity<List<DiaryEntry>> getUserDiaryEntries(@AuthenticationPrincipal UserPrincipal principal) {
        return new ResponseEntity<List<DiaryEntry>>(userService.getUserDiaryEntries(principal.getUserId()), HttpStatus.OK);
    }

    /* @GetMapping(path="get-entry")
    public ResponseEntity<DiaryEntry> getUserDiaryEntry(@AuthenticationPrincipal UserPrincipal principal) {
        return new ResponseEntity<DiaryEntry>(userService.getUserDiaryEntry(principal.getUserId()), HttpStatus.OK);
    } */

    @PostMapping(path="delete-entry")
    public void deleteSingleEntryFromCollection(@RequestBody DeleteDiaryReq deckIdToDelete, @AuthenticationPrincipal UserPrincipal principal) {
        //userService.deleteSingleEntryFromCollection(deckIdToDelete.getDeleteDiaryId());
        return;
    }

    @PostMapping(path="add-to-entry")
    public void addDataToDiaryEntry(@RequestBody AddItemReq item, @AuthenticationPrincipal UserPrincipal principal) {
        //userService.addDataToDiaryEntry(item.getItem(), principal.getUserId());
        return;
    }

    @PostMapping(path="add-entry")
    public void addDiaryEntryToCollection(@RequestBody Object data, @AuthenticationPrincipal UserPrincipal principal) {
        //userService.addDiaryEntryToCollection(data, principal.getUserId());
        return;
    }

    @PostMapping(path="delete-from-entry")
    public void deleteDataFromDiaryEntry(@RequestBody DeleteEntryItemReq deleteId, @AuthenticationPrincipal UserPrincipal principal) {
        //userService.deleteDataFromDiaryEntry(deleteId.getDiaryId(), deleteId.getDeleteEntryItemId(), principal.getUserId());
        return;
    }

    /* @GetMapping(path="sort-collection")
    public ResponseEntity<List<DiaryEntry>> getUserSortedCollection(@RequestBody SortCriteriaReq sortCriteria, @AuthenticationPrincipal UserPrincipal principal) {
        return new ResponseEntity<List<DiaryEntry>>(userService.getUserSortedCollection(sortCriteria.getSortCriteriaOne(), principal.getUserId()), HttpStatus.OK);
    } */

    /* @GetMapping(path="sort-diary")
    public ResponseEntity<DiaryEntry> getUserSortedDiary(@RequestBody SortCriteriaReq sortCriteria, @AuthenticationPrincipal UserPrincipal principal) {
        return new ResponseEntity<DiaryEntry>(userService.getUserSortedDiary(sortCriteria.getSortCriteriaTwo(), principal.getUserId()), HttpStatus.OK);
    } */

    @PostMapping(path="edit-diary-date")
    public void editDiaryDate(@RequestBody DateReq dateReq, @AuthenticationPrincipal UserPrincipal principal) {
        //userService.editDiaryDate(dateReq.getMonth(), dateReq.getDay(), dateReq.getYear(), dateReq.getDiaryId(), principal.getUserId());
        return;
    }

    /* @PostMapping(path="/get-nutr-info")
    public Object getNutritionInfo(@RequestBody NutrInfoReq item, @AuthenticationPrincipal UserPrincipal principal) {
        return userService.getNutritionInfo(item.getItem(), principal.getUserId());
    } */
}
